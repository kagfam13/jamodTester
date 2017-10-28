/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamodtester.readingCoils;

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {
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
    pSouth.add(btRefresh);

    btExit.setText("exit");
    pSouth.add(btExit);

    getContentPane().add(pSouth, java.awt.BorderLayout.PAGE_END);

    pMain.setLayout(new java.awt.GridBagLayout());

    coil1.setText("Coil1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
    pMain.add(coil1, gridBagConstraints);

    coil2.setText("Coil 2");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
    pMain.add(coil2, gridBagConstraints);

    coil3.setText("Coil 3");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
    pMain.add(coil3, gridBagConstraints);

    coil4.setText("Coil 4");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
    pMain.add(coil4, gridBagConstraints);

    coil5.setText("Coil 5");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
    pMain.add(coil5, gridBagConstraints);

    coil6.setText("Coil 6");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
    pMain.add(coil6, gridBagConstraints);

    getContentPane().add(pMain, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents

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