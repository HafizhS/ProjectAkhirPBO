package ManajemenInventaris;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Login_Peminjaman_Panel extends javax.swing.JPanel {

    private Manajemen_Main parent = null;

    public Login_Peminjaman_Panel(Manajemen_Main parent) {
        this.parent = parent;
        initComponents();
    }

//    private void initGmabar() {
//        try {
//            BufferedImage loginImg = ImageIO.read(new File("image"));
//        }catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnScanner = new javax.swing.JButton();
        txtPinjam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        button_home = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnScanner.setText("Scan");
        btnScanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScannerActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login_Peminjaman_Image");

        button_home.setText("Home_Button");
        button_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_homeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_home)
                .addGap(338, 338, 338)
                .addComponent(txtPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnScanner, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(555, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnScanner))
                        .addContainerGap())
                    .addComponent(button_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnScannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScannerActionPerformed
        try {
            String sql = "SELECT * FROM tbl_murid WHERE nis  = '" + txtPinjam.getText() + "'";
            Connection koneksi = DBconnection.getKoneksi();
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.first()) {
                parent.peminjamanBarangPanel = new Manajemen_PeminjamanBarangPanel(parent,rs.getInt("id_murid"));
                parent.add(parent.peminjamanBarangPanel);
                this.revalidate();
                parent.revalidate();
                parent.Login_Peminjaman_Panel.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Maaf Data Tidak Valid");
            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            txtPinjam.setText("");
        }

    }//GEN-LAST:event_btnScannerActionPerformed

    private void button_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_homeMouseClicked
        parent.backToHome(this);
    }//GEN-LAST:event_button_homeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnScanner;
    private javax.swing.JLabel button_home;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtPinjam;
    // End of variables declaration//GEN-END:variables
}
