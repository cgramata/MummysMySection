/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author syntel
 */
public class Orders {
    private int orderID;
    private int customerID;
    private int creditID;
    private int paymentType;
    private double totalPrice;
    private String street;
    private String city;
    private int areaCode;
    private String phoneNumber;
    private String deliveryDate;
    private String orderDate;
    private int orderStatus;
    
    public Orders(){
    }

    public Orders(int orderID, int customerID, int creditID, int paymentType, 
            double totalPrice, String street, String city, int areaCode, 
            String phoneNumber, String deliveryDate, String orderDate, int orderStatus) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.creditID = creditID;
        this.paymentType = paymentType;
        this.totalPrice = totalPrice;
        this.street = street;
        this.city = city;
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCreditID() {
        return creditID;
    }

    public void setCreditID(int creditID) {
        this.creditID = creditID;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", customerID=" + customerID +
                ", creditID=" + creditID + ", paymentType=" + paymentType + 
                ", totalPrice=" + totalPrice + ", street=" + street + ", city=" + 
                city + ", areaCode=" + areaCode + ", phoneNumber=" + phoneNumber + 
                ", deliveryDate=" + deliveryDate + ", orderDate=" + orderDate + 
                ", orderStatus=" + orderStatus + '}';
    }
    
    
    
}
