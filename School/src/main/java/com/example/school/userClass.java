package com.example.school;

public class userClass {
    private String UserName,UserPassword,UserRole;
    private int UserID;

    public userClass(String userName, String userPassword, String userRole, int userID) {
        UserName = userName;
        UserPassword = userPassword;
        UserRole = userRole;
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String userRole) {
        UserRole = userRole;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }
}
