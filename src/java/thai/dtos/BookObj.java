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
public class BookObj {

    private int bookID;
    private String bookName;
    private String bookStatus;
    private String bookImage;
    private float bookPrice;
    private int bookQuantity;
    private String bookCreateDate;
    private String categoryID;
    private String bookAuthor;
    private String bookDescription;
    private boolean bookError;

    public BookObj(int bookID, String bookName, String bookStatus, String bookImage, float bookPrice, int bookQuantity, String bookCreateDate, String categoryID, String bookAuthor, String bookDescription) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookStatus = bookStatus;
        this.bookImage = bookImage;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.bookCreateDate = bookCreateDate;
        this.categoryID = categoryID;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
    }

    public BookObj(int bookID, String bookName, String bookImage, float bookPrice, String categoryID) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookPrice = bookPrice;
        this.categoryID = categoryID;
    }

    public BookObj(String bookName, String bookStatus, String bookImage, float bookPrice, int bookQuantity, String bookCreateDate, String categoryID, String bookAuthor, String bookDescription) {
        this.bookName = bookName;
        this.bookStatus = bookStatus;
        this.bookImage = bookImage;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.bookCreateDate = bookCreateDate;
        this.categoryID = categoryID;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
    }

    public boolean isBookError() {
        return bookError;
    }

    public void setBookError(boolean bookError) {
        this.bookError = bookError;
    }

    public BookObj(int bookID) {
        this.bookID = bookID;
    }

    public BookObj() {
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getBookCreateDate() {
        return bookCreateDate;
    }

    public void setBookCreateDate(String bookCreateDate) {
        this.bookCreateDate = bookCreateDate;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

}
