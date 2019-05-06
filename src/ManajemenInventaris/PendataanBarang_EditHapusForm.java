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
    private String kondisi_barang;
    private String idBarcode;
    private String imagePath;

    public PendataanBarang_EditHapusForm(PendataanBarang_BarangPanel barangPanel, int idBarang) {
        koneksi = DBconnection.getKoneksi();
        this.barangPanel = barangPanel;
        this.idBarang = idBarang;
        initComponents();
        initGambar();
        gambarBarang.setText("empty");
        noBarang.setEnabled(false);
        showData(this.idBarang);
    }

    private void initGambar() {
        try {
            BufferedImage ubahBtn = ImageIO.read(new File("image\\button\\ubah_btn.png"));
            button_ubah.setIcon(new ImageIcon(ubahBtn.getScaledInstance(ubahBtn.getWidth(), ubahBtn.getHeight(), Image.SCALE_SMOOTH)));
            button_ubah.setText("");
            BufferedImage hapusBtn = ImageIO.read(new File("image\\button\\hapus_btn.png"));
            button_hapus.setIcon(new ImageIcon(hapusBtn.getScaledInstance(hapusBtn.getWidth(), hapusBtn.getHeight(), Image.SCALE_SMOOTH)));
            button_hapus.setText("");
        } catch (IOException ex) {
            ex.printStackTrace();
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
        gambarBarang = new javax.swing.JLabel();
        gambarBarcode = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        barcodeBarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jenisBarang = new javax.swing.JComboBox<>();
        kondisiBarang = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        calTglmasuk = new com.toedter.calendar.JDateChooser();
        pathLabel = new javax.swing.JLabel();
        button_hapus = new javax.swing.JLabel();
        button_ubah = new javax.swing.JLabel();

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

        jLabel5.setText("Kondisi Barang");

        gambarBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gambarBarang.setText("gambar_barang");

        gambarBarcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gambarBarcode.setText("barcode_barang");

        jLabel7.setText("Barcode ID");

        barcodeBarang.setEnabled(false);

        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setText("Save Barcode to PNG");

        jenisBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "asset", "sekali pakai" }));

        kondisiBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "baik", "normal", "hampir rusak", "rusak" }));

        jButton3.setText("Ganti Gambar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Tanggal Masuk");

        pathLabel.setText("Path :");

        button_hapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_hapus.setText("button_hapus");
        button_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_hapusMouseClicked(evt);
            }
        });

        button_ubah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_ubah.setText("button_ubah");
        button_ubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_ubahMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gambarBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gambarBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(calTglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(35, 35, 35)
                            .addComponent(barcodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(namaBarang)
                                        .addComponent(noBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                        .addComponent(jenisBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(kondisiBarang, 0, 234, Short.MAX_VALUE))))
                        .addComponent(jButton3)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(button_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74)
                            .addComponent(button_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pathLabel))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabel4)
                            .addComponent(jenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(kondisiBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(barcodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(calTglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pathLabel)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(gambarBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(gambarBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String temp = Manajemen_Main.getImagePath();
        imagePath = temp.replaceAll("\\\\", "\\\\\\\\\\\\\\\\");
        pathLabel.setText("Path: " + imagePath);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void button_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_hapusMouseClicked
        HapusData();
        try {
            if (barangPanel.parent.pendataanBarangPanel.selectedPanel instanceof PendataanBarang_BarangLayakPakaiPanel) {
                barangPanel.parent.pendataanBarangPanel.reloadTidakLayakPakaiPanel();
                barangPanel.parent.pendataanBarangPanel.reloadLayakPakaiPanel();
            } else if (barangPanel.parent.pendataanBarangPanel.selectedPanel instanceof PendataanBarang_BarangTidakLayakPakaiPanel) {
                barangPanel.parent.pendataanBarangPanel.reloadLayakPakaiPanel();
                barangPanel.parent.pendataanBarangPanel.reloadTidakLayakPakaiPanel();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_button_hapusMouseClicked

    private void button_ubahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_ubahMouseClicked
        editData();
        try {
            if (barangPanel.parent.pendataanBarangPanel.selectedPanel instanceof PendataanBarang_BarangLayakPakaiPanel) {
                barangPanel.parent.pendataanBarangPanel.reloadTidakLayakPakaiPanel();
                barangPanel.parent.pendataanBarangPanel.reloadLayakPakaiPanel();
            } else if (barangPanel.parent.pendataanBarangPanel.selectedPanel instanceof PendataanBarang_BarangTidakLayakPakaiPanel) {
                barangPanel.parent.pendataanBarangPanel.reloadLayakPakaiPanel();
                barangPanel.parent.pendataanBarangPanel.reloadTidakLayakPakaiPanel();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_button_ubahMouseClicked

    public void editData() {
//        this.id_barang = noBarang.getText();
        this.nama_barang = namaBarang.getText();
        this.jenis_barang = jenisBarang.getSelectedItem().toString();
        this.kondisi_barang = kondisiBarang.getSelectedItem().toString();
        this.idBarcode = barcodeBarang.getText();

        try {
            Statement stmt = koneksi.createStatement();
//            String query = "UPDATE barang SET nama_barang = '" + nama_barang + "', jenis_barang = '" + jenis_barang + "', kondisi_barang = '" + kondisi_barang + "' WHERE id_barang = '" + this.idBarang + "'";
//            String updateWithDate = "UPDATE `barang` SET `id_barcode`='" + idBarcode + "',`nama_barang`='" + nama_barang + "',`tanggal_masuk`='" + new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat().format(calTglmasuk.getDate())) + "',`kondisi_barang`='" + kondisi_barang + "',`image`='" + imagePath + "',`type_barang`='" + jenis_barang + "' WHERE id_barang = '" + this.idBarang + "'";
            String updateWithoutDate = "UPDATE `barang` SET `id_barcode`='" + idBarcode + "',`nama_barang`='" + nama_barang + "',`kondisi_barang`='" + kondisi_barang + "',`image`='" + imagePath + "',`type_barang`='" + jenis_barang + "' WHERE id_barang = '" + this.idBarang + "'";

//            java.time.LocalDate localDate = DateWig
            System.out.println(updateWithoutDate);
            int berhasil = stmt.executeUpdate(updateWithoutDate);
            if (berhasil == 1) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada Query");
//        } catch (ParseException ex) {
//            ex.printStackTrace();
        } finally {
            this.dispose();
        }
    }

    public void showData(int idBarang) {
        try {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * FROM barang WHERE id_barang = '" + idBarang + "'";
            ResultSet rs = stmt.executeQuery(query);
            calTglmasuk.setDateFormatString("yyyy-MM-dd");

            if (rs.next()) {
                noBarang.setText(rs.getString("id_barang"));
                namaBarang.setText(rs.getString("nama_barang"));
                jenisBarang.setSelectedItem(rs.getString("type_barang"));
                kondisiBarang.setSelectedItem(rs.getString("kondisi_barang"));
                barcodeBarang.setText(rs.getString("id_barcode"));
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("tanggal_masuk"));
                calTglmasuk.setDate(date);
                BufferedImage barcode = BarcodeMaker.create128BBarcode(rs.getString("id_barcode"));
                gambarBarcode.setIcon(new ImageIcon(barcode.getScaledInstance(barcode.getWidth(), barcode.getHeight(), Image.SCALE_FAST)));
                gambarBarcode.setText("");
                imagePath = rs.getString("image");
                pathLabel.setText("Path: " + imagePath);
                if (imagePath != null || imagePath.equals("") || imagePath.equals("null")) {
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
        } catch (ParseException ex) {
            ex.printStackTrace();
//        } catch (BarcodeException ex) {
//            ex.printStackTrace();
//            gambarBarcode.setText("<html><font color=red>Terjadi masalah saat membuat barcode<html>");
//        } catch (OutputException ex) {
//            ex.printStackTrace();
        }
    }

    public void HapusData() {
        try {
            Statement stmt = koneksi.createStatement();
            String query = "DELETE FROM barang WHERE id_barang = " + this.idBarang + ";";
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
    private javax.swing.JLabel button_hapus;
    private javax.swing.JLabel button_ubah;
    private com.toedter.calendar.JDateChooser calTglmasuk;
    private javax.swing.JLabel gambarBarang;
    private javax.swing.JLabel gambarBarcode;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jenisBarang;
    private javax.swing.JComboBox<String> kondisiBarang;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTextField noBarang;
    private javax.swing.JLabel pathLabel;
    // End of variables declaration//GEN-END:variables
}
