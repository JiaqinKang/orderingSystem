import at.favre.lib.crypto.bcrypt.BCrypt;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

public class configs {
    static boolean autologin;
    static String username;
    static String password;
    static String language;
    static String googleMapAPIKey;
    static File file = new File("config.txt");

    //read config file and assign values to variables if the file exists else values are set to null
    public static boolean load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("autologin")) {
                    autologin = Boolean.parseBoolean(line.substring(line.indexOf("=") + 1));
                    System.out.println(autologin);
                } else if (line.contains("username")) {
                    username = line.substring(line.indexOf("=") + 1);
                    System.out.println(username);
                } else if (line.contains("password")) {
                    password = line.substring(line.indexOf("=") + 1);
                    System.out.println(password);
                } else if (line.contains("language")) {
                    language = line.substring(line.indexOf("=") + 1);
                    System.out.println();
                } else if (line.contains("api")) {
                    googleMapAPIKey = line.substring(line.indexOf("=") + 1);
                    System.out.println(googleMapAPIKey);
                }
            }
            br.close();
            return true;
        } catch (IOException e) {
            //set values to null if the file does not exist
            autologin = false;
            username = null;
            password = null;
            language = "English";
            googleMapAPIKey = null;
            System.out.println("Config file not found");
        }
        return false;
    }


    //write all to the config.txt file
    public static void write() {
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println("autologin=" + getAutologin());
            pw.println("username=" + getUsername());
            pw.println("password=" + getPassword());
            pw.println("language=" + getLanguage());
            pw.println("api=" + getGoogleMapAPIKey());
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
            pw.println("autologin="+true);
            pw.println("username="+ "admin");
            pw.println("password="+ "admin");
            pw.println("language="+ "中文");
            pw.println("api="+getGoogleMapAPIKey());
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

    }

    public static void setPassword(String newPassword) {
    }

    public static void setLanguage(String newLanguage) {

    }

    public static void setGoogleMapAPIKey(String newGoogleMapAPIKey) {
        configs.googleMapAPIKey = newGoogleMapAPIKey;
    }

    public static String encrypt(String secret){
        return BCrypt.withDefaults().hashToString(12, secret.toCharArray());
    }
}
