/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamodtester.arduinoSim;

import jamodtester.easyModbus.StringCoilsResp;
import jamodtester.easyModbus.EasyModbusMaster;
import java.net.*;
import java.util.logging.*;
import javax.swing.*;
import net.wimpi.modbus.*;
import net.wimpi.modbus.io.*;
import net.wimpi.modbus.msg.*;
import net.wimpi.modbus.net.*;

/**
 *
 * @author Fabian
 */
public class ArduinoSimMaster extends javax.swing.JFrame {

    /**
     * Creates new form ArduinoSimMaster
     */
     EasyModbusMaster master;
     
     
     
    public ArduinoSimMaster() {
         try {
             initComponents();
             master = new EasyModbusMaster(Modbus.DEFAULT_PORT, 15, InetAddress.getLocalHost(), 2, 3);
             new manageLabels().execute();
             
         } catch (UnknownHostException ex) {
             Logger.getLogger(ArduinoSimMaster.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    private class manageLabels extends SwingWorker<Object, Object>
    {
        
        @Override
        protected Object doInBackground() throws Exception
        {
            while(true)
            {
                StringCoilsResp resp = master.getCoils();
             
                if(resp.getCoil(2))
                {
                  lCar.setText("Auto da");
                }
                else
                {
                  lCar.setText("Auto nix da");
                }
                if(resp.getCoil(3))// Tor offen
                {
                  lTor.setText("Tor offen");
                }
                else if(resp.getCoil(4)) // Tor geschlossen
                {
                  lTor.setText("Tor geschlossen");
                }
                else
                {
                  lTor.setText("Ist das Tor halb offen oder halb geschlossen");
                }
                Thread.sleep(2000);
              }
        }
              
    }
    
    private class manageTor extends SwingWorker<Object, Object>
    {
       int coil;

    public manageTor(int coil)
    {
      this.coil = coil;
    }
       
       
      @Override
      protected Object doInBackground() throws Exception
      {
        master.writeCoil(coil, true);
        return 0;
      }
       
    }
         
         /**
          * This method is called from within the constructor to initialize the form.
          * WARNING: Do NOT modify this code. The content of this method is always
          * regenerated by the Form Editor.
          */
         @SuppressWarnings("unchecked")
         // <editor-fold defaultstate="collapsed" desc="Generated Code">
         
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {
    java.awt.GridBagConstraints gridBagConstraints;

    jPanel2 = new javax.swing.JPanel();
    lCar = new javax.swing.JLabel();
    lTor = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    bTorAuf = new javax.swing.JButton();
    bTorZu = new javax.swing.JButton();
    bExit = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel2.setLayout(new java.awt.GridBagLayout());

    lCar.setText("jLabel1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    jPanel2.add(lCar, gridBagConstraints);

    lTor.setText("jLabel2");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    jPanel2.add(lTor, gridBagConstraints);

    getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

    bTorAuf.setText("Tor auf");
    bTorAuf.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        bTorAufActionPerformed(evt);
      }
    });
    jPanel1.add(bTorAuf);

    bTorZu.setText("Tor zu");
    bTorZu.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        bTorZuActionPerformed(evt);
      }
    });
    jPanel1.add(bTorZu);

    bExit.setText("exit");
    bExit.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        bExitActionPerformed(evt);
      }
    });
    jPanel1.add(bExit);

    getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void bTorAufActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bTorAufActionPerformed
  {//GEN-HEADEREND:event_bTorAufActionPerformed
    // TODO add your handling code here:
    new manageTor(0).execute();
  }//GEN-LAST:event_bTorAufActionPerformed

  private void bTorZuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bTorZuActionPerformed
  {//GEN-HEADEREND:event_bTorZuActionPerformed
    // TODO add your handling code here:
    new manageTor(1).execute();
  }//GEN-LAST:event_bTorZuActionPerformed

  private void bExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bExitActionPerformed
  {//GEN-HEADEREND:event_bExitActionPerformed
    // TODO add your handling code here:
    dispose();
    System.exit(0);
  }//GEN-LAST:event_bExitActionPerformed

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
            java.util.logging.Logger.getLogger(ArduinoSimMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArduinoSimMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArduinoSimMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArduinoSimMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArduinoSimMaster().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bExit;
  private javax.swing.JButton bTorAuf;
  private javax.swing.JButton bTorZu;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JLabel lCar;
  private javax.swing.JLabel lTor;
  // End of variables declaration//GEN-END:variables
}
