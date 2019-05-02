package ManajemenInventaris;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

public class PendataanBarang_EditHapusForm extends javax.swing.JDialog {

    private PendataanBarang_BarangPanel barangPanel = null;
    private int idBarang;
    private Connection koneksi;
    private String action;

    private String id_barang;
    private String nama_barang;
    private String jenis_barang;
    private String status_barang;

    public PendataanBarang_EditHapusForm(PendataanBarang_BarangPanel barangPanel, int idBarang, String act) throws ParseException {
        koneksi = DBconnection.getKoneksi();
        this.barangPanel = barangPanel;
        this.idBarang = idBarang;
        initComponents();
        gambarBarang.setText("HAHAHAHA");

        action = act;
        if (action.equals("Edit")) {
            noBarang.setEnabled(false);
            showData(idBarang);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        noBarang = new javax.swing.JTextField();
        namaBarang = new javax.swing.JTextField();
        jenisBarang = new javax.swing.JTextField();
        statusBarang = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        gambarBarang = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        gambarBarcode = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        barcodeBarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit / Hapus Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Id Barang");

        jLabel3.setText("Nama Barang");

        jLabel4.setText("Jenis Barang");

        jLabel5.setText("Status Barang");

        jButton1.setText("Ubah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gambarBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gambarBarang.setText("gambar_barang");

        jButton2.setText("Hapus Barang");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gambarBarcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gambarBarcode.setText("barcode_barang");

        jLabel7.setText("Barcode ID");

        barcodeBarang.setEnabled(false);

        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setText("Save Barcode to PNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(gambarBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(statusBarang)
                                        .addComponent(jenisBarang)
                                        .addComponent(namaBarang)
                                        .addComponent(noBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel2)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(barcodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1)))
                            .addComponent(jLabel7))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(gambarBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(noBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(statusBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(barcodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(125, 125, 125)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addComponent(gambarBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gambarBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editData();
        try {
            barangPanel.parent.pendataanBarangPanel.reloadLayakPakaiPanel();
            barangPanel.parent.pendataanBarangPanel.reloadLayakPakaiPanel();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HapusData();
        try {
            barangPanel.parent.pendataanBarangPanel.reloadLayakPakaiPanel();
            barangPanel.parent.pendataanBarangPanel.reloadLayakPakaiPanel();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void editData() {
        this.id_barang = noBarang.getText();
        this.nama_barang = namaBarang.getText();
        this.jenis_barang = statusBarang.getText();
        this.status_barang = jenisBarang.getText();

        try {
            Statement stmt = koneksi.createStatement();
            String query = "UPDATE tbl_barang SET nama_barang = '" + nama_barang + "', jenis_barang = '" + jenis_barang + "', status = '" + status_barang + "' WHERE id_barang = '" + id_barang + "'";
            System.out.println(query);
            int berhasil = stmt.executeUpdate(query);
            if (berhasil == 1) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada Query");
        } finally {
            try {
                koneksi.close();
            } catch (SQLException e) {

            }
        }
    }

    public void showData(int idBarang) throws ParseException {
        try {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * FROM tbl_barang WHERE id_barang = '" + idBarang + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                noBarang.setText(rs.getString("id_barang"));
                namaBarang.setText(rs.getString("nama_barang"));
//                jenisBarang.setText(rs.getString("jenis_barang"));
                statusBarang.setText(rs.getString("status"));
                barcodeBarang.setText(rs.getString("id_barcode"));
                gambarBarcode.setIcon(new ImageIcon(BarcodeMaker.createBarcodeImage(rs.getString("id_barcode"))));
                gambarBarcode.setText("");
                String image = rs.getString("image");
                if (image != null) {
                    BufferedImage biImage = ImageIO.read(new File(rs.getString("image")));
                    Dimension scaledDim = Manajemen_Main.getScaledDimension(new Dimension(biImage.getWidth(), biImage.getHeight()), new Dimension(310, 320));
                    gambarBarang.setIcon(new ImageIcon(biImage.getScaledInstance((int) scaledDim.getWidth(), (int) scaledDim.getHeight(), Image.SCALE_SMOOTH)));
                    gambarBarang.setText("");
                } else {
                    gambarBarang.setText("Gambar tidak ada");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan di Query");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            gambarBarang.setText("Gambar tidak ada");
        } catch (BarcodeException ex) {
            ex.printStackTrace();
            gambarBarcode.setText("<html><font color=red>Terjadi masalah saat membuat barcode<html>");
        } catch (OutputException ex) {
            ex.printStackTrace();
        }
    }

    public void HapusData() {
        try {
            Statement stmt = koneksi.createStatement();
            String query = "DELETE FROM tbl_barang WHERE id_barang = " + this.idBarang + ";";
            int berhasil = stmt.executeUpdate(query);
            if (berhasil == 1) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barcodeBarang;
    private javax.swing.JLabel gambarBarang;
    private javax.swing.JLabel gambarBarcode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jenisBarang;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTextField noBarang;
    private javax.swing.JTextField statusBarang;
    // End of variables declaration//GEN-END:variables
}
