/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jyothsna
 */
public class Options extends javax.swing.JFrame {
    String cid;
    String oid;
    String paid;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form Options
     */
    public Options(String oid,String cid) {
        this.oid=oid;
        this.cid=cid;
        initComponents();
        String sql = " select payment_id from credit union select payment_id from  net_banking union select payment_id from cash ORDER BY payment_id DESC;";
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/commerce","postgres", "hello");
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                paid = rs.getString("payment_id");
                System.out.println(paid);
                break;
            }
            String cpy=paid;
            String ipaid=paid.substring(4);
            int id = Integer.parseInt(ipaid);
            id++;
            if( id < 10)
                paid = "PAY_00" + id;
            else if(id < 100)
                paid = "PAY_0" + id;
            else 
                paid = "PAY_" + id;
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        options = new javax.swing.ButtonGroup();
        cash = new javax.swing.JRadioButton();
        credit = new javax.swing.JRadioButton();
        nb = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        options.add(cash);
        cash.setText("Cash");

        options.add(credit);
        credit.setText("Credit");

        options.add(nb);
        nb.setText("Net Banking");

        jLabel1.setText("Please select your payment option:");

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(nb)
                    .addComponent(credit)
                    .addComponent(cash))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(cash)
                .addGap(35, 35, 35)
                .addComponent(credit)
                .addGap(38, 38, 38)
                .addComponent(nb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(nb.isSelected()){
            this.setVisible(false);
            new NetBanking(this.cid,this.oid,this.paid).setVisible(true);
        }
        if(cash.isSelected()){
            JOptionPane.showMessageDialog(null, "Your order has been confirmed!");
        }
        if(credit.isSelected()){
         //JOptionPane.showMessageDialog(null, "Amount has been deducted from your account");         
            this.setVisible(false);
            new credit(this.cid,this.oid,this.paid).setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Options().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton cash;
    private javax.swing.JRadioButton credit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton nb;
    private javax.swing.ButtonGroup options;
    // End of variables declaration//GEN-END:variables
}