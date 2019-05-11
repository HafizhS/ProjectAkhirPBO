package ManajemenInventaris;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class PendataanBarang_PinjamHistoryPanel extends javax.swing.JPanel {
    DefaultTableModel dtm;
    private Manajemen_Main parent = null;
    private Manajemen_PendataanBarangPanel docker = null;
    SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd"); 
    int level ;
    public PendataanBarang_PinjamHistoryPanel(Manajemen_Main parent, Manajemen_PendataanBarangPanel docker,int level) throws IOException {
        this.parent = parent;
        this.docker = docker;
        initComponents();
        initImage();
       showdata(false, "id_pengembalian", "ASC");
       Date date = new Date();
       tanggal1 = tf.format(date);
       tanggal2 = tf.format(date);
       terbaru.setSelected(true);
       this.level = level;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel_bottom = new javax.swing.JPanel();
        button_ubah = new javax.swing.JLabel();
        button_hapus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_pinjamHistory = new javax.swing.JTable();
        tgl1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tgl2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        terbaru = new javax.swing.JRadioButton();
        terlama = new javax.swing.JRadioButton();
        btnRefresh = new javax.swing.JButton();
        btnFilter1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(79, 134, 243));
        setForeground(new java.awt.Color(79, 134, 243));

        panel_bottom.setBackground(new java.awt.Color(255, 255, 255));

        button_ubah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_ubah.setText("edit_button");

        button_hapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_hapus.setText("hapus_button");

        jLabel2.setText("Hanya Super Admin yang hanya diperbolehkan Memanipulasi/Menyunting data History Peminjaman");

        javax.swing.GroupLayout panel_bottomLayout = new javax.swing.GroupLayout(panel_bottom);
        panel_bottom.setLayout(panel_bottomLayout);
        panel_bottomLayout.setHorizontalGroup(
            panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(button_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_bottomLayout.setVerticalGroup(
            panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottomLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        table_pinjamHistory.setRowHeight(40);
        table_pinjamHistory.setRowSelectionAllowed(false);
        table_pinjamHistory.setSelectionForeground(new java.awt.Color(51, 153, 255));
        table_pinjamHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_pinjamHistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_pinjamHistory);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tampilkan Berdasarkan tanggal");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("-");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tampilkan Berdasarkan Waktu");

        buttonGroup1.add(terbaru);
        terbaru.setText("Terbaru");
        terbaru.setOpaque(false);

        buttonGroup1.add(terlama);
        terlama.setText("Terlama");
        terlama.setOpaque(false);

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setBorderPainted(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnFilter1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFilter1.setText("Filter");
        btnFilter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilter1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
            .addComponent(panel_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(24, 24, 24)
                        .addComponent(terbaru)
                        .addGap(18, 18, 18)
                        .addComponent(terlama, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(terbaru)
                            .addComponent(terlama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(panel_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        showdata(false, "id_pengembalian", "ASC");
        tgl1.setDate(null);
        tgl2.setDate(null);
       asc_desc="";
       order_by="";
       terbaru.setSelected(true);
    }//GEN-LAST:event_btnRefreshActionPerformed
    String tanggal1 ="",tanggal2 = "",asc_desc="",order_by="";
    private void btnFilter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilter1ActionPerformed

        Date date = new Date();
        Date Tanggal1 = tgl1.getDate();
        Date Tanggal2 = tgl2.getDate();
        if((Tanggal1 != null) && (Tanggal2 != null) ){
            tanggal1 = tf.format(tgl1.getDate());
            tanggal2 = tf.format(tgl2.getDate());
            asc_desc = "ASC";
            order_by = "tgl_pengembalian";
        } else if((Tanggal1 != null) && (Tanggal2 == null)) {

            tanggal1 = tf.format(tgl1.getDate());
            tanggal2 = tf.format(date);
            asc_desc = "ASC";
            order_by = "tgl_pengembalian";
        } else if((Tanggal1 == null) && (Tanggal2 != null)) {
            tanggal1 = tf.format(date);
            tanggal2 = tf.format(tgl2.getDate());
            asc_desc = "ASC";
            order_by = "tgl_pengembalian";
        }
        if(terbaru.isSelected()) {
            asc_desc = "DESC";
            order_by = "waktu_peminjaman";
        }
        if(terlama.isSelected()) {
            asc_desc = "ASC";
            order_by = "waktu_peminjaman";
        }
        showdata(true,order_by,asc_desc);
    }//GEN-LAST:event_btnFilter1ActionPerformed
    int baris;
    private void table_pinjamHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_pinjamHistoryMouseClicked
        baris = table_pinjamHistory.getSelectedRow();
        
        if(baris == -1) {
            return;
        }else {
            String id_peminjaman = (String) table_pinjamHistory.getValueAt(baris, 1);
            detailPinjamHistory dph = new detailPinjamHistory(parent,true,id_peminjaman,this.level);
            dph.setVisible(true);
        } 
    }//GEN-LAST:event_table_pinjamHistoryMouseClicked

    public void showdata(boolean filter, String orderBy, String desc_asc){
    String [] kolom = {"NO" , "ID Peminjaman","Nama","NIS","Waktu Peminjaman","Tanggal Peminjaman"};
    dtm = new DefaultTableModel (null,kolom);
    int no = 1;
    try{
        Statement stmt = parent.koneksi.createStatement();
        String query = "SELECT * FROM tbl_peminjaman "
                +"INNER JOIN tbl_murid ON (tbl_peminjaman.nis = tbl_murid.nis) WHERE (tbl_peminjaman.status = '1')";
                if(filter) {
                    query += " AND tgl_peminjaman >= '"+tanggal1+"' AND tgl_peminjaman <= '"+tanggal2+"'"
                        + " ORDER BY "+orderBy+" "+desc_asc+" ";
                }
                System.out.println(query);
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                String id_peminjaman = String.valueOf(rs.getString("id_peminjaman"));
                String nis = String.valueOf(rs.getInt("nis"));
                String nama = rs.getString("nama");
                String tgl_peminjaman = rs.getDate("tgl_peminjaman").toString();
                String wkt_peminjaman = rs.getTime("waktu_peminjaman").toString();
                
                dtm.addRow(new String [] {
                    no + "" , id_peminjaman,nama,nis, tgl_peminjaman,wkt_peminjaman
                });
                no++;
                
                }
                table_pinjamHistory.setModel(dtm);
    }catch(SQLException ex) {
        ex.printStackTrace();
    }
    
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter1;
    private javax.swing.JButton btnRefresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel button_hapus;
    private javax.swing.JLabel button_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_bottom;
    private javax.swing.JTable table_pinjamHistory;
    private javax.swing.JRadioButton terbaru;
    private javax.swing.JRadioButton terlama;
    private com.toedter.calendar.JDateChooser tgl1;
    private com.toedter.calendar.JDateChooser tgl2;
    // End of variables declaration//GEN-END:variables
}
