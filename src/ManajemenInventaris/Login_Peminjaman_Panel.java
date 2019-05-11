package ManajemenInventaris;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login_Peminjaman_Panel extends javax.swing.JPanel {
    
    private Manajemen_Main parent = null;
    
    public Login_Peminjaman_Panel(Manajemen_Main parent) {
        this.parent = parent;
        initComponents();
        initGambar();
        txtPinjam.setFocusable(true);
        txtPinjam.requestFocus(true);
        txtPinjam.requestFocusInWindow();
        
    }
    
    private void initGambar() {
        try {
            BufferedImage loginImg = ImageIO.read(new File("image\\scanning_onboarding.png"));
            BufferedImage homeBtn = ImageIO.read(new File("image\\button\\home_blue_btn.png"));
            
            jLabel2.setIcon(new ImageIcon(loginImg.getScaledInstance(loginImg.getWidth(), loginImg.getHeight(), Image.SCALE_FAST)));
            jLabel2.setText("");
            button_home.setIcon(new ImageIcon(homeBtn.getScaledInstance(homeBtn.getWidth(), homeBtn.getHeight(), Image.SCALE_FAST)));
            button_home.setText("");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPinjam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        button_home = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setNextFocusableComponent(txtPinjam);

        txtPinjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPinjamKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login_Peminjaman_Image");

        button_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_home.setText("Home_Button");
        button_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_homeMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 134, 243));
        jLabel1.setText("Peminjaman Barang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_home, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_home, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_homeMouseClicked
        parent.backToHome(this);
    }//GEN-LAST:event_button_homeMouseClicked

    private void txtPinjamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPinjamKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String sql = "SELECT * FROM tbl_murid WHERE nis = '" + txtPinjam.getText() + "'";
                Connection koneksi = DBconnection.getKoneksi();
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println(sql);
                if (rs.first()) {
                    parent.peminjamanBarangPanel = new Manajemen_PeminjamanBarangPanel(parent, rs.getInt("id_murid"));
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
        }
    }//GEN-LAST:event_txtPinjamKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtPinjam;
    // End of variables declaration//GEN-END:variables
}
