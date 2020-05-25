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
public class ready_drivers {
    private int id ;
    private String name;
    private String transportaion;
    private int orders_num ;
    private String waiting_time;
    private String ready_time;

    public ready_drivers() {
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

    public String getTransportaion() {
        return transportaion;
    }

    public void setTransportaion(String transportaion) {
        this.transportaion = transportaion;
    }

    public int getOrders_num() {
        return orders_num;
    }

    public void setOrders_num(int orders_num) {
        this.orders_num = orders_num;
    }

    public String getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(String waiting_time) {
        this.waiting_time = waiting_time;
    }

    public String getReady_time() {
        return ready_time;
    }

    public void setReady_time(String ready_time) {
        this.ready_time = ready_time;
    }
    
    
    
}
