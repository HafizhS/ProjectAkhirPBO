package ManajemenInventaris;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
//        bgKondisi.add(radBtn_Rusak);
//        bgKondisi.add(radBtn_HampirRusak);
//        bgKondisi.add(radBtn_Baik);
//        bgKondisi.add(radBtn_SangatBaik);

        try {
            ResultSet rs = getUserDataFromDB(idMurid);
            if (rs.next()) {
                label_atasNama.setText(rs.getString("nama"));
                label_kelas.setText(rs.getString("nama_kelas"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        scanBarcode.requestDefaultFocus();
        scanBarcode.requestFocus();
        scanBarcode.setFocusable(true);
        txtnis.setVisible(false);
        id_peminjaman.setVisible(true);
        loadDataPeminjam();
        loadTable();
    }
    
    public void loadDataPeminjam() {
        Date date = new Date();
        SimpleDateFormat Format = new SimpleDateFormat("HH:mm:ss");
        String now = Format.format(date);
        try{
            String sql = "SELECT * FROM tbl_kelas,tbl_detail_peminjaman,tbl_peminjaman,tbl_murid "
                    + "WHERE(tbl_peminjaman.nis = tbl_murid.nis) AND (tbl_detail_peminjaman.id_peminjaman = tbl_detail_peminjaman.id_peminjaman)"
                    + "AND (tbl_peminjaman.nis = '"+idMurid+"') AND (tbl_murid.id_kelas = tbl_kelas.id_kelas) and tbl_peminjaman.status = '1' ";
            Statement stmt = parent.koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            rs.first();
            label_atasNama.setText(rs.getString("nama"));
            label_kelas.setText(rs.getString("nama_kelas"));
            label_waktuPeminjaman.setText(rs.getTime("waktu_peminjaman").toString());
            label_waktuPengembalian.setText(now);
            id_peminjaman.setText(rs.getInt("tbl_peminjaman.id_peminjaman")+"");
            txtnis.setText(rs.getInt("tbl_murid.nis")+"");
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    DefaultTableModel dtm;
    public void loadTable() {
        String[] kolom = {"ID BARCODE","NAMA BARANG","TIPE BARANG","STATUS"};
        dtm = new DefaultTableModel(null,kolom);
        try{
            String sql = "SELECT * FROM tbl_detail_peminjaman,tbl_peminjaman,tbl_barang "
                    + "WHERE (tbl_detail_peminjaman.id_peminjaman = tbl_peminjaman.id_peminjaman) "
                    + "AND (tbl_detail_peminjaman.id_barang = tbl_barang.id_barcode) "
                    + "AND (tbl_peminjaman.nis = '"+idMurid+"') AND (tbl_peminjaman.status = '1') "
                    + "AND (tbl_detail_peminjaman.status = '1') AND (tbl_barang.type_barang = 'asset' )";
            Statement stmt = parent.koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            while(rs.next()) {
                String id_barcode = rs.getString("id_barcode");
                String namaBarang = rs.getString("nama_barang");
                String tipeBarang = rs.getString("type_barang");
                dtm.addRow(new String[] {
                    id_barcode,namaBarang,tipeBarang,"BELUM DI KEMBALIKAN"
                });
            }
        }catch(SQLException ex) {
            
        }
        table_barangDipinjam.setModel(dtm);
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
        button_home = new javax.swing.JLabel();
        scanBarcode = new javax.swing.JTextField();
        id_peminjaman = new javax.swing.JLabel();
        txtnis = new javax.swing.JLabel();

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

        button_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_home.setText("home_button");
        button_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_homeMouseClicked(evt);
            }
        });

        scanBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                scanBarcodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                scanBarcodeKeyTyped(evt);
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label_waktuPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label_waktuPeminjaman))
                            .addGap(124, 124, 124))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_titleDataPeminjaman)
                                .addComponent(label_titleWaktuPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_titleWaktuPengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label_dataPeminjamanNama)
                                        .addComponent(label_dataPeminjamanKelas)
                                        .addComponent(txtnis))
                                    .addGap(8, 8, 8)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label_atasNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label_kelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(scanBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(150, 150, 150)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id_peminjaman)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(label_titleBarangDipinjam))
                .addGap(368, 368, 368))
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
                        .addGap(11, 11, 11)
                        .addComponent(label_titleBarangDipinjam)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addGap(145, 145, 145))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnis)
                        .addGap(18, 18, 18)
                        .addComponent(label_titleWaktuPeminjaman)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_waktuPeminjaman)
                        .addGap(24, 24, 24)
                        .addComponent(label_titleWaktuPengembalian)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_waktuPengembalian)
                        .addGap(18, 18, 18)
                        .addComponent(scanBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id_peminjaman)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
       if(table_barangDipinjam.getRowCount() == 0) {
           simpan();
           ubahStatusPeminjaman();
        this.parent.getContentPane().add(berhasilPanel, new BorderLayout().CENTER);
        this.berhasilPanel.setVisible(true);
        this.parent.pengembalianBarangPanel.setVisible(false);
       }else if(table_barangDipinjam.getRowCount() >= 0){
           JOptionPane.showMessageDialog(null,"Barang yang anda masukkan belum semua");
       }
        
    }//GEN-LAST:event_button_confirmMouseClicked
    
    public void ubahStatusPeminjaman() {
        try{
            String sql = "UPDATE tbl_peminjaman SET status = '0' WHERE id_peminjaman = '"+id_peminjaman.getText()+"'";
            Statement stmt = parent.koneksi.createStatement();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            loadTable();
            id_peminjaman.setText("");
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    int id_pengembalian;
    public void simpan() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = sdf.format(date);
        
        Random random = new Random();
        for (int i = 1; i <= 1; i++) {
            id_pengembalian = 1+random.nextInt(100000);
        } 
        
        
        try{
            String sql = "INSERT INTO tbl_pengembalian "
                    + "VALUES('"+id_pengembalian+"', '"+txtnis.getText()+"','"+tanggal+"', '"+label_waktuPengembalian.getText()+"') ";
            Statement stmt = parent.koneksi.createStatement();
            System.out.println(sql);
            stmt.executeUpdate(sql);
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void scanBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scanBarcodeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_scanBarcodeKeyTyped

    private void scanBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scanBarcodeKeyPressed
      
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            try{
                String sql = "UPDATE tbl_detail_peminjaman SET status = '0' "
                        + "WHERE id_barang = '"+scanBarcode.getText()+"' AND id_peminjaman = '"+id_peminjaman.getText()+"'";
                Statement stmt = parent.koneksi.createStatement();
                System.out.println(sql);
                stmt.executeUpdate(sql);
                loadTable();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_scanBarcodeKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_confirm;
    private javax.swing.JLabel button_home;
    private javax.swing.JLabel id_peminjaman;
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
    private javax.swing.JLabel label_titleWaktuPeminjaman;
    private javax.swing.JLabel label_titleWaktuPengembalian;
    private javax.swing.JLabel label_waktuPeminjaman;
    private javax.swing.JLabel label_waktuPengembalian;
    private javax.swing.JTextField scanBarcode;
    private javax.swing.JTable table_barangDipinjam;
    private javax.swing.JLabel txtnis;
    // End of variables declaration//GEN-END:variables
}
