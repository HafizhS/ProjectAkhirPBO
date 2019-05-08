package ManajemenInventaris;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PendataanBarang_DataSiswaPanel extends javax.swing.JPanel {

    private Manajemen_Main parent = null;
    ResultSet result;
    Connection connection;
    PreparedStatement preStatement;
    DefaultTableModel defaultTableModel;
    private Manajemen_PendataanBarangPanel docker = null;

    public PendataanBarang_DataSiswaPanel(Manajemen_Main parent, Manajemen_PendataanBarangPanel docker) throws IOException {
        this.parent = parent;
        this.docker = docker;
        initComponents();
        connection = DBconnection.getKoneksi();
        readData(false, "nama", "ASC");
        loadJurusan();
        loadKelas();
    }
    public void loadKelas() {
         try{
            String sql = "SELECT * FROM tbl_kelas";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                cmbKelas.addItem(rs.getString("nama_kelas"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void loadJurusan() {
     try{
           String sql = "SELECT * FROM tbl_jurusan";
           Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
               cmbJurusan.addItem(rs.getString("nama_jurusan"));
           }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    private void readData(boolean filter, String order_by, String desc_asc) {
        String[] kolomTabel = {"NIS", "Nama", "Kelas", "Jurusan"};
        defaultTableModel = new DefaultTableModel(null, kolomTabel);
        try {
           
           String sql = "SELECT * from tbl_murid"
                    + " INNER JOIN tbl_kelas ON (tbl_murid.id_kelas = tbl_kelas.id_kelas)"
                    + " INNER JOIN tbl_jurusan ON (tbl_murid.id_jurusan = tbl_jurusan.id_jurusan)";
           if(filter){
               sql += "WHERE tbl_jurusan.nama_jurusan LIKE '%"+jurusan+"%' AND nama_kelas LIKE '%" + kelas + "%' AND "
                       + " tbl_murid.nama LIKE '%"+txtSearch.getText()+"%' ORDER BY "+order_by+" "+desc_asc+"";
           }
            System.out.println(sql);
           Statement stmt = connection.createStatement();
           ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                String nis = result.getString("nis");
                String nama = result.getString("nama");
                String kelas = result.getString("nama_kelas"); 
                String jurusan = result.getString("nama_jurusan");

                defaultTableModel.addRow(new String[]{nis, nama, kelas,jurusan});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ada Kesalahan Query");
        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
        }
        siswa_tabel.setModel(defaultTableModel);
        initTableColumn();
    }


    private void initTableColumn() {
        DefaultTableCellRenderer dtr = new DefaultTableCellRenderer();
        dtr.setHorizontalAlignment(JLabel.CENTER);
        siswa_tabel.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        if (siswa_tabel.getColumnModel().getColumnCount() > 0) {

            for (int i = 0; i < siswa_tabel.getColumnCount(); i++) {
                siswa_tabel.getColumnModel().getColumn(i).setCellRenderer(dtr);
            }
            ((DefaultTableCellRenderer) siswa_tabel.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
//        siswa_tabel.getColumnModel().getColumn(0).setCellRenderer(dtr);
//        siswa_tabel.getColumnModel().getColumn(1).setCellRenderer(dtr);
//        siswa_tabel.getColumnModel().getColumn(2).setCellRenderer(dtr);
//        siswa_tabel.getColumnModel().getColumn(3).setCellRenderer(dtr);
        }
        
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        siswa_tabel = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cmbJurusan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbKelas = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        panel_bottom1 = new javax.swing.JPanel();
        detail = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        siswa_tabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        siswa_tabel.setForeground(new java.awt.Color(51, 153, 255));
        siswa_tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIS", "NAMA", "KELAS", "JURUSAN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        siswa_tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        siswa_tabel.setFillsViewportHeight(true);
        siswa_tabel.setGridColor(new java.awt.Color(51, 153, 255));
        siswa_tabel.setOpaque(false);
        siswa_tabel.setRowHeight(40);
        siswa_tabel.setRowSelectionAllowed(false);
        siswa_tabel.setSelectionForeground(new java.awt.Color(51, 153, 255));
        siswa_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siswa_tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(siswa_tabel);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Jurusan");

        cmbJurusan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmbJurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jurusan" }));
        cmbJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJurusanActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Kelas");

        cmbKelas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmbKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelas" }));
        cmbKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKelasActionPerformed(evt);
            }
        });

        btnFilter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cari Bedasarkan Nama");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1347, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(cmbJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(cmbKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_bottom1.setBackground(new java.awt.Color(255, 255, 255));

        detail.setText("Details");
        detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_bottom1Layout = new javax.swing.GroupLayout(panel_bottom1);
        panel_bottom1.setLayout(panel_bottom1Layout);
        panel_bottom1Layout.setHorizontalGroup(
            panel_bottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_bottom1Layout.setVerticalGroup(
            panel_bottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bottom1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(detail)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_bottom1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panel_bottom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    int baris;
    private void siswa_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siswa_tabelMouseClicked
        baris = siswa_tabel.getSelectedRow();
        if(baris == -1) {
            return;
        }else {
            String nis = (String) siswa_tabel.getValueAt(baris, 0);
            detailSiswa ds = new detailSiswa(parent,true,nis);
            ds.setVisible(true); 
        }
    }//GEN-LAST:event_siswa_tabelMouseClicked

    private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
        
        
    }//GEN-LAST:event_detailActionPerformed

    private void cmbJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJurusanActionPerformed

    }//GEN-LAST:event_cmbJurusanActionPerformed

    private void cmbKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKelasActionPerformed
        // TODO add your handling code here:
        //        if(cmbKelas.getSelectedItem().equals("Pilih Kelas")){
            //            showdata(filter(2));
            //        }else{
            //            showdata(filter(6));
            //        }
    }//GEN-LAST:event_cmbKelasActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String search = txtSearch.getText();
        readData(true,"nama","ASC");
    }//GEN-LAST:event_txtSearchKeyReleased
    String jurusan="",kelas="",order="",asc_desc="";
    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
       if(!cmbJurusan.getSelectedItem().toString().equals("Pilih Jurusan")){
            jurusan = cmbJurusan.getSelectedItem().toString();
            order = "nama";
            asc_desc = "ASC";
        }else if(cmbJurusan.getSelectedItem().toString().equals("Pilih Jurusan")){
            jurusan = "";
            order = "nama";
            asc_desc = "ASC";
        }
        if(!cmbKelas.getSelectedItem().toString().equals("Pilih Kelas")){
            kelas = cmbKelas.getSelectedItem().toString();
            order = "nama";
            asc_desc = "ASC";
        }else if(cmbKelas.getSelectedItem().toString().equals("Pilih Kelas")){
            kelas = "";
            order = "nama";
            asc_desc = "ASC";
        }
        readData(true,order,asc_desc);
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        jurusan="";
        kelas="";
        order="";
        asc_desc="";
        txtSearch.setText("");
        readData(false,"nama","ASC");
    }//GEN-LAST:event_btnRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cmbJurusan;
    private javax.swing.JComboBox<String> cmbKelas;
    private javax.swing.JButton detail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_bottom1;
    private javax.swing.JTable siswa_tabel;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
