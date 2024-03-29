/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.gui;

import emart.dao.OrderDao;
import emart.dao.ProductsDAO;
import emart.pojo.ProductsPojo;
import emart.pojo.UserProfile;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RP
 */
public class ViewOrder extends javax.swing.JFrame {

    DefaultTableModel tm;
    public ViewOrder() {
        initComponents();
        this.setLocationRelativeTo(null);
        tm = (DefaultTableModel)jtProductDetails.getModel();
        tm.setRowCount(0);
        try{
        List<String> ordId = OrderDao.getAllOrderIds(UserProfile.getUserid());
        
        if(ordId.isEmpty()){
            JOptionPane.showMessageDialog(null, "No order present!");
            return;
        }
        for(int i=0;i<ordId.size();i++){
        String id = ordId.get(i);
        ArrayList<ProductsPojo>arr = OrderDao.getCurrentOrder(id,UserProfile.getUserid());
        for(ProductsPojo p : arr){
            Object rows[] = new Object[8];
            rows[0] = id;
            rows[1] = p.getProductId().toString();
            rows[2] = p.getProductName().toString();
            rows[3] = p.getProductCompany().toString();
            rows[4] = p.getProductPrice()+" ";
            rows[5] = p.getOurPrice()+" ";
            rows[6] = p.getQuantity()+" ";
            tm.addRow(rows);
        }
        lblAmount.setOpaque(false);
        lblTotal.setOpaque(false);
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No Order present !");
            e.printStackTrace();
        }
    }
    public ViewOrder(String ordId,double grTotal){
        this();
        tm = (DefaultTableModel)jtProductDetails.getModel();
        tm.setRowCount(0);
        lblAmount.setOpaque(true);
        lblTotal.setOpaque(true);
        try{
        ArrayList<ProductsPojo>arr = OrderDao.getCurrentOrder(ordId,UserProfile.getUserid());
        for(ProductsPojo p : arr){
            Object rows[] = new Object[8];
            rows[0] = ordId;
            rows[1] = p.getProductId().toString();
            rows[2] = p.getProductName().toString();
            rows[3] = p.getProductCompany().toString();
            rows[4] = p.getProductPrice()+" ";
            rows[5] = p.getOurPrice()+" ";
            rows[6] = p.getQuantity()+" ";
            tm.addRow(rows);
        }
        lblTotal.setText(grTotal+"");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
/**
     * Creates new form ViewStocks
     */
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductDetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jtProductDetails.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtProductDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderId", "Product Id", "Product  Name", "Product Company", "Product Price", "Our Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtProductDetails);
        if (jtProductDetails.getColumnModel().getColumnCount() > 0) {
            jtProductDetails.getColumnModel().getColumn(0).setResizable(false);
            jtProductDetails.getColumnModel().getColumn(1).setResizable(false);
            jtProductDetails.getColumnModel().getColumn(2).setResizable(false);
            jtProductDetails.getColumnModel().getColumn(3).setResizable(false);
            jtProductDetails.getColumnModel().getColumn(4).setResizable(false);
            jtProductDetails.getColumnModel().getColumn(5).setResizable(false);
            jtProductDetails.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("View Order");

        btnBack.setBackground(new java.awt.Color(153, 0, 0));
        btnBack.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(153, 0, 0));
        btnLogout.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblTotal.setBackground(new java.awt.Color(255, 255, 255));
        lblTotal.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(153, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setOpaque(true);

        lblAmount.setBackground(new java.awt.Color(255, 255, 255));
        lblAmount.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(153, 0, 0));
        lblAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAmount.setText("TOTAL AMOUNT:");
        lblAmount.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(379, 379, 379))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginFrame fs = new LoginFrame();
        fs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       tm.setRowCount(0);
       ReceptionistOptionFrame fr = new ReceptionistOptionFrame();
       fr.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProductDetails;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
 private void loadProductDetails() {
     try
     {
         List<ProductsPojo> al=ProductsDAO.getProductDetails();
         if(al.isEmpty())
         {
             JOptionPane.showMessageDialog(null,"No products present in stock");
             return;
         }
         Object[] rows=new Object[7];
         tm=(DefaultTableModel)jtProductDetails.getModel();
         for(ProductsPojo p:al)
         {
             rows[0]=p.getProductId();
             rows[1]=p.getProductName();
             rows[2]=p.getProductCompany();
             
             rows[3]=p.getProductPrice();
             rows[4]=p.getOurPrice();
             rows[5]=p.getQuantity();
             rows[6]=p.getTax()+"%";
             tm.addRow(rows);
         }
    }
     catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null,"DB ERrror!","Error!",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
       }
   }
}
