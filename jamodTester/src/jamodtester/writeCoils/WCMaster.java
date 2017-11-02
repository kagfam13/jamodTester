/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamodtester.writeCoils;

import jamodtester.writeCoil.*;
import java.awt.Color;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import net.wimpi.modbus.*;
import net.wimpi.modbus.msg.*;
import net.wimpi.modbus.io.*;
import net.wimpi.modbus.net.*;
import net.wimpi.modbus.util.BitVector;

/**
 *
 * @author Fabian
 */
public class WCMaster extends javax.swing.JFrame {

    /**
     * Creates new form MasterGUI01
     */
    public WCMaster() {
        initComponents(); 
    }
    
    private class connectWorker extends SwingWorker<Object, Object>
    {

        @Override
        protected Object doInBackground() throws Exception {
        try {
            int port = Modbus.DEFAULT_PORT;
            int unitId = 15;
            InetAddress addy = InetAddress.getLocalHost();
            TCPMasterConnection connection = new TCPMasterConnection(addy);
            connection.setTimeout(3000);
            connection.setPort(port);
            System.out.println("Trying to connect to "+addy.getHostAddress()+" on port "+port);
            connection.connect();
            
            ModbusTCPTransaction transaction = new ModbusTCPTransaction(connection);

            BitVector vector = new BitVector(6);
            vector.setBit(0, coil0.isSelected());
            vector.setBit(1, coil1.isSelected());
            vector.setBit(2, coil2.isSelected());
            vector.setBit(3, coil3.isSelected());
            vector.setBit(4, coil4.isSelected());
            vector.setBit(5, coil5.isSelected());
            ModbusRequest request = new WriteMultipleCoilsRequest(0, vector);
            request.setUnitID(unitId);
            transaction.setRequest(request);
            transaction.execute();
            
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(WCMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return 0;
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        coil0 = new javax.swing.JCheckBox();
        coil1 = new javax.swing.JCheckBox();
        coil2 = new javax.swing.JCheckBox();
        coil3 = new javax.swing.JCheckBox();
        coil4 = new javax.swing.JCheckBox();
        coil5 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Master");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLocation(new java.awt.Point(0, 0));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setText("refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        coil0.setText("Coil 0");
        jPanel3.add(coil0, new java.awt.GridBagConstraints());

        coil1.setText("Coil 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel3.add(coil1, gridBagConstraints);

        coil2.setText("Coil 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel3.add(coil2, gridBagConstraints);

        coil3.setText("Coil 3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel3.add(coil3, gridBagConstraints);

        coil4.setText("Coil 4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel3.add(coil4, gridBagConstraints);

        coil5.setText("Coil 5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel3.add(coil5, gridBagConstraints);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new connectWorker().execute();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(WCMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WCMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WCMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WCMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WCMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox coil0;
    private javax.swing.JCheckBox coil1;
    private javax.swing.JCheckBox coil2;
    private javax.swing.JCheckBox coil3;
    private javax.swing.JCheckBox coil4;
    private javax.swing.JCheckBox coil5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
