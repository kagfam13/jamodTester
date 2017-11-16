/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamodtester.androidSim;

import jamodtester.easyModbus.EasyModbusMaster;
import jamodtester.easyModbus.GetCoilsResp;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import net.wimpi.modbus.Modbus;

/**
 *
 * @author Fabian
 */
public class AndroidSimMaster extends javax.swing.JFrame {

    EasyModbusMaster master;
    /**
     * Creates new form AndroidSimMaster
     */
    public AndroidSimMaster() {
        initComponents();
        
        try {
            master = new EasyModbusMaster(Modbus.DEFAULT_PORT, 15, InetAddress.getLocalHost(), 10, 15);
            new backgroundWorker().execute();
        } catch (UnknownHostException ex) {
            Logger.getLogger(AndroidSimMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class backgroundWorker extends SwingWorker<Object, Object>
    {
        private void setCar(JLabel label, boolean b)        
        {
            if(b==true)
                label.setText("Auto ist da");
            else
                label.setText("Auto nicht da");
        }
        
        private void setTor(JLabel label, boolean unten, boolean oben)
        {
            if(unten == false)
            {
                if(oben == true)
                    label.setText("Tor ist offen");
                else
                    label.setText("Tor in der Mitte");
            }
            else
            {
                if(oben==false)
                    label.setText("Tor ist geschlossen");
                else
                    label.setText("WTF??");
            }
        }

        @Override
        protected Object doInBackground() throws Exception {
            while(true)
            {
                GetCoilsResp resp = new GetCoilsResp(master.getCoils());
                System.out.println(resp.toString());
                setCar(car1, resp.getCoil(10));
                setCar(car2, resp.getCoil(11));
                setCar(car3, resp.getCoil(12));
                setCar(car4, resp.getCoil(13));
                setCar(car5, resp.getCoil(14));
                
                setTor(tor1, resp.getCoil(15), resp.getCoil(16));
                setTor(tor2, resp.getCoil(17), resp.getCoil(18));
                setTor(tor3, resp.getCoil(19), resp.getCoil(20));
                setTor(tor4, resp.getCoil(21), resp.getCoil(22));
                setTor(tor5, resp.getCoil(23), resp.getCoil(24));
                
                Thread.sleep(1000);
            }
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        car1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        tor1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        car2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        tor2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        car3 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        tor3 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        car4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        tor4 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        car5 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        tor5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Auto 1"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        car1.setText("Fahrzeugzustand");
        jPanel4.add(car1);

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jButton2.setText("auf");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);

        jButton3.setText("zu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        tor1.setText("Torzustand");
        jPanel6.add(tor1);

        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel3);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Auto 2"));
        jPanel7.setLayout(new java.awt.BorderLayout());

        car2.setText("Fahrzeugzustand");
        jPanel8.add(car2);

        jPanel7.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jButton4.setText("auf");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton4);

        jButton5.setText("zu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton5);

        jPanel7.add(jPanel9, java.awt.BorderLayout.CENTER);

        tor2.setText("Torzustand");
        jPanel10.add(tor2);

        jPanel7.add(jPanel10, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel7);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Auto 3"));
        jPanel11.setLayout(new java.awt.BorderLayout());

        car3.setText("Fahrzeugzustand");
        jPanel12.add(car3);

        jPanel11.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jButton6.setText("auf");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton6);

        jButton7.setText("zu");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton7);

        jPanel11.add(jPanel13, java.awt.BorderLayout.CENTER);

        tor3.setText("Torzustand");
        jPanel14.add(tor3);

        jPanel11.add(jPanel14, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel11);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Auto 4"));
        jPanel15.setLayout(new java.awt.BorderLayout());

        car4.setText("Fahrzeugzustand");
        jPanel16.add(car4);

        jPanel15.add(jPanel16, java.awt.BorderLayout.PAGE_START);

        jButton8.setText("auf");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton8);

        jButton9.setText("zu");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton9);

        jPanel15.add(jPanel17, java.awt.BorderLayout.CENTER);

        tor4.setText("Torzustand");
        jPanel18.add(tor4);

        jPanel15.add(jPanel18, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel15);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Auto 5"));
        jPanel19.setLayout(new java.awt.BorderLayout());

        car5.setText("Fahrzeugzustand");
        jPanel20.add(car5);

        jPanel19.add(jPanel20, java.awt.BorderLayout.PAGE_START);

        jButton10.setText("auf");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton10);

        jButton11.setText("zu");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton11);

        jPanel19.add(jPanel21, java.awt.BorderLayout.CENTER);

        tor5.setText("Torzustand");
        jPanel22.add(tor5);

        jPanel19.add(jPanel22, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel19);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        master.writeCoil(0, true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        master.writeCoil(1, true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        master.writeCoil(2, true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        master.writeCoil(3, true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        master.writeCoil(4, true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        master.writeCoil(5, true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        master.writeCoil(6, true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        master.writeCoil(7, true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        master.writeCoil(8, true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        master.writeCoil(9, true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(AndroidSimMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AndroidSimMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AndroidSimMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AndroidSimMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AndroidSimMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel car1;
    private javax.swing.JLabel car2;
    private javax.swing.JLabel car3;
    private javax.swing.JLabel car4;
    private javax.swing.JLabel car5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel tor1;
    private javax.swing.JLabel tor2;
    private javax.swing.JLabel tor3;
    private javax.swing.JLabel tor4;
    private javax.swing.JLabel tor5;
    // End of variables declaration//GEN-END:variables
}
