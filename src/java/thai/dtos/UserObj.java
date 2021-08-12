/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.dtos;

/**
 *
 * @author ASUS
 */
public class UserObj {
    private String userID;
    private String userPassword;
    private String userFullName;
    private String userPhone;
    private String userEmail;
    private String userAddress;
    private String userRoleID;
    private String userStatus;
    private String userCreateDate;
    private String verificationCode;

   
    public UserObj() {
    }

    public UserObj(String userID, String userPassword, String userFullName, String userPhone, String userEmail, String userAddress, String userRoleID, String userStatus, String userCreateDate) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userFullName = userFullName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userRoleID = userRoleID;
        this.userStatus = userStatus;
        this.userCreateDate = userCreateDate;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(String userRoleID) {
        this.userRoleID = userRoleID;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(String userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
    
    
}
