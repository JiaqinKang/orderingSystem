import at.favre.lib.crypto.bcrypt.BCrypt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class main {
    public static void main(String[] args) {

//        test selectTable
//        try {
//            List<Map<String, Object>> ans = databaseConnection.selectTable(databaseConnection.getConnection(), "foodmenu");
//            for (Map<String, Object> map : ans) {
//                System.out.println(map);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


//        test loginChecking gui
        new loginGui();

    }
}
