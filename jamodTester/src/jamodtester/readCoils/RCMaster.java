/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamodtester.readCoils;

import java.awt.Color;
import java.net.InetAddress;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ModbusRequest;
import net.wimpi.modbus.msg.ModbusResponse;
import net.wimpi.modbus.msg.ReadCoilsRequest;
import net.wimpi.modbus.net.TCPMasterConnection;

/**
 *
 * @author Fabian
 */
public class RCMaster extends javax.swing.JFrame {
     
    /**
     * Creates new form RCMaster
     */
    public RCMaster() {
        initComponents();
    }
    
    private class refresh extends SwingWorker<Object, Object>
    {

        private void setText(JLabel label,char c)
        {
            if(c=='1')
                label.setForeground(Color.green);
            else
                label.setForeground(Color.red);
        }
        
        public refresh() {
        }

        @Override
        protected Object doInBackground() {
            try {
                int port = Modbus.DEFAULT_PORT;
                InetAddress addy = InetAddress.getByName("10.0.2.15");
                TCPMasterConnection connection = new TCPMasterConnection(addy);
                connection.setTimeout(3000);
                connection.setPort(port);
                System.out.println("Trying to connect to "+addy.getHostAddress()+" on port "+port);
                connection.connect();
                System.out.println("hi");
                ModbusTCPTransaction transaction = new ModbusTCPTransaction(connection);

                ModbusRequest request = new ReadCoilsRequest(0, 6);
                request.setUnitID(Modbus.DEFAULT_UNIT_ID);
                transaction.setRequest(request);
                transaction.execute();
                ModbusResponse response = transaction.getResponse();
                System.out.println("hi2");
                String hexNumber = response.getHexMessage();

                connection.close();

                System.out.println("hi3");
                System.out.println(hexNumber);
                String hex2 = hexNumber.replaceAll(" ", "");
                int intVal = Integer.parseInt(hex2.substring(hex2.length()-2), 16);
                String bin = Integer.toBinaryString(intVal);
                System.out.println(bin);
                while(bin.length()<6)
                {
                    bin = "0" + bin;
                }
                System.out.println(bin);

                setText(coil1,bin.charAt(bin.length()-1));
                setText(coil2,bin.charAt(bin.length()-2));
                setText(coil3,bin.charAt(bin.length()-3));
                setText(coil4,bin.charAt(bin.length()-4));
                setText(coil5,bin.charAt(bin.length()-5));
                setText(coil6,bin.charAt(bin.length()-6));
            } catch(Exception e)
            {
                e.printStackTrace();
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

        pSouth = new javax.swing.JPanel();
        btRefresh = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        pMain = new javax.swing.JPanel();
        coil1 = new javax.swing.JLabel();
        coil2 = new javax.swing.JLabel();
        coil3 = new javax.swing.JLabel();
        coil4 = new javax.swing.JLabel();
        coil5 = new javax.swing.JLabel();
        coil6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btRefresh.setText("refresh");
        btRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshActionPerformed(evt);
            }
        });
        pSouth.add(btRefresh);

        btExit.setText("exit");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        pSouth.add(btExit);

        getContentPane().add(pSouth, java.awt.BorderLayout.PAGE_END);

        pMain.setLayout(new java.awt.GridBagLayout());

        coil1.setText("Coil1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(coil1, gridBagConstraints);

        coil2.setText("Coil 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(coil2, gridBagConstraints);

        coil3.setText("Coil 3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(coil3, gridBagConstraints);

        coil4.setText("Coil 4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(coil4, gridBagConstraints);

        coil5.setText("Coil 5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(coil5, gridBagConstraints);

        coil6.setText("Coil 6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(coil6, gridBagConstraints);

        getContentPane().add(pMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed
        // TODO add your handling code here:
        new refresh().execute();
    }//GEN-LAST:event_btRefreshActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        // TODO add your handling code here:
        dispose();
        System.exit(0);
    }//GEN-LAST:event_btExitActionPerformed

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
            java.util.logging.Logger.getLogger(RCMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RCMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RCMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RCMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RCMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExit;
    private javax.swing.JButton btRefresh;
    private javax.swing.JLabel coil1;
    private javax.swing.JLabel coil2;
    private javax.swing.JLabel coil3;
    private javax.swing.JLabel coil4;
    private javax.swing.JLabel coil5;
    private javax.swing.JLabel coil6;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pSouth;
    // End of variables declaration//GEN-END:variables
}
