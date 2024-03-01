import java.sql.*;

public class databaseConnection {

    // JDBC connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/orderingsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";


    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // Handle the exception appropriately (e.g., log it)
            e.printStackTrace();
            throw new RuntimeException("Database connection error: " + e.getMessage());
        }
        return connection;
    }

    private static Boolean selectTable(Connection connection,String tableName) throws SQLException {
        String selectQuery = "SELECT * FROM " + tableName;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {

            // Process the result set
            while (resultSet.next()) {
                int foodID = resultSet.getInt("foodID");
                String foodName = resultSet.getString("foodName");
                double foodPrice = resultSet.getDouble("foodPrice");

                System.out.println("Food ID: " + foodID);
                System.out.println("Food Name: " + foodName);
                System.out.println("Food Price: $" + foodPrice);
                System.out.println("--------------");
            }
            return true;
        }
    }

    private static Boolean updateLoginPassword(Connection connection, String username,String newPlainPassword) throws SQLException{
        String query = "update loginDetails set loginPassword = ? where loginUsername = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)){
//            encrypt the password
            statement.setString(1,configs.encrypt(newPlainPassword));
            statement.setString(2,username);
            int rowAffected = statement.executeUpdate();
            if (rowAffected >0) {
                System.out.println("Update successful!");
                return true;
            }else{
                System.out.println("No matching user found for update.");
                throw new RuntimeException("No matching user found for update.");
            }
        }
    }

    public static String getPasswordHash(Connection connection,String username) throws SQLException{ //get password hash from the database
        String query = "select loginPassword from loginDetails where loginUsername = ?"; //query to get password hash
        try (PreparedStatement statement = connection.prepareStatement(query)){ //prepare statement
            statement.setString(1,username); //set username
            ResultSet resultSet = statement.executeQuery();  //execute query
            if (resultSet.next()){ //if result set is not empty
                return resultSet.getString("loginPassword"); //return password hash
            }
        }
        return null; //return null if no matching user found
    }

//    get login username from the database
    public static String getLoginUsername(Connection connection,String username) throws SQLException{
        String query =  "select loginUsername from loginDetails where loginUsername = ?"; //query to get login username
        try (PreparedStatement statement = connection.prepareStatement(query)){ //prepare statement
            statement.setString(1,username); //set username
            ResultSet resultSet = statement.executeQuery(); //execute query
            if (resultSet.next()){ //if result set is not empty
                return resultSet.getString("loginUsername"); //return login username
            }
        }
        return null; //return null if no matching user found
    }





}