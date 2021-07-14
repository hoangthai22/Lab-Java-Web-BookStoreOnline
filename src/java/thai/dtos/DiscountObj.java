/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.dtos;

import java.sql.Timestamp;

/**
 *
 * @author ASUS
 */
public class DiscountObj {
    private String discountID;
    private String discountName;
    private float discountPercent;
    private String discountStatus;
    private Timestamp createDate;

    public DiscountObj(String discountID, String discountName, float discountPercent, String discountStatus, Timestamp createDate) {
        this.discountID = discountID;
        this.discountName = discountName;
        this.discountPercent = discountPercent;
        this.discountStatus = discountStatus;
        this.createDate = createDate;
    }

    public DiscountObj(String discountID, String discountName, float discountPercent, String discountStatus) {
        this.discountID = discountID;
        this.discountName = discountName;
        this.discountPercent = discountPercent;
        this.discountStatus = discountStatus;
    }

    public DiscountObj() {
    }

    public String getDiscountID() {
        return discountID;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public float getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(float discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountStatus() {
        return discountStatus;
    }

    public void setDiscountStatus(String discountStatus) {
        this.discountStatus = discountStatus;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
}
