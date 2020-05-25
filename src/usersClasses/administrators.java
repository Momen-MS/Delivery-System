/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersClasses;

import java.sql.Date;

/**
 *
 * @author momen-ms
 */
public class administrators {
   private int id ;
   private String name ;
   private String phone ;
   private String email ;
   private String pass;
   private String dob ;
   private String local_tel;
   private double salary;

    public administrators() {
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

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLocal_tel() {
        return local_tel;
    }

    public void setLocal_tel(String local_tel) {
        this.local_tel = local_tel;
    }

   

    

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
   
    
}
