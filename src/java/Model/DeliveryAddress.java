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
public class DeliveryAddress {
    private String street;
    private String city;
    private String areaCode;
    private String phoneNumber;
    private String deliveryDate;
    
    public DeliveryAddress(){
    }

    public DeliveryAddress(String street, String city, String areaCode, String phoneNumber, 
                           String deliveryDate, String orderDate) {
        this.street = street;
        this.city = city;
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
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
}
