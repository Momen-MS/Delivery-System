/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersClasses;

import java.sql.Timestamp;

/**
 *
 * @author momen-ms
 */
public class Customers {
    private int id ;
    private String name;
    private String Phone ;
    private String addres1;
    private String addres2;
    private String lastOrder;
    private int numberOfOrdes;
    private String dp_number ;

    public Customers() {
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

    public void setName(String Name) {
        this.name = Name;
    }

    public String getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(String lastOrder) {
        this.lastOrder = lastOrder;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
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



   

    public String getDp_number() {
        return dp_number;
    }

    public void setDp_number(String dp_number) {
        this.dp_number = dp_number;
    }

    public int getNumberOfOrdes() {
        return numberOfOrdes;
    }

    public void setNumberOfOrdes(int numberOfOrdes) {
        this.numberOfOrdes = numberOfOrdes;
    }
    
    
}
