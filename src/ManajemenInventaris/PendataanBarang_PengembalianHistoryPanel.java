package ManajemenInventaris;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class PendataanBarang_PengembalianHistoryPanel extends javax.swing.JPanel {
    DefaultTableModel dtm;
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
    
    public void showdata() {
        String [] kolom = {"No" , "ID Pengembalian","Nama","NIS","Waktu Pengembelian","Tanggal Pengembalian"};
        dtm = new DefaultTableModel (null,kolom);
        int no = 1;
        try{
            Statement stmt = parent.koneksi.createStatement();
            String query = "SELECT * FROM tbl_pengembalian " 
                    + "INNER JOIN tbl_murid ON (tbl_pengembalian.id_murid = tbl_murid.id_murid)";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                String id_pengembalian = String.valueOf(("id_pengembalian"));
                String nis = String.valueOf(rs.getInt("nis"));
                String nama = rs.getString("nama");
                String tgl_pengembalian = rs.getDate("tgl_pengembalian").toString();
                String wkt_pengembalian = rs.getTime("waktu_pengembalian").toString();
                
                dtm.addRow(new String[] {
                   no + "" , id_pengembalian,nama,nis, tgl_pengembalian,wkt_pengembalian
                });
                no++;
            }
           table_pinjamHistory.setModel(dtm);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     public void filterNama() {
        String [] kolom = {"No" , "ID Pengembalian","Nama","NIS","Waktu Pengembelian","Tanggal Pengembalian"};
        dtm = new DefaultTableModel (null,kolom);
        int no = 1;
        try{
            Statement stmt = parent.koneksi.createStatement();
            String query = "SELECT * FROM tbl_pengembalian " 
                    + "INNER JOIN tbl_murid ON (tbl_pengembalian.id_murid = tbl_murid.id_murid)"
                    + "WHERE nama LIKE '%"+nama.getText()+"%'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                String id_pengembalian = String.valueOf(("id_pengembalian"));
                String nis = String.valueOf(rs.getInt("nis"));
                String nama = rs.getString("nama");
                String tgl_pengembalian = rs.getDate("tgl_pengembalian").toString();
                String wkt_pengembalian = rs.getTime("waktu_pengembalian").toString();
                
                dtm.addRow(new String[] {
                   no + "" , id_pengembalian,nama,nis, tgl_pengembalian,wkt_pengembalian
                });
                no++;
            }
           table_pinjamHistory.setModel(dtm);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
      String asc_desc;
      String orderBy;
      public void filterOrderBy() {
        String [] kolom = {"No" , "ID Pengembalian","Nama","NIS","Waktu Pengembelian","Tanggal Pengembalian"};
        dtm = new DefaultTableModel (null,kolom);
        int no = 1;
        try{
            Statement stmt = parent.koneksi.createStatement();
            String query = "SELECT * FROM tbl_pengembalian " 
                    + "INNER JOIN tbl_murid ON (tbl_pengembalian.id_murid = tbl_murid.id_murid)"
                    + "ORDER BY "+orderBy+" "+asc_desc+"";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                String id_pengembalian = String.valueOf(("id_pengembalian"));
                String nis = String.valueOf(rs.getInt("nis"));
                String nama = rs.getString("nama");
                String tgl_pengembalian = rs.getDate("tgl_pengembalian").toString();
                String wkt_pengembalian = rs.getTime("waktu_pengembalian").toString();
                
                dtm.addRow(new String[] {
                   no + "" , id_pengembalian,nama,nis, tgl_pengembalian,wkt_pengembalian
                });
                no++;
            }
           table_pinjamHistory.setModel(dtm);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_bottom = new javax.swing.JPanel();
        button_hapus = new javax.swing.JLabel();
        button_ubah = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_pinjamHistory = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 102));

        panel_bottom.setBackground(new java.awt.Color(255, 255, 255));

        button_hapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_hapus.setText("hapus_button");

        button_ubah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_ubah.setText("edit_button");

        jLabel2.setText("Hanya Super Admin yang hanya diperbolehkan Memanipulasi/Menyunting data History Pengembalian");

        nama.setText("jTextField1");

        javax.swing.GroupLayout panel_bottomLayout = new javax.swing.GroupLayout(panel_bottom);
        panel_bottom.setLayout(panel_bottomLayout);
        panel_bottomLayout.setHorizontalGroup(
            panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jLabel2)
                .addGap(113, 113, 113)
                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
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
                .addGroup(panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(panel_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panel_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_hapus;
    private javax.swing.JLabel button_ubah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nama;
    private javax.swing.JPanel panel_bottom;
    private javax.swing.JTable table_pinjamHistory;
    // End of variables declaration//GEN-END:variables
}
