package ManajemenInventaris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PendataanBarang_BarangPanel extends javax.swing.JPanel {

    public int idbarang;
    public Manajemen_Main parent = null;

    //Digunakan pada masa pengembangan
    private String barcodeid;
    private String namaBarang;
    private int kuantitas;
    private BufferedImage gambarBarang;
    private String kondisi;

    public PendataanBarang_BarangPanel(Manajemen_PendataanBarangPanel parent) {
        initComponents();
    }

    public PendataanBarang_BarangPanel(Manajemen_Main parent, int idbarang) {
        this.idbarang = idbarang;
        this.parent = parent;
        initComponents();

        String query = "Select * from barang where id_barang = '" + this.idbarang + "'";

        try {
            ResultSet rs = DBconnection.getKoneksi().createStatement().executeQuery(query);
            if (rs.next()) {

                label_namabarang.setText(rs.getString("nama_barang"));
                kondisi = rs.getString("kondisi_barang");
                switch (kondisi) {
                    case "baik":
                        label_kondisi.setBackground(Color.CYAN);
                        break;
                    case "normal":
                        label_kondisi.setBackground(Color.GREEN);
                        break;
                    case "hampir rusak":
                        label_kondisi.setBackground(Color.YELLOW);
                        break;
                    case "rusak":
                        label_kondisi.setBackground(Color.RED);
                        break;
                    default:
                        label_kondisi.setBackground(Color.BLUE);
                        break;
                }
                label_kondisi.setText(kondisi.toUpperCase());

                if (rs.getString("image") != null) {
                    gambarBarang = ImageIO.read(new File(rs.getString("image")));
                    Dimension scaledDimension = this.parent.getScaledDimension(new Dimension(gambarBarang.getWidth(), gambarBarang.getHeight()), new Dimension(239, 144));
                    label_gambarbarang.setIcon(new ImageIcon(gambarBarang.getScaledInstance((int) scaledDimension.getWidth(), (int) scaledDimension.getHeight(), Image.SCALE_SMOOTH)));
                    label_gambarbarang.setText("");
                } else {
                    label_gambarbarang.setText("Gambar tidak ada");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            label_gambarbarang.setText("Gambar tidak ada");
        } catch (Exception e) {
            e.printStackTrace();

        }

        this.revalidate();
        this.repaint();
    }

    // CONTRUCTOR DUMMY
    public PendataanBarang_BarangPanel(Manajemen_Main parent, String namaBarang, String kondisi, BufferedImage gambarBarang, String barcodeid) {
        this.parent = parent;
        initComponents();
        this.barcodeid = barcodeid;
        this.namaBarang = namaBarang;
        this.kuantitas = 0;
        this.gambarBarang = gambarBarang;
        this.kondisi = kondisi;
        label_namabarang.setText(namaBarang);
        label_kondisi.setText(kondisi);
        label_kondisi.setOpaque(true);
        switch (kondisi) {
            case "Sangat Baik":
                label_kondisi.setBackground(Color.GREEN);
                break;
            case "Baik":
                label_kondisi.setBackground(Color.CYAN);
                break;
            case "Rusak":
                label_kondisi.setBackground(Color.YELLOW);
                break;
            case "Sangat Rusak":
                label_kondisi.setBackground(Color.RED);
                break;
        }
        if (gambarBarang != null) {
            Dimension scaledDimension = this.parent.getScaledDimension(new Dimension(gambarBarang.getWidth(), gambarBarang.getHeight()), new Dimension(239, 144));
            label_gambarbarang.setIcon(new ImageIcon(gambarBarang.getScaledInstance((int) scaledDimension.getWidth(), (int) scaledDimension.getHeight(), Image.SCALE_FAST)));
            label_gambarbarang.setText("");
        } else {
            label_gambarbarang.setText("Gambar tidak ada");
        }
    }

    private void getFromDB() {
        String query = "SELECT * FROM tbl_barang";

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_gambarbarang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        label_namabarang = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_kondisi = new javax.swing.JLabel();

        setBackground(new java.awt.Color(81, 139, 255));

        label_gambarbarang.setBackground(new java.awt.Color(255, 255, 255));
        label_gambarbarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_gambarbarang.setText("gambar_item");
        label_gambarbarang.setOpaque(true);
        label_gambarbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_gambarbarangMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nama Barang: ");

        label_namabarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label_namabarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_namabarang.setText("{nama_barang}");

        jLabel2.setText("Kondisi Barang ");

        label_kondisi.setText("{kondisi}");
        label_kondisi.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label_kondisi)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_namabarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label_gambarbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(label_gambarbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(label_kondisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void label_gambarbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_gambarbarangMouseClicked
        new PendataanBarang_EditHapusForm(this, this.idbarang).setVisible(true);
    }//GEN-LAST:event_label_gambarbarangMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_gambarbarang;
    private javax.swing.JLabel label_kondisi;
    private javax.swing.JLabel label_namabarang;
    // End of variables declaration//GEN-END:variables
}
