/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.pojo;

/**
 *
 * @author hp
 */
public class OrdersPojo {

    @Override
    public String toString() {
        return "OrdersPojo{" + "order_id=" + order_id + ", p_id=" + p_id + ", Quantity=" + Quantity + '}';
    }
    public OrdersPojo(){
    }
    public OrdersPojo(String order_id, String p_id, int Quantity) {
        this.order_id = order_id;
        this.p_id = p_id;
        this.Quantity = Quantity;
    }
    private String order_id;
    private String p_id;
    private int Quantity;
    
}
