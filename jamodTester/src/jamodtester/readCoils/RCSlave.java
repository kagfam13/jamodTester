/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamodtester.readCoils;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.ModbusCoupler;
import net.wimpi.modbus.net.ModbusTCPListener;
import net.wimpi.modbus.procimg.SimpleDigitalOut;
import net.wimpi.modbus.procimg.SimpleProcessImage;

/**
 *
 * @author Fabian
 */
public class RCSlave extends javax.swing.JFrame {
    SimpleProcessImage spi;
    ModbusTCPListener listener;
    /**
     * Creates new form RCServer
     */
    public RCSlave() {
        initComponents();
        int port = Modbus.DEFAULT_PORT;
        spi = new SimpleProcessImage();
        spi.addDigitalOut(new SimpleDigitalOut(btCoil1.isSelected()));
        spi.addDigitalOut(new SimpleDigitalOut(btCoil2.isSelected()));
        spi.addDigitalOut(new SimpleDigitalOut(btCoil3.isSelected()));
        spi.addDigitalOut(new SimpleDigitalOut(btCoil4.isSelected()));
        spi.addDigitalOut(new SimpleDigitalOut(btCoil5.isSelected()));
        spi.addDigitalOut(new SimpleDigitalOut(btCoil6.isSelected()));
        
        ModbusCoupler.getReference().setUnitID(Modbus.DEFAULT_UNIT_ID);
        ModbusCoupler.getReference().setMaster(false);
        ModbusCoupler.getReference().setProcessImage(spi);
        
        listener = new ModbusTCPListener(5);
        listener.setPort(port);
        listener.start();
        System.out.println("läuft");
    }
    
    private void mirFalltKaKlassenNameEin()
    {
        spi.setDigitalOut(0, new SimpleDigitalOut(btCoil1.isSelected()));
        spi.setDigitalOut(1, new SimpleDigitalOut(btCoil2.isSelected()));
        spi.setDigitalOut(2, new SimpleDigitalOut(btCoil3.isSelected()));
        spi.setDigitalOut(3, new SimpleDigitalOut(btCoil4.isSelected()));
        spi.setDigitalOut(4, new SimpleDigitalOut(btCoil5.isSelected()));
        spi.setDigitalOut(5, new SimpleDigitalOut(btCoil6.isSelected()));
        
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

        pSouth = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        pMain = new javax.swing.JPanel();
        btCoil1 = new javax.swing.JToggleButton();
        btCoil2 = new javax.swing.JToggleButton();
        btCoil3 = new javax.swing.JToggleButton();
        btCoil4 = new javax.swing.JToggleButton();
        btCoil5 = new javax.swing.JToggleButton();
        btCoil6 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pSouth.setLayout(new java.awt.CardLayout());

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pSouth.add(jButton1, "card2");

        getContentPane().add(pSouth, java.awt.BorderLayout.PAGE_END);

        pMain.setLayout(new java.awt.GridBagLayout());

        btCoil1.setText("Coil 1");
        btCoil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCoil1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        pMain.add(btCoil1, gridBagConstraints);

        btCoil2.setText("Coil 2");
        btCoil2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCoil2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        pMain.add(btCoil2, gridBagConstraints);

        btCoil3.setText("Coil 3");
        btCoil3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCoil3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        pMain.add(btCoil3, gridBagConstraints);

        btCoil4.setText("Coil 4");
        btCoil4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCoil4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        pMain.add(btCoil4, gridBagConstraints);

        btCoil5.setText("Coil 5");
        btCoil5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCoil5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        pMain.add(btCoil5, gridBagConstraints);

        btCoil6.setText("Coil 6");
        btCoil6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCoil6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        pMain.add(btCoil6, gridBagConstraints);

        getContentPane().add(pMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCoil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCoil1ActionPerformed
        // TODO add your handling code here:
        mirFalltKaKlassenNameEin();
    }//GEN-LAST:event_btCoil1ActionPerformed

    private void btCoil2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCoil2ActionPerformed
        // TODO add your handling code here:
        mirFalltKaKlassenNameEin();
    }//GEN-LAST:event_btCoil2ActionPerformed

    private void btCoil3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCoil3ActionPerformed
        // TODO add your handling code here:
        mirFalltKaKlassenNameEin();
    }//GEN-LAST:event_btCoil3ActionPerformed

    private void btCoil4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCoil4ActionPerformed
        // TODO add your handling code here:
        mirFalltKaKlassenNameEin();
    }//GEN-LAST:event_btCoil4ActionPerformed

    private void btCoil5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCoil5ActionPerformed
        // TODO add your handling code here:
        mirFalltKaKlassenNameEin();
    }//GEN-LAST:event_btCoil5ActionPerformed

    private void btCoil6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCoil6ActionPerformed
        // TODO add your handling code here:
        mirFalltKaKlassenNameEin();
    }//GEN-LAST:event_btCoil6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        listener.stop();
        dispose();
        System.exit(0);
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
            java.util.logging.Logger.getLogger(RCSlave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RCSlave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RCSlave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RCSlave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RCSlave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btCoil1;
    private javax.swing.JToggleButton btCoil2;
    private javax.swing.JToggleButton btCoil3;
    private javax.swing.JToggleButton btCoil4;
    private javax.swing.JToggleButton btCoil5;
    private javax.swing.JToggleButton btCoil6;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pSouth;
    // End of variables declaration//GEN-END:variables
}
