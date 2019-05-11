package ManajemenInventaris;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PeminjamanBarang_AfterPinjamButtonPanel extends javax.swing.JPanel {

    private Manajemen_Main parent = null;
    public String nis;
    public int rowCount;
    public int id_peminjaman;
    public PeminjamanBarang_AfterPinjamButtonPanel(Manajemen_Main parent,String nis,int row,int idPeminjaman) {
        this.parent = parent;
        initComponents();
        this.nis = nis;
        this.rowCount = row;
        loadData();
        this.id_peminjaman = idPeminjaman;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_titleDataPeminjam = new javax.swing.JLabel();
        label_titleDataPeminjam1 = new javax.swing.JLabel();
        label_titleDataPeminjam2 = new javax.swing.JLabel();
        label_titleDataPeminjam3 = new javax.swing.JLabel();
        label_titleDataPeminjam4 = new javax.swing.JLabel();
        label_titleDataPeminjam5 = new javax.swing.JLabel();
        label_titleDataPeminjam6 = new javax.swing.JLabel();
        label_titleDataPeminjam7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(84, 160, 22));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("confirm_button");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(162, 10, 10));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("back_button");
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        label_titleDataPeminjam.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleDataPeminjam.setForeground(new java.awt.Color(51, 102, 255));
        label_titleDataPeminjam.setText("Atas Nama :");

        label_titleDataPeminjam1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleDataPeminjam1.setForeground(new java.awt.Color(51, 102, 255));
        label_titleDataPeminjam1.setText("Konfirmasi Peminjaman");

        label_titleDataPeminjam2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleDataPeminjam2.setForeground(new java.awt.Color(51, 102, 255));
        label_titleDataPeminjam2.setText("Waktu Peminjaman :");

        label_titleDataPeminjam3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleDataPeminjam3.setForeground(new java.awt.Color(51, 102, 255));
        label_titleDataPeminjam3.setText("{waktuPeminjaman}");

        label_titleDataPeminjam4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleDataPeminjam4.setForeground(new java.awt.Color(51, 102, 255));
        label_titleDataPeminjam4.setText("{nama}");

        label_titleDataPeminjam5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleDataPeminjam5.setForeground(new java.awt.Color(51, 102, 255));
        label_titleDataPeminjam5.setText("Total Barang Yang Dipinjam :");

        label_titleDataPeminjam6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleDataPeminjam6.setForeground(new java.awt.Color(51, 102, 255));
        label_titleDataPeminjam6.setText("{sumBarang}");

        label_titleDataPeminjam7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        label_titleDataPeminjam7.setForeground(new java.awt.Color(51, 102, 255));
        label_titleDataPeminjam7.setText("*Catatan : Barang harus di kembalikan sebelum jam pulang sekolah");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_titleDataPeminjam1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_titleDataPeminjam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_titleDataPeminjam4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_titleDataPeminjam2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_titleDataPeminjam3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_titleDataPeminjam5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_titleDataPeminjam6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_titleDataPeminjam7))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(label_titleDataPeminjam1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_titleDataPeminjam)
                    .addComponent(label_titleDataPeminjam4))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_titleDataPeminjam2)
                    .addComponent(label_titleDataPeminjam3))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_titleDataPeminjam5)
                    .addComponent(label_titleDataPeminjam6))
                .addGap(43, 43, 43)
                .addComponent(label_titleDataPeminjam7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(431, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(401, 401, 401))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void simpan() {
        Date date = new Date();
        Date tgl = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
        String now = sdf.format(date);
        String tanggal = frmt.format(date);
        try{
            String sql = "INSERT INTO tbl_peminjaman VALUES('"+id_peminjaman+"','"+nis+"','"+tanggal+"','"+now+"','1')";
            Statement stmt = parent.koneksi.createStatement();
            stmt.executeUpdate(sql);
            System.out.println(sql);
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        simpan();
        parent.backToHome(parent.peminjamanBarangPanel);
        parent.peminjamanBarangPanel.isAlreadyInit = false;
        this.parent.remove(this);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        parent.peminjamanBarangPanel.setVisible(true);
        parent.peminjamanBarangPanel.isAlreadyInit = false;
        this.setVisible(false);
        this.parent.remove(this);
        parent.revalidate();
        this.revalidate();
    }//GEN-LAST:event_jLabel2MouseClicked
    
    public void loadData() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String now = sdf.format(date);
        try{
            String sql = "SELECT * FROM tbl_murid WHERE nis = '"+nis+"'";
            Statement stmt = parent.koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.first();
            System.out.println(sql);
            label_titleDataPeminjam4.setText(rs.getString("nama"));
            label_titleDataPeminjam3.setText(now);
            label_titleDataPeminjam6.setText(rowCount+"");
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_titleDataPeminjam;
    private javax.swing.JLabel label_titleDataPeminjam1;
    private javax.swing.JLabel label_titleDataPeminjam2;
    private javax.swing.JLabel label_titleDataPeminjam3;
    private javax.swing.JLabel label_titleDataPeminjam4;
    private javax.swing.JLabel label_titleDataPeminjam5;
    private javax.swing.JLabel label_titleDataPeminjam6;
    private javax.swing.JLabel label_titleDataPeminjam7;
    // End of variables declaration//GEN-END:variables
}
