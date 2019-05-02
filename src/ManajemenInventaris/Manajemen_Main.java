package ManajemenInventaris;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Manajemen_Main extends javax.swing.JFrame {

    //Main UI list
    public Manajemen_HomePanel homePanel = null;
    public Manajemen_PendataanBarangPanel pendataanBarangPanel = null;
    public Manajemen_PengembalianBarangPanel pengembalianBarangPanel = null;
    public Manajemen_PeminjamanBarangPanel peminjamanBarangPanel = null;
    public Login_Pengembalian_Panel login_Pengembalian_Panel = null;
 
    public Manajemen_Main() throws Exception {
        initComponents();
        
        this.setLayout(new BorderLayout());
        this.setTitle("Manajemen Inventaris");
        this.setIconImage(ImageIO.read(new File("image\\smkn4.png")).getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        homePanel = new Manajemen_HomePanel(this);
        pendataanBarangPanel = new Manajemen_PendataanBarangPanel(this);
        pengembalianBarangPanel = new Manajemen_PengembalianBarangPanel(this);
        peminjamanBarangPanel = new Manajemen_PeminjamanBarangPanel(this);

        this.getContentPane().add(pendataanBarangPanel, BorderLayout.CENTER);
        pendataanBarangPanel.setVisible(false);
        this.getContentPane().add(homePanel, BorderLayout.CENTER);
        homePanel.setVisible(true);

    }

    public Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {
        double original_width = imgSize.getWidth();
        double original_height = imgSize.getHeight();
        double bound_width = boundary.getWidth();
        double bound_height = boundary.getHeight();
        double new_width = original_width;
        double new_height = original_height;

        if (original_width > bound_width) {
            new_width = bound_width;
            new_height = (new_width * original_height) / original_width;
        }

        if (new_height > bound_height) {
            new_height = bound_height;
            new_width = (new_height * original_width) / original_height;
        }

        return new Dimension((int) new_width, (int) new_height);
    }

    public void backToHome(JPanel panel) {
        panel.setVisible(false);
        homePanel.repaint();
        homePanel.revalidate();
        homePanel.setVisible(true);
        System.out.println("Total Panel in Frame: " + this.getComponentCount());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1350, 720));
        setSize(new java.awt.Dimension(1350, 720));

        setSize(new java.awt.Dimension(1366, 759));
        setLocationRelativeTo(null);
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manajemen_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manajemen_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manajemen_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manajemen_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Manajemen_Main().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
