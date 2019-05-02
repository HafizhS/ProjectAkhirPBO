package ManajemenInventaris;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Manajemen_HomePanel extends javax.swing.JPanel {

    private Manajemen_Main parent = null;
    private JPanel selectedPanel = null;
    private BufferedImage persediaanImage = null;
    private BufferedImage persediaanImage_checked = null;
    private BufferedImage peminjamanImage = null;
    private BufferedImage peminjamanImage_checked = null;
    private BufferedImage pengembalianImage = null;
    private BufferedImage pengembalianImage_checked = null;

    public Manajemen_HomePanel(Manajemen_Main parent) throws Exception {
        initComponents();
        initImage();
        this.parent = parent;

    }

    private void initImage() throws IOException {
        persediaanImage = ImageIO.read(new File("image\\home_menu1.png"));
        peminjamanImage = ImageIO.read(new File("image\\home_menu2.png"));
        pengembalianImage = ImageIO.read(new File("image\\home_menu3.png"));
        persediaanImage_checked = ImageIO.read(new File("image\\home_menu1_checked.png"));
        peminjamanImage_checked = ImageIO.read(new File("image\\home_menu2_checked.png"));
        pengembalianImage_checked = ImageIO.read(new File("image\\home_menu3_checked.png"));

        this.persediaanbarang_btn.setIcon(new ImageIcon(persediaanImage.getScaledInstance(persediaanImage.getWidth(), persediaanImage.getHeight(), Image.SCALE_SMOOTH)));
        this.persediaanbarang_btn.setText("");

        this.peminjamanbarang_btn.setIcon(new ImageIcon(peminjamanImage.getScaledInstance(peminjamanImage.getWidth(), persediaanImage.getHeight(), Image.SCALE_SMOOTH)));
        this.peminjamanbarang_btn.setText("");

        this.pengembalianbarang_btn.setIcon(new ImageIcon(pengembalianImage.getScaledInstance(pengembalianImage.getWidth(), pengembalianImage.getHeight(), Image.SCALE_SMOOTH)));
        this.pengembalianbarang_btn.setText("");

        BufferedImage scanBtnImage = ImageIO.read(new File("image\\button\\scan_btn.png"));
        this.scan_btn.setIcon(new ImageIcon(scanBtnImage.getScaledInstance(scanBtnImage.getWidth(), scanBtnImage.getHeight(), Image.SCALE_SMOOTH)));
        this.scan_btn.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_title = new javax.swing.JLabel();
        peminjamanbarang_btn = new javax.swing.JLabel();
        persediaanbarang_btn = new javax.swing.JLabel();
        pengembalianbarang_btn = new javax.swing.JLabel();
        scan_btn = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        setPreferredSize(new java.awt.Dimension(1350, 720));

        label_title.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        label_title.setForeground(new java.awt.Color(51, 102, 255));
        label_title.setText("Inventory App | SMKN 4 Bandung");

        peminjamanbarang_btn.setText("peminjamanbarang_icon");
        peminjamanbarang_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                peminjamanbarang_btnMouseClicked(evt);
            }
        });

        persediaanbarang_btn.setText("persediaanbarang_icon");
        persediaanbarang_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                persediaanbarang_btnMouseClicked(evt);
            }
        });

        pengembalianbarang_btn.setText("pengembalianbarang_icon");
        pengembalianbarang_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pengembalianbarang_btnMouseClicked(evt);
            }
        });

        scan_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scan_btn.setText("scanbtn_icon");
        scan_btn.setEnabled(false);
        scan_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scan_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(persediaanbarang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(peminjamanbarang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(pengembalianbarang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(574, 574, 574)
                        .addComponent(scan_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peminjamanbarang_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(pengembalianbarang_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(persediaanbarang_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addComponent(scan_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void persediaanbarang_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_persediaanbarang_btnMouseClicked
        this.persediaanbarang_btn.setIcon(new ImageIcon(persediaanImage_checked.getScaledInstance(persediaanImage_checked.getWidth(), persediaanImage_checked.getHeight(), Image.SCALE_SMOOTH)));
        this.peminjamanbarang_btn.setIcon(new ImageIcon(peminjamanImage.getScaledInstance(peminjamanImage.getWidth(), persediaanImage.getHeight(), Image.SCALE_SMOOTH)));
        this.pengembalianbarang_btn.setIcon(new ImageIcon(pengembalianImage.getScaledInstance(pengembalianImage.getWidth(), pengembalianImage.getHeight(), Image.SCALE_SMOOTH)));
        scan_btn.setEnabled(true);
        selectedPanel = parent.pendataanBarangPanel;
    }//GEN-LAST:event_persediaanbarang_btnMouseClicked

    private void peminjamanbarang_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_peminjamanbarang_btnMouseClicked
        this.persediaanbarang_btn.setIcon(new ImageIcon(persediaanImage.getScaledInstance(persediaanImage.getWidth(), persediaanImage.getHeight(), Image.SCALE_SMOOTH)));
        this.peminjamanbarang_btn.setIcon(new ImageIcon(peminjamanImage_checked.getScaledInstance(peminjamanImage_checked.getWidth(), peminjamanImage_checked.getHeight(), Image.SCALE_SMOOTH)));
        this.pengembalianbarang_btn.setIcon(new ImageIcon(pengembalianImage.getScaledInstance(pengembalianImage.getWidth(), pengembalianImage.getHeight(), Image.SCALE_SMOOTH)));
        scan_btn.setEnabled(true);        
        parent.Login_Peminjaman_Panel = new Login_Peminjaman_Panel(parent);
        selectedPanel = parent.Login_Peminjaman_Panel;
    }//GEN-LAST:event_peminjamanbarang_btnMouseClicked

    private void pengembalianbarang_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengembalianbarang_btnMouseClicked
        this.persediaanbarang_btn.setIcon(new ImageIcon(persediaanImage.getScaledInstance(persediaanImage.getWidth(), persediaanImage.getHeight(), Image.SCALE_SMOOTH)));
        this.peminjamanbarang_btn.setIcon(new ImageIcon(peminjamanImage.getScaledInstance(peminjamanImage.getWidth(), peminjamanImage.getHeight(), Image.SCALE_SMOOTH)));
        this.pengembalianbarang_btn.setIcon(new ImageIcon(pengembalianImage_checked.getScaledInstance(pengembalianImage_checked.getWidth(), pengembalianImage_checked.getHeight(), Image.SCALE_SMOOTH)));
        scan_btn.setEnabled(true);
        selectedPanel = parent.pengembalianBarangPanel;
    }//GEN-LAST:event_pengembalianbarang_btnMouseClicked

    private void scan_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_btnMouseClicked
        if (scan_btn.isEnabled()) {
            parent.homePanel.setVisible(false);
            if (selectedPanel.getClass() != null) {
                parent.add(selectedPanel, BorderLayout.CENTER);
                selectedPanel.setVisible(true);
            }
        }
    }//GEN-LAST:event_scan_btnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel peminjamanbarang_btn;
    private javax.swing.JLabel pengembalianbarang_btn;
    private javax.swing.JLabel persediaanbarang_btn;
    private javax.swing.JLabel scan_btn;
    // End of variables declaration//GEN-END:variables
}
