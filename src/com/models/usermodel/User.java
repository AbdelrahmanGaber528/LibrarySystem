package com.models.usermodel;

import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
    private String userName;
    private int ID = 0;
    private  String password;
    private String phone;
    private String preferences ;

    private static final Logger logger = Logger.getLogger(User.class.getName());

    public User(String userName, String password){
            this(userName,"0000000000",password);
    }
    public User(String userName , String phone , String password){
        setUserName(userName);
        setPassword(password);
        setPhone(phone);
        this.ID++;
    }
    @Override
    public String toString(){
        return "User Name : "+this.userName +"\nID: "+this.ID+"\nContact: "+this.phone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int  getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            if (password.length() >= 6) {
                this.password = password;
            } else {
                throw new IllegalArgumentException("Password must be at least 6 characters.");
            }
        } catch (IllegalArgumentException e) {
            // Log the exception
            logger.log(Level.SEVERE, "Error setting password: " + e.getMessage(), e);
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        try {
            if (phone.matches("\\d{10,}")) {
                this.phone = phone;
            } else {
                throw new IllegalArgumentException("Phone number must contain at least 10 digits.");
            }
        } catch (IllegalArgumentException e) {
            // Log the exception
            logger.log(Level.SEVERE, "Invalid phone number format: " + e.getMessage(), e);
        }
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
    public String getPreferences(){
        return preferences != null ? preferences : "No preferences set.";
    }

    public void userInfo() {
        logger.log(Level.INFO, "User info: {0}, {1}", new Object[]{userName, ID});
    }
}
