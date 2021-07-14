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
public class OrderObj {
    private String orderID;
    private String orderUser;
    private Timestamp orderDate;
    private String orderStatus;
    private String orderAddress;
    private String orderPhone;
    private float orderTotal;
    private float orderSubTotal;
    private String orderDiscount;
    private String orderType;
    private float orderTax;
    private float orderShip;

    public OrderObj(String orderID, String orderUser, Timestamp orderDate, String orderStatus, String orderAddress, String orderPhone, float orderTotal, String orderDiscount, String orderType) {
        this.orderID = orderID;
        this.orderUser = orderUser;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderAddress = orderAddress;
        this.orderPhone = orderPhone;
        this.orderTotal = orderTotal;
        this.orderDiscount = orderDiscount;
        this.orderType = orderType;
    }

    public OrderObj(String orderID, String orderUser, Timestamp orderDate, String orderStatus, String orderAddress, String orderPhone, float orderTotal, float orderSubTotal, String orderDiscount, String orderType, float orderTax, float orderShip) {
        this.orderID = orderID;
        this.orderUser = orderUser;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderAddress = orderAddress;
        this.orderPhone = orderPhone;
        this.orderTotal = orderTotal;
        this.orderSubTotal = orderSubTotal;
        this.orderDiscount = orderDiscount;
        this.orderType = orderType;
        this.orderTax = orderTax;
        this.orderShip = orderShip;
    }

    public OrderObj(String orderID, String orderUser, float orderTotal, float orderSubTotal, float orderTax, float orderShip) {
        this.orderID = orderID;
        this.orderUser = orderUser;
        this.orderTotal = orderTotal;
        this.orderSubTotal = orderSubTotal;
        this.orderTax = orderTax;
        this.orderShip = orderShip;
    }

    
    public OrderObj() {
    }

    public float getOrderSubTotal() {
        return orderSubTotal;
    }

    public void setOrderSubTotal(float orderSubTotal) {
        this.orderSubTotal = orderSubTotal;
    }

    public float getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(float orderTax) {
        this.orderTax = orderTax;
    }

    public float getOrderShip() {
        return orderShip;
    }

    public void setOrderShip(float orderShip) {
        this.orderShip = orderShip;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(String orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    
}
