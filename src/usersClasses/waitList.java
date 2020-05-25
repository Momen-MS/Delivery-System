/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersClasses;

/**
 *
 * @author momen-ms
 */
public class waitList {
    private int id ;
    private String name ;
    private String type;
    private String addres1 ;
    private String addres2;
    private String date;
    private String time ;
    private String totalTime;
    private String product ;
    private double priceOfProduct;
    private double priceOfdelivery;
    private double totalPrice;
    private int call_center_emp_id;
    private int driverId;
    private String dp_nmber;
    private String notes ;
    private String contactPhone;  

    public waitList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddres1() {
        return addres1;
    }

    public void setAddres1(String addres1) {
        this.addres1 = addres1;
    }

    public String getAddres2() {
        return addres2;
    }

    public void setAddres2(String addres2) {
        this.addres2 = addres2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public double getPriceOfdelivery() {
        return priceOfdelivery;
    }

    public void setPriceOfdelivery(double priceOfdelivery) {
        this.priceOfdelivery = priceOfdelivery;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCall_center_emp_id() {
        return call_center_emp_id;
    }

    public void setCall_center_emp_id(int call_center_emp_id) {
        this.call_center_emp_id = call_center_emp_id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDp_nmber() {
        return dp_nmber;
    }

    public void setDp_nmber(String dp_nmber) {
        this.dp_nmber = dp_nmber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    
    
}
