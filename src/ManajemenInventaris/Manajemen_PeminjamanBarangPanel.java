package ManajemenInventaris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Manajemen_PeminjamanBarangPanel extends javax.swing.JPanel {

    private Manajemen_Main parent;
    public boolean isAlreadyInit = false;
    private PeminjamanBarang_AfterPinjamButtonPanel darkPanel = null;

    public Manajemen_PeminjamanBarangPanel(Manajemen_Main parent) throws IOException {
        this.parent = parent;
        initComponents();
        initGambar();
    }

    private void initGambar() throws IOException {
        BufferedImage harapScan = ImageIO.read(new File("image\\scanning_onboarding.png"));
        BufferedImage pinjamBtn = ImageIO.read(new File("image\\button\\pinjam_btn.png"));

        label_gambarHarapScan.setIcon(new ImageIcon(harapScan.getScaledInstance(harapScan.getWidth(), harapScan.getHeight(), Image.SCALE_SMOOTH)));
        label_gambarHarapScan.setText("");
        button_pinjam.setIcon(new ImageIcon(pinjamBtn.getScaledInstance(pinjamBtn.getWidth(), pinjamBtn.getHeight(), Image.SCALE_SMOOTH)));
        button_pinjam.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_gambarHarapScan = new javax.swing.JLabel();
        label_titleDataPeminjam = new javax.swing.JLabel();
        label_dataNamaPeminjam = new javax.swing.JLabel();
        label_dataKelasPeminjam = new javax.swing.JLabel();
        label_namaPeminjam = new javax.swing.JLabel();
        label_kelasPeminjam = new javax.swing.JLabel();
        label_titleBarangDipinjam = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_barangDipinjam = new javax.swing.JTable();
        button_home = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_title = new javax.swing.JLabel();
        button_pinjam = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        label_gambarHarapScan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_gambarHarapScan.setText("gambar_harapScan");
        label_gambarHarapScan.setToolTipText("");
        label_gambarHarapScan.setMaximumSize(new java.awt.Dimension(413, 450));
        label_gambarHarapScan.setMinimumSize(new java.awt.Dimension(413, 450));
        label_gambarHarapScan.setPreferredSize(new java.awt.Dimension(413, 450));

        label_titleDataPeminjam.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleDataPeminjam.setForeground(new java.awt.Color(51, 102, 255));
        label_titleDataPeminjam.setText("Data Peminjam : ");

        label_dataNamaPeminjam.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_dataNamaPeminjam.setForeground(new java.awt.Color(102, 153, 255));
        label_dataNamaPeminjam.setText("Atas Nama :");

        label_dataKelasPeminjam.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_dataKelasPeminjam.setForeground(new java.awt.Color(102, 153, 255));
        label_dataKelasPeminjam.setText("Kelas           :");

        label_namaPeminjam.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_namaPeminjam.setForeground(new java.awt.Color(102, 153, 255));
        label_namaPeminjam.setText("John Doe");

        label_kelasPeminjam.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_kelasPeminjam.setForeground(new java.awt.Color(102, 153, 255));
        label_kelasPeminjam.setText("XI RPL 3");

        label_titleBarangDipinjam.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleBarangDipinjam.setForeground(new java.awt.Color(51, 102, 255));
        label_titleBarangDipinjam.setText("Barang Yang Dipinjam :");

        table_barangDipinjam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        table_barangDipinjam.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        table_barangDipinjam.setForeground(new java.awt.Color(51, 153, 255));
        table_barangDipinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Barang", "Barcode ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_barangDipinjam.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        table_barangDipinjam.setFillsViewportHeight(true);
        table_barangDipinjam.setGridColor(new java.awt.Color(51, 153, 255));
        table_barangDipinjam.setRowHeight(40);
        jScrollPane2.setViewportView(table_barangDipinjam);

        button_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_home.setText("button_home");
        button_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_homeMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(102, 153, 255));

        label_title.setBackground(new java.awt.Color(204, 204, 204));
        label_title.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        label_title.setForeground(new java.awt.Color(102, 153, 255));
        label_title.setText("Peminjaman Barang");

        button_pinjam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_pinjam.setText("button_pinjam");
        button_pinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_pinjamMouseClicked(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jButton1.setText("Scan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_home, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(label_titleDataPeminjam)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(label_dataKelasPeminjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label_dataNamaPeminjam))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label_namaPeminjam)
                                        .addComponent(label_kelasPeminjam)))
                                .addComponent(label_titleBarangDipinjam)))
                        .addGap(28, 28, 28)))
                .addComponent(label_gambarHarapScan, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label_title)
                .addContainerGap(907, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addGap(866, 866, 866))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(label_title)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_titleDataPeminjam)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_dataNamaPeminjam)
                            .addComponent(label_namaPeminjam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_dataKelasPeminjam)
                            .addComponent(label_kelasPeminjam, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(label_titleBarangDipinjam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_home, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_gambarHarapScan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_homeMouseClicked
        this.parent.backToHome(this);
//        this.parent.remove(darkPanel);
    }//GEN-LAST:event_button_homeMouseClicked

    private void button_pinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_pinjamMouseClicked
        if (!this.isAlreadyInit) {
            this.setVisible(false);
            darkPanel = new PeminjamanBarang_AfterPinjamButtonPanel(parent);
            this.parent.add(darkPanel, BorderLayout.CENTER);
            darkPanel.setBackground(new Color(0, 0, 0, 50));
            darkPanel.setVisible(true);
            isAlreadyInit = true;
        }

    }//GEN-LAST:event_button_pinjamMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_home;
    private javax.swing.JLabel button_pinjam;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_dataKelasPeminjam;
    private javax.swing.JLabel label_dataNamaPeminjam;
    private javax.swing.JLabel label_gambarHarapScan;
    private javax.swing.JLabel label_kelasPeminjam;
    private javax.swing.JLabel label_namaPeminjam;
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel label_titleBarangDipinjam;
    private javax.swing.JLabel label_titleDataPeminjam;
    private javax.swing.JTable table_barangDipinjam;
    // End of variables declaration//GEN-END:variables
}
