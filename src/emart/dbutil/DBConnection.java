
package emart.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection {
    
    private static Connection conn;
    static
    {
        try
        {
            //Class.forName("oracle.jdbc.OracleDriver");
           // conn=DriverManager.getConnection("jdbc:oracle:thin:@//RP:1521/XE","myproject","java");
             Class.forName("oracle.jdbc.OracleDriver");// Driver load kiya
             conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-SBTLM0R:1521/XE","grocery","grocery");
            JOptionPane.showMessageDialog(null,"Connection opened succesfully!","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in loading the driver","Driver Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in opening the Connection","DB Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null,"Connection closed succesfully!","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex)
        {
         JOptionPane.showMessageDialog(null,"Error in closing the connection","DB Error!",JOptionPane.ERROR_MESSAGE);
         ex.printStackTrace();
        }   
    }
    
}
