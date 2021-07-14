/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class CartObj implements Serializable {

    private String customerName;
    private HashMap<Integer, BookObj> cart;
    private DiscountObj discount;

    public CartObj(String customerName, HashMap<Integer, BookObj> cart) {
        this.customerName = customerName;
        this.cart = cart;
    }

    public CartObj(String customerName, HashMap<Integer, BookObj> cart, DiscountObj discount) {
        this.customerName = customerName;
        this.cart = cart;
        this.discount = discount;
    }

    public CartObj() {
    }

    public DiscountObj getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountObj discount) {
        this.discount = discount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<Integer, BookObj> getCart() {
        return cart;
    }

    public void setCart(HashMap<Integer, BookObj> cart) {
        this.cart = cart;
    }

    public void addToCart(BookObj dto) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(dto.getBookID())) {
            int quantity = this.cart.get(dto.getBookID()).getBookQuantity() + 1;
            dto.setBookQuantity(quantity);
        }
        this.cart.put(dto.getBookID(), dto);

    }

    public boolean removeItemFromCart(int id) {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
            return true;
        }
        return false;
    }

    public boolean updateCart(BookObj dto, int quantity) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        boolean result = false;
        if (this.cart.containsKey(dto.getBookID())) {
            this.cart.get(dto.getBookID()).setBookQuantity(quantity);
            result = true;
        } else {
            dto.setBookQuantity(quantity);
            this.cart.put(dto.getBookID(), dto);
        }
        return result;
    }

    public boolean updateCartByID(int id, int quantity) {
        boolean result = false;
        if (this.cart.containsKey(id)) {
            this.cart.get(id).setBookQuantity(quantity);
            result = true;
        }
        return result;  
    }
    
    

    public double getTotalPriceByDiscount(double discount) {
        double total = 0;
        if (this.cart == null) {
            this.cart = new HashMap<>();
            return 0;
        } else if (discount >= 0 || discount <= 100) {
            for (Map.Entry<Integer, BookObj> entry : cart.entrySet()) {
                total += (entry.getValue().getBookQuantity() * entry.getValue().getBookPrice());
            }
            if (discount == 0) {
                return total;
            }
            total = total * (discount / 100);

        }
        return total;
    }

    public double getTotalPrice() {
        double total;
        if(discount == null) return  this.getTotalPriceByDiscount(0) + 5;
        total = this.getTotalPriceByDiscount(0) - this.getTotalPriceByDiscount(this.discount.getDiscountPercent())  + 5;
        return total;
    }

}
