import javax.swing.*;
import java.io.*;

public class configs {
    static boolean autologin;
    static String username;
    static String password;
    static String language;
    static String googleMapAPIKey;
    static File file = new File("config.txt");

    //constructor
    public configs(boolean autologin, String username, String password, String language, String googleMapAPIKey) {
        configs.autologin = autologin;
        configs.username = username;
        configs.password = password;
        configs.language = language;
        configs.googleMapAPIKey = googleMapAPIKey;
    }

    //read config file and assign values to variables
    public static void load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("autologin")) {
                    autologin = Boolean.parseBoolean(line.substring(line.indexOf("=") + 1));
                } else if (line.contains("username")) {
                    username = line.substring(line.indexOf("=") + 1);
                } else if (line.contains("password")) {
                    password = line.substring(line.indexOf("=") + 1);
                } else if (line.contains("language")) {
                    language = line.substring(line.indexOf("=") + 1);
                } else if (line.contains("api")) {
                    googleMapAPIKey = line.substring(line.indexOf("=") + 1);
                }
            }
            br.close();
            //if after reading the file, the variables are not assigned
            if (username == null || password == null || language == null || googleMapAPIKey == null) {
                //set default values
                defaultConfig();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //check if a setting exist in the config.txt file
    public static Boolean checkSetting(String target) {
        if (file.exists()) { //if the file exists
            try { //try to read the file
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains(target)) {
                        switch (target) {
                            case "autologin", "username", "password", "language", "api" -> {
                                br.close();
                                //return the value of the setting
                                return true;
                            }
                        }
                    }
                }
            } catch (IOException e) { //if the file cannot be read
                e.printStackTrace();
                System.out.println("Error: " + target + " not found in config.txt");
            }
        }//if the file does not exist
            System.out.println("Error: config.txt not found");
            return false;
    }



    //write all to the config.txt file
    public static void write() {
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println("autologin=" + autologin);
            pw.println("username=" + username);
            pw.println("password=" + password);
            pw.println("language=" + language);
            pw.println("api=" + googleMapAPIKey);
            pw.close();
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


        //default config file
    public static void defaultConfig() {
        //write to config file
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println("autologin=false");
            pw.println("username=username");
            pw.println("password=password");
            pw.println("language=English");
            pw.println("api=insert_api_key_here");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean getAutologin() {
        return autologin;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }


    public static String getLanguage() {
        return language;
    }


    public static String getGoogleMapAPIKey() {
        return googleMapAPIKey;
    }

    public static void setAutologin(boolean autologin) {
        configs.autologin = autologin;
    }

    public static void setUsername(String newUsername) {
        if (checkSetting(username) && !configs.username.equals(newUsername)) {
            configs.username = newUsername;
            write();
        }else {
            //message pop up to the user that username is already set to the same value
            JOptionPane.showMessageDialog(null, "Username is the same"+ ", no changes made");

        }
    }

    public static void setPassword(String newPassword) {
        if (checkSetting("password") && !configs.password.equals(newPassword)) {
            encryption.encrypt(password);//call encryption to encrypt password
            configs.password = newPassword;
            write();
        }else {
            //message pop up to user that password is already set to the same value
            JOptionPane.showMessageDialog(null, "Password is the same"+ ", no changes made");
        }
    }

    public static void setLanguage(String newLanguage) {
        if (checkSetting("language") && !configs.language.equals(newLanguage)) {
            configs.language = newLanguage;
            write();
        }else {
            //message pop up to user that language is already set
            JOptionPane.showMessageDialog(null, "Language is the same"+ ", no changes made");
        }
    }

    public static void setGoogleMapAPIKey(String newGoogleMapAPIKey) {
        configs.googleMapAPIKey = newGoogleMapAPIKey;
        write();
    }
}
