package ManajemenInventaris;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Manajemen_PengembalianBarangPanel extends javax.swing.JPanel {

    private Manajemen_Main parent;

    Pengembalian_PengembalianBerhasilPanel berhasilPanel = null;

    // TODO: verifikasi user sebelum masuk form ini
    //Akan digunakan jika DB sudah jalan
    private boolean isSafeToStart = false;
    private int idMurid;

    public Manajemen_PengembalianBarangPanel(Manajemen_Main parent, int id_murid) throws IOException {
        this.parent = parent;
        this.idMurid = id_murid;
        berhasilPanel = new Pengembalian_PengembalianBerhasilPanel(parent);

        initComponents();
        initGambar(); //init Gambar

        ButtonGroup bgKondisi = new ButtonGroup(); // membuat agar button ter-kelompok
        bgKondisi.add(radBtn_Rusak);
        bgKondisi.add(radBtn_HampirRusak);
        bgKondisi.add(radBtn_Baik);
        bgKondisi.add(radBtn_SangatBaik);

        try {
            ResultSet rs = getUserDataFromDB(idMurid);
            if (rs.next()) {
                label_atasNama.setText(rs.getString("nama"));
                label_kelas.setText(rs.getString("nama_kelas"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void initGambar() throws IOException {
        BufferedImage confirmBtn = ImageIO.read(new File("image\\button\\konfirmasi_btn.png"));

        button_confirm.setIcon(new ImageIcon(confirmBtn.getScaledInstance(confirmBtn.getWidth(), confirmBtn.getHeight(), Image.SCALE_SMOOTH)));
        button_confirm.setText("");
    }

    private ResultSet getUserDataFromDB(int primarykey) throws SQLException {
        String query = "SELECT * FROM tbl_murid JOIN tbl_kelas ON tbl_kelas.id_kelas = tbl_murid.id_kelas WHERE id_murid = '" + primarykey + "'";
        return DBconnection.getKoneksi().createStatement().executeQuery(query);
    }

    private ResultSet getPeminjamanDataFromDB(int primarykey) {
        //isi       
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        label_titleDataPeminjaman = new javax.swing.JLabel();
        label_dataPeminjamanNama = new javax.swing.JLabel();
        label_dataPeminjamanKelas = new javax.swing.JLabel();
        label_atasNama = new javax.swing.JLabel();
        label_kelas = new javax.swing.JLabel();
        label_titleWaktuPeminjaman = new javax.swing.JLabel();
        label_waktuPeminjaman = new javax.swing.JLabel();
        label_titleWaktuPengembalian = new javax.swing.JLabel();
        label_waktuPengembalian = new javax.swing.JLabel();
        label_titleBarangDipinjam = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_barangDipinjam = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        button_confirm = new javax.swing.JLabel();
        label_titleKondisiBarang = new javax.swing.JLabel();
        radBtn_Rusak = new javax.swing.JRadioButton();
        radBtn_HampirRusak = new javax.swing.JRadioButton();
        radBtn_Baik = new javax.swing.JRadioButton();
        radBtn_SangatBaik = new javax.swing.JRadioButton();
        button_home = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        label_title.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        label_title.setForeground(new java.awt.Color(102, 153, 255));
        label_title.setText("Konfirmasi Pengembalian");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label_titleDataPeminjaman.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleDataPeminjaman.setForeground(new java.awt.Color(102, 153, 255));
        label_titleDataPeminjaman.setText("Data Peminjam : ");

        label_dataPeminjamanNama.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_dataPeminjamanNama.setForeground(new java.awt.Color(102, 153, 255));
        label_dataPeminjamanNama.setText("Atas Nama :");

        label_dataPeminjamanKelas.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_dataPeminjamanKelas.setForeground(new java.awt.Color(102, 153, 255));
        label_dataPeminjamanKelas.setText("Kelas           :");

        label_atasNama.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_atasNama.setForeground(new java.awt.Color(102, 153, 255));
        label_atasNama.setText("John Doe");

        label_kelas.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_kelas.setForeground(new java.awt.Color(102, 153, 255));
        label_kelas.setText("XI RPL 3");

        label_titleWaktuPeminjaman.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleWaktuPeminjaman.setForeground(new java.awt.Color(102, 153, 255));
        label_titleWaktuPeminjaman.setText("Waktu Peminjaman : ");

        label_waktuPeminjaman.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_waktuPeminjaman.setForeground(new java.awt.Color(102, 153, 255));
        label_waktuPeminjaman.setText("{jam tanggal bulan tahun}");

        label_titleWaktuPengembalian.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleWaktuPengembalian.setForeground(new java.awt.Color(102, 153, 255));
        label_titleWaktuPengembalian.setText("Waktu Pengembalian :");

        label_waktuPengembalian.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_waktuPengembalian.setForeground(new java.awt.Color(102, 153, 255));
        label_waktuPengembalian.setText("{jam tanggal bulan tahun}");

        label_titleBarangDipinjam.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleBarangDipinjam.setForeground(new java.awt.Color(102, 153, 255));
        label_titleBarangDipinjam.setText("Barang yang dipinjam :");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table_barangDipinjam.setAutoCreateRowSorter(true);
        table_barangDipinjam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        table_barangDipinjam.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
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
                "Nama Barang", "Validate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_barangDipinjam.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_barangDipinjam.setFillsViewportHeight(true);
        table_barangDipinjam.setGridColor(new java.awt.Color(51, 153, 255));
        table_barangDipinjam.setRowHeight(40);
        table_barangDipinjam.setSelectionForeground(new java.awt.Color(51, 153, 255));
        jScrollPane1.setViewportView(table_barangDipinjam);

        jSeparator1.setForeground(new java.awt.Color(102, 153, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        button_confirm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_confirm.setText("confirm_button");
        button_confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_confirmMouseClicked(evt);
            }
        });

        label_titleKondisiBarang.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleKondisiBarang.setForeground(new java.awt.Color(102, 153, 255));
        label_titleKondisiBarang.setText("Kondisi Barang :");

        radBtn_Rusak.setBackground(new java.awt.Color(255, 255, 255));
        radBtn_Rusak.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        radBtn_Rusak.setForeground(new java.awt.Color(102, 153, 255));
        radBtn_Rusak.setText("Rusak");

        radBtn_HampirRusak.setBackground(new java.awt.Color(255, 255, 255));
        radBtn_HampirRusak.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        radBtn_HampirRusak.setForeground(new java.awt.Color(102, 153, 255));
        radBtn_HampirRusak.setText("Hampir Rusak");

        radBtn_Baik.setBackground(new java.awt.Color(255, 255, 255));
        radBtn_Baik.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        radBtn_Baik.setForeground(new java.awt.Color(102, 153, 255));
        radBtn_Baik.setText("Baik");

        radBtn_SangatBaik.setBackground(new java.awt.Color(255, 255, 255));
        radBtn_SangatBaik.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        radBtn_SangatBaik.setForeground(new java.awt.Color(102, 153, 255));
        radBtn_SangatBaik.setText("Sangat Baik");

        button_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_home.setText("home_button");
        button_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_homeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(label_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_home, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_titleDataPeminjaman)
                            .addComponent(label_titleWaktuPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_titleWaktuPengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_dataPeminjamanNama)
                                    .addComponent(label_dataPeminjamanKelas))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_atasNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_kelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_waktuPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_waktuPeminjaman))
                        .addGap(124, 124, 124)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(label_titleBarangDipinjam))
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_titleKondisiBarang)
                    .addComponent(radBtn_HampirRusak)
                    .addComponent(radBtn_Rusak)
                    .addComponent(radBtn_SangatBaik)
                    .addComponent(radBtn_Baik))
                .addGap(109, 109, 109))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {label_titleWaktuPeminjaman, label_titleWaktuPengembalian});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(label_titleDataPeminjaman)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_dataPeminjamanNama)
                                    .addComponent(label_atasNama))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_dataPeminjamanKelas)
                                    .addComponent(label_kelas))
                                .addGap(38, 38, 38)
                                .addComponent(label_titleWaktuPeminjaman)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_waktuPeminjaman)
                                .addGap(24, 24, 24)
                                .addComponent(label_titleWaktuPengembalian)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_waktuPengembalian))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_titleBarangDipinjam)
                                    .addComponent(label_titleKondisiBarang))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(radBtn_Rusak)
                                        .addGap(18, 18, 18)
                                        .addComponent(radBtn_HampirRusak)
                                        .addGap(18, 18, 18)
                                        .addComponent(radBtn_Baik)
                                        .addGap(18, 18, 18)
                                        .addComponent(radBtn_SangatBaik)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(145, 145, 145)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_confirm, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(button_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_homeMouseClicked
        this.parent.backToHome(this);
    }//GEN-LAST:event_button_homeMouseClicked

    private void button_confirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_confirmMouseClicked
        this.parent.getContentPane().add(berhasilPanel, new BorderLayout().CENTER);
        this.berhasilPanel.setVisible(true);
        this.parent.pengembalianBarangPanel.setVisible(false);
    }//GEN-LAST:event_button_confirmMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_confirm;
    private javax.swing.JLabel button_home;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_atasNama;
    private javax.swing.JLabel label_dataPeminjamanKelas;
    private javax.swing.JLabel label_dataPeminjamanNama;
    private javax.swing.JLabel label_kelas;
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel label_titleBarangDipinjam;
    private javax.swing.JLabel label_titleDataPeminjaman;
    private javax.swing.JLabel label_titleKondisiBarang;
    private javax.swing.JLabel label_titleWaktuPeminjaman;
    private javax.swing.JLabel label_titleWaktuPengembalian;
    private javax.swing.JLabel label_waktuPeminjaman;
    private javax.swing.JLabel label_waktuPengembalian;
    private javax.swing.JRadioButton radBtn_Baik;
    private javax.swing.JRadioButton radBtn_HampirRusak;
    private javax.swing.JRadioButton radBtn_Rusak;
    private javax.swing.JRadioButton radBtn_SangatBaik;
    private javax.swing.JTable table_barangDipinjam;
    // End of variables declaration//GEN-END:variables
}
