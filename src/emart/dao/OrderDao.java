/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductsPojo;
import emart.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class OrderDao {
     public static String getNextOrderId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select max(order_id) from orders");
        rs.next();
        String ordId=rs.getString(1);
        if(ordId==null)
            return "O-101";
        int ordno=Integer.parseInt(ordId.substring(2));
        ordno++;
        return "O-"+ordno;
    }
    public static boolean addOrder(ArrayList<ProductsPojo> a1, String ordId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("Insert into orders values (?,?,?,?)");
        int count=0;
        for(ProductsPojo p:a1){
            ps.setString(1,ordId);
            ps.setString(2, p.getProductId());
            ps.setInt(3, p.getQuantity());
            ps.setString(4, UserProfile.getUserid());
            count+=ps.executeUpdate();
        }
        return count==a1.size();
    }
    
    public static List<String> getAllOrderIds() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select Distinct order_id from orders where userid=?");
        List<String>orderIds = new ArrayList<>();
        while(rs.next()){
            //System.out.println(rs.getString(1));
            orderIds.add(rs.getString(1));
        }
        return orderIds;
    }
    
    public static List<String> getAllOrderIds(String userid) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement st = conn.prepareStatement("Select Distinct order_id from orders where userid=?");
        st.setString(1,userid);
        ResultSet rs = st.executeQuery();
        List<String>orderIds = new ArrayList<>();
        while(rs.next()){
            //System.out.println(rs.getString(1));
            orderIds.add(rs.getString(1));
        }
        return orderIds;
    }
    
    public static ArrayList<ProductsPojo> getOrdersDetail(String ordId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select p_id,Quantity from orders where order_id=? ");
        ps.setString(1,ordId);
        ResultSet rs = ps.executeQuery();
        ArrayList<ProductsPojo> al = new ArrayList<>();
        while(rs.next()){
            PreparedStatement ps1 = conn.prepareStatement("Select * from products where p_id=?");
            ps1.setString(1,rs.getString(1));
            ResultSet rs1 = ps1.executeQuery();
            ProductsPojo p = new ProductsPojo();
            rs1.next();
            p.setOurPrice(rs1.getDouble("OUR_PRICE"));
            p.setProductCompany(rs1.getString("P_COMPANYNAME"));
            p.setProductId(rs1.getString("P_ID"));
            p.setProductName(rs1.getString("P_Name"));
            p.setProductPrice(rs1.getDouble("P_Price"));
            p.setQuantity(rs.getInt("Quantity"));
            p.setTax(rs1.getInt("P_Tax"));
            al.add(p);
        }
        return al;
    }
    
    public static ArrayList<ProductsPojo> getCurrentOrder(String ordId,String userid) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select p_id,Quantity from orders where order_id=? and userid=?");
        ps.setString(1,ordId);
        ps.setString(2,userid);
        ResultSet rs = ps.executeQuery();
        ArrayList<ProductsPojo> al = new ArrayList<>();
        while(rs.next()){
            PreparedStatement ps1 = conn.prepareStatement("Select * from products where p_id=?");
            ps1.setString(1,rs.getString(1));
            ResultSet rs1 = ps1.executeQuery();
            ProductsPojo p = new ProductsPojo();
            rs1.next();
            p.setOurPrice(rs1.getDouble("OUR_PRICE"));
            p.setProductCompany(rs1.getString("P_COMPANYNAME"));
            p.setProductId(rs1.getString("P_ID"));
            p.setProductName(rs1.getString("P_Name"));
            p.setProductPrice(rs1.getDouble("P_Price"));
            p.setQuantity(rs.getInt("Quantity"));
            p.setTax(rs1.getInt("P_Tax"));
            al.add(p);
        }
        return al;
        
    }
    
}
