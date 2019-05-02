package ManajemenInventaris;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PendataanBarang_PengembalianHistoryPanel extends javax.swing.JPanel {

    private Manajemen_Main parent = null;
    private Manajemen_PendataanBarangPanel docker = null;

    public PendataanBarang_PengembalianHistoryPanel(Manajemen_Main parent, Manajemen_PendataanBarangPanel docker) throws IOException {
        this.parent = parent;
        this.docker = docker;
        initComponents();
        initImage();
    }

    private void initImage() throws IOException {
        BufferedImage ubahBtn = ImageIO.read(new File("image\\button\\ubah_btn.png"));
        BufferedImage hapusBtn = ImageIO.read(new File("image\\button\\hapus_btn.png"));

        button_ubah.setIcon(new ImageIcon(ubahBtn.getScaledInstance(ubahBtn.getWidth(), ubahBtn.getHeight(), Image.SCALE_SMOOTH)));
        button_hapus.setIcon(new ImageIcon(hapusBtn.getScaledInstance(hapusBtn.getWidth(), hapusBtn.getHeight(), Image.SCALE_SMOOTH)));

        button_ubah.setText("");
        button_hapus.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_bottom = new javax.swing.JPanel();
        button_ubah = new javax.swing.JLabel();
        button_hapus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_pinjamHistory = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        panel_bottom1 = new javax.swing.JPanel();
        button_ubah1 = new javax.swing.JLabel();
        button_hapus1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_pinjamHistory1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 102));

        panel_bottom.setBackground(new java.awt.Color(255, 255, 255));

        button_ubah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_ubah.setText("edit_button");

        button_hapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_hapus.setText("hapus_button");

        jLabel2.setText("Hanya Super Admin yang hanya diperbolehkan Memanipulasi/Menyunting data History Pengembalian");

        javax.swing.GroupLayout panel_bottomLayout = new javax.swing.GroupLayout(panel_bottom);
        panel_bottom.setLayout(panel_bottomLayout);
        panel_bottomLayout.setHorizontalGroup(
            panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                .addComponent(button_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        panel_bottomLayout.setVerticalGroup(
            panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(button_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(button_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        table_pinjamHistory.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        table_pinjamHistory.setForeground(new java.awt.Color(51, 153, 255));
        table_pinjamHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama", "Kelas", "Waktu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_pinjamHistory.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_pinjamHistory.setFillsViewportHeight(true);
        table_pinjamHistory.setGridColor(new java.awt.Color(51, 153, 255));
        table_pinjamHistory.setOpaque(false);
        table_pinjamHistory.setRowHeight(40);
        table_pinjamHistory.setRowSelectionAllowed(false);
        table_pinjamHistory.setSelectionForeground(new java.awt.Color(51, 153, 255));
        jScrollPane1.setViewportView(table_pinjamHistory);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        panel_bottom1.setBackground(new java.awt.Color(255, 255, 255));

        button_ubah1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_ubah1.setText("edit_button");

        button_hapus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_hapus1.setText("hapus_button");

        jLabel3.setText("Hanya Super Admin yang hanya diperbolehkan Memanipulasi/Menyunting data History Pengembalian");

        javax.swing.GroupLayout panel_bottom1Layout = new javax.swing.GroupLayout(panel_bottom1);
        panel_bottom1.setLayout(panel_bottom1Layout);
        panel_bottom1Layout.setHorizontalGroup(
            panel_bottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_ubah1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                .addComponent(button_hapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        panel_bottom1Layout.setVerticalGroup(
            panel_bottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(button_ubah1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(button_hapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bottom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        table_pinjamHistory1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        table_pinjamHistory1.setForeground(new java.awt.Color(51, 153, 255));
        table_pinjamHistory1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama", "Kelas", "Waktu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_pinjamHistory1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_pinjamHistory1.setFillsViewportHeight(true);
        table_pinjamHistory1.setGridColor(new java.awt.Color(51, 153, 255));
        table_pinjamHistory1.setOpaque(false);
        table_pinjamHistory1.setRowHeight(40);
        table_pinjamHistory1.setRowSelectionAllowed(false);
        table_pinjamHistory1.setSelectionForeground(new java.awt.Color(51, 153, 255));
        jScrollPane2.setViewportView(table_pinjamHistory1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bottom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panel_bottom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panel_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_hapus;
    private javax.swing.JLabel button_hapus1;
    private javax.swing.JLabel button_ubah;
    private javax.swing.JLabel button_ubah1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_bottom;
    private javax.swing.JPanel panel_bottom1;
    private javax.swing.JTable table_pinjamHistory;
    private javax.swing.JTable table_pinjamHistory1;
    // End of variables declaration//GEN-END:variables
}
