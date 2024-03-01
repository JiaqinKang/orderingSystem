import at.favre.lib.crypto.bcrypt.BCrypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class loginGui {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel main;
    private JButton loginButton;
    private JPanel loginPanel;
    private JPanel inputPanel;
    private JCheckBox autoLoginCheckBox;
    private JPanel loginButtonPanel;
    private JComboBox languageList;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel language;
    private JLabel title;

    String username;
    String password;

    public Boolean verifiedLogin = false;


    //method change language
    private void changeLanguage(String language) {
        switch (language) {
            case "English":
                title.setText("Login to the system");
                usernameLabel.setText("Username");
                passwordLabel.setText("Password");
                autoLoginCheckBox.setText("Auto Login");
                loginButton.setText("Login");
                break;
            case "中文":
                title.setText("登录");
                usernameLabel.setText("用户名");
                passwordLabel.setText("密码");
                autoLoginCheckBox.setText("自动登录");
                loginButton.setText("登录");
                break;
        }
    }

    private void autoLoginCheck(JFrame frame) {
        if (configs.getAutologin() == true) {
            if (loginChecking(configs.getUsername(), configs.getPassword(), configs.getAutologin())) {//if login success
                System.out.println("Auto login success");
                new dashboardGui();
                frame.dispose();//close login gui
            }
        }
    }


    //call main panel
    public loginGui() {
        //load config file
        configs.load();
        System.out.println("load success");

        //set username and password
        usernameField.setText(configs.getUsername());

        //set language
        changeLanguage(configs.getLanguage());

        //set language index
        languageList.setSelectedItem(configs.getLanguage());

        //set auto login checkbox status
        autoLoginCheckBox.setSelected(configs.getAutologin());

        JFrame frame = new JFrame("Ordering System");
        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 400);
        //make the window open in the center of the screen
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        //switch language
        languageList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (languageList.getSelectedIndex()) {
                    case 0: //English
                        configs.setLanguage("English");
                        //set first caseBox to english
                        languageList.setSelectedIndex(0);
                        changeLanguage("English");
                        break;
                    case 1: //中文
                        configs.setLanguage("中文");
                        //set first caseBox to 中文
                        languageList.setSelectedIndex(1);
                        changeLanguage("中文");
                        break;
                }
            }
        });


        //check if autologin is checked
        autoLoginCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configs.setAutologin(autoLoginCheckBox.isSelected());

            }
        });


        //login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get username and password
                username = usernameField.getText(); //get username
                password = passwordField.getText(); //get password
                configs.setUsername(username);
                configs.setPassword(password);
                if (loginChecking(username, password, configs.getAutologin())) {//if login success
                    configs.write();
                    new dashboardGui();
                    frame.dispose();//close login gui
                }
            }
        });

        autoLoginCheck(frame);
    }

    private void displayLoginErrorMessage(int number) {
//        case one is for empty username and password
        switch (number) {
            case 0:
                if (configs.getLanguage().equals("English")) {
                    System.out.println("Username or password cannot be empty");
                    JOptionPane.showMessageDialog(null, "Username or password cannot be empty");
                } else {
                    System.out.println("用户名或密码不能为空");
                    JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
                }
                break;
            //        case two is for incorrect username and password
            default:
                if (configs.getLanguage().equals("English")) {
                    System.out.println("Incorrect username or password");
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                } else {
                    System.out.println("用户名或密码不正确");
                    JOptionPane.showMessageDialog(null, "用户名或密码不正确");
                }
                break;
        }

    }

    private boolean loginChecking(String username, String password, boolean autoLogin) {
        System.out.println(username);
        System.out.println(password);
        String bcryptHashString = null;
        BCrypt.Result result = null;
        try { //try to get the password hash from the database
            Connection connection = databaseConnection.getConnection(); //get connection
            bcryptHashString = databaseConnection.getPasswordHash(connection, username); //get password hash from the database using the username
            result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
            if (bcryptHashString == null) {
                System.out.println("No matching user found");
                return false;
            }
        } catch (SQLException e) { //catch SQL exception like username not found which causes an error
            System.out.println("SQL error");
            JOptionPane.showMessageDialog(null, "SQL error");
            return false;
        }
        if (autoLogin) { //if auto login is checked
            if (result.verified) {
                System.out.println("Login success");
                return true;
            }
        } else { //if auto login is not checked
            if (username.isEmpty() || password.isEmpty()) { //if username or password is empty
                displayLoginErrorMessage(0); //display error message
                return false;
            }
        }
        displayLoginErrorMessage(1);
        return false;
    }
}