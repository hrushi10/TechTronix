package Model;

import java.util.List;

public class OrderData {

    private String customerName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String cvv;
    private List<CartItem> cartItems;

    // Default constructor
    public OrderData() {}

    // Parameterized constructor
    public OrderData(String customerName, String address, String city, String state, String country,String zip, 
                     String cardName, String cardNumber, String expiration, String cvv, 
                     List<CartItem> cartItems) {
    	
        this.customerName = customerName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvv = cvv;
        this.cartItems = cartItems;
    }

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;}
    
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
