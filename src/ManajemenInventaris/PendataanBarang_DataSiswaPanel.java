package ManajemenInventaris;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        readData();
    }

    private void readData() {
        String[] kolomTabel = {"NIS", "Nama", "Kelas", "Jurusan"};
        defaultTableModel = new DefaultTableModel(null, kolomTabel);
        try {
            connection = DBconnection.getKoneksi();
            preStatement = connection.prepareStatement("SELECT * from tbl_murid ");
            //System.out.println(preStatement);
            result = preStatement.executeQuery();
            while (result.next()) {
                String nis = result.getString("nis");
                String nama = result.getString("nama");
                String kelas = result.getString("id_kelas"); //kelas
//                String jurusan = result.getString("id_peminjaman"); //jurusan

                defaultTableModel.addRow(new String[]{nis, nama, kelas});
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1347, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
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
    }//GEN-LAST:event_siswa_tabelMouseClicked

    private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
        String nis = (String) siswa_tabel.getValueAt(baris, 0);
        detailSiswa ds = new detailSiswa(parent,true,nis);
        ds.setVisible(true);
        
    }//GEN-LAST:event_detailActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_hapus;
    private javax.swing.JLabel button_ubah;
    private javax.swing.JButton detail;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_bottom;
    private javax.swing.JPanel panel_bottom1;
    private javax.swing.JTable siswa_tabel;
    // End of variables declaration//GEN-END:variables
}
