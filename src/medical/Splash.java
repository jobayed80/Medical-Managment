/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical;

import java.awt.Dimension;
import java.awt.Toolkit;
import Icon.*;

/**
 *
 * @author h
 */
public class Splash extends javax.swing.JFrame {

    /**
     * Creates new form Splash
     */
    public Splash() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
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
        bar = new javax.swing.JProgressBar();
        increase = new javax.swing.JLabel();
        labelLoading = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(5, 10, 46));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 173, 480, -1));

        increase.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 15)); // NOI18N
        increase.setForeground(new java.awt.Color(255, 255, 255));
        increase.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        increase.setText("0%");
        jPanel1.add(increase, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 40, -1));

        labelLoading.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        labelLoading.setForeground(new java.awt.Color(255, 255, 255));
        labelLoading.setText(" Loading.................");
        jPanel1.add(labelLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 220, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/m-loadinSplash_prev_ui.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/splash_circle.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 61, -1, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 200));

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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Splash sp = new Splash();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sp.setVisible(true);
            }
        });
        registration_from rf = new registration_from();
        try {
            for (int i = 0; i <=100; i++) {
                Thread.sleep(100);
              
                sp.increase.setText(Integer.toString(i)+"%");
                if(i==10)
                {
                    sp.labelLoading.setText(" Turning On Modules......");
                }
                if(i==20)
                {
                    sp.labelLoading.setText(" Loading Modules......");
                }
                if(i==50)
                {
                    sp.labelLoading.setText(" Connecting to Database......");
                }
                if(i==70)
                {
                    sp.labelLoading.setText(" Connection to successful......");
                }
                if(i==80)
                {
                    sp.labelLoading.setText(" Launching Application......");
                }
                sp.bar.setValue(i);
                
                
                
            }
        } catch (Exception e) {
        }
        new Splash().setVisible(false);
        rf.setVisible(true);
        sp.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar bar;
    private javax.swing.JLabel increase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelLoading;
    // End of variables declaration//GEN-END:variables
}
