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


public class Login_Pendataan_Panel extends javax.swing.JPanel {

    private Manajemen_Main parent = null;
    Connection koneksi;
    
    public Login_Pendataan_Panel(Manajemen_Main parent) {
        this.parent = parent;
        initComponents();
        initGambar();
        koneksi = DBconnection.getKoneksi();
    }
    
    private void initGambar() {
        try {
            BufferedImage loginImg = ImageIO.read(new File("image\\scanning_onboarding.png"));
            BufferedImage homeBtn = ImageIO.read(new File("image\\button\\home_blue_btn.png"));

            jLabel2.setIcon(new ImageIcon(loginImg.getScaledInstance(loginImg.getWidth(), loginImg.getHeight(), Image.SCALE_FAST)));
            jLabel2.setText("");
            jLabel1.setIcon(new ImageIcon(homeBtn.getScaledInstance(homeBtn.getWidth(), homeBtn.getHeight(), Image.SCALE_FAST)));
            jLabel1.setText("");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_admin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_adminActionPerformed(evt);
            }
        });
        txt_admin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_adminKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_adminKeyReleased(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Home_Button");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login_Pendataan_Image");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(79, 134, 243));
        jLabel3.setText("Pendataan Barang");

        jLabel4.setText("Hanya Admin dan SuperAdmin yang memiliki akses");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 834, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        parent.backToHome(this);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_adminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_adminKeyReleased
       
    }//GEN-LAST:event_txt_adminKeyReleased

    private void txt_adminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_adminKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            try {
            String sql = "SELECT * FROM tbl_admin WHERE id_barcode_admin = '" + txt_admin.getText() + "'";
            Connection koneksi = DBconnection.getKoneksi();
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                parent.pendataanBarangPanel = new Manajemen_PendataanBarangPanel(parent,rs.getInt("level"));
                parent.add(parent.pendataanBarangPanel);
                this.revalidate();
                parent.revalidate();
                parent.Login_Pendataan_Panel.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Maaf Data Tidak Valid");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        txt_admin.setText("");
        }
    }//GEN-LAST:event_txt_adminKeyPressed

    private void txt_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_adminActionPerformed
        
    }//GEN-LAST:event_txt_adminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_admin;
    // End of variables declaration//GEN-END:variables
}
