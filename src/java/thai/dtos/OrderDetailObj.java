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
public class OrderDetailObj {

    private String orderDetailID;
    private String orderID;
    private int bookID;
    private int amount;

    public OrderDetailObj(String orderDetailID, String orderID, int bookID, int amount) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.bookID = bookID;
        this.amount = amount;
    }

    public OrderDetailObj(String orderID, int bookID, int amount) {
        this.orderID = orderID;
        this.bookID = bookID;
        this.amount = amount;
    }

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
