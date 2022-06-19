import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginGui {

    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel main;
    private JButton loginButton;
    private JPanel loginPanel;
    private JPanel inputPanel;
    private JCheckBox autoLoginCheckBox;
    private JPanel loginButtonPanel;
    private JComboBox comboBox1;
    private JLabel username;
    private JLabel password;
    private JLabel language;
    private JLabel title;


    //method change language
    private void changeLanguage(String language) {
        switch (language) {
            case "English":
                title.setText("Login to the system");
                username.setText("Username");
                password.setText("Password");
                autoLoginCheckBox.setText("Auto Login");
                loginButton.setText("Login");
                break;
            case "中文":
                title.setText("登录");
                username.setText("用户名");
                password.setText("密码");
                autoLoginCheckBox.setText("自动登录");
                loginButton.setText("登录");
                break;
        }
    }



    //call main panel
    public loginGui() {
        //load config file
        configs.load();

        //set language
        changeLanguage(configs.language);

        //set language index
        comboBox1.setSelectedItem(configs.language);

        //set auto login
        autoLoginCheckBox.setSelected(configs.autologin);


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
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBox1.getSelectedIndex()) {
                    case 0: //English
                        configs.setLanguage("English");
                        configs.write();
                        //set first caseBox to english
                        comboBox1.setSelectedIndex(0);
                        changeLanguage("English");
                        break;
                    case 1: //中文
                        configs.setLanguage("中文");
                        configs.write();
                        //set first caseBox to 中文
                        comboBox1.setSelectedIndex(1);
                        changeLanguage("中文");
                        break;
                }
            }
        });
        //auto login

        //check if autologin is checked
        autoLoginCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configs.setAutologin(autoLoginCheckBox.isSelected());
                configs.write();
            }
        });







        //login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(login()) {//if login success
                    new dashboardGui();
                    frame.dispose();//close login gui
                }
            }
        });
    }

    public Boolean login() {
        //get username and password
        String username = textField1.getText();
        String password = String.valueOf(passwordField1.getPassword());
        //check if username and password are empty
        if (username.equals("") || password.equals("")) {
            if (configs.language.equals("English")) {
                JOptionPane.showMessageDialog(null, "Username or password cannot be empty");
            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
            }
            return false; //return false if username or password is empty
        }else {
            //check if username and password are correct
            if (username.equals(configs.getUsername()) && password.equals(configs.getPassword())) {
                if (configs.language.equals("English")) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(null, "登录成功");
                }
                return true; //return true if username and password are correct
            } else {//username and password are not correct
                if (configs.language.equals("English")) {
                    JOptionPane.showMessageDialog(null, "Username or password is incorrect");
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
                }
                return false; //return false if username and password are not correct
            }
        }
    }

    //run application
    public static void main(String[] args) {
        new loginGui();
    }




}
