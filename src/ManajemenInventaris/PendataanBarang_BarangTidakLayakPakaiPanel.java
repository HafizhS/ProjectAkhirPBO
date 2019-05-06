package ManajemenInventaris;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class PendataanBarang_BarangTidakLayakPakaiPanel extends javax.swing.JPanel {

    private final int MAX_X = 4;
    private int current_x = 0;
    private int current_y = 0;
    private Manajemen_Main parent = null;
    private Manajemen_PendataanBarangPanel docker = null;
    private String query;

    //digunakan saat masa pengembangan
    private static final int DEVONLY_JUMLAH_BARANG = 100;
    private String[] namaBarangs = {"dummy_barang", "barang_dummy", "barang_barang", "dummy_dummy"};
    private File[] gambarBarangs = {new File("image\\smkn4.png"), new File("image\\venom_test.jpg"), new File("image\\white_test.jpg")};
    private String[] kondisi = {"Rusak", "Sangat Rusak"};

    public PendataanBarang_BarangTidakLayakPakaiPanel(Manajemen_Main parent, Manajemen_PendataanBarangPanel docker) throws IOException {
        this.docker = docker;
        this.parent = parent;
        initComponents();
//        initBarang();
        initBarangfromDB();
        initGambar();

    }

    private void initGambar() throws IOException {
    }

    private void initBarangfromDB() {
        try {
            this.query = "select * from barang where kondisi_barang like '%hampir rusak' OR kondisi_barang like '%rusak'";
            ResultSet rs = DBconnection.getKoneksi().createStatement().executeQuery(query);
            int i = 0;

            SwingWorker<Void, String> sw = new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    while (rs.next()) {

                        System.out.println("BarangTidakLayakPakai");
                        GridBagConstraints gbsBarangPanel = new GridBagConstraints();
                        System.out.println(current_x + "<before inc>" + current_y);
                        gbsBarangPanel.gridx = current_x;
                        gbsBarangPanel.gridy = current_y;
                        gbsBarangPanel.insets = new Insets(7, 7, 7, 7);
                        current_y = (current_x != MAX_X) ? current_y : current_y + 1;
                        current_x = (current_x != MAX_X) ? current_x + 1 : 0;
                        System.out.println(current_x + "<after inc>" + current_y);
                        try {
                            JLabel loadingLabel = new JLabel("Loading... [" + (i + 1) + "]");
                            panel_dockerBarang.add(loadingLabel, gbsBarangPanel);
                            panel_dockerBarang.add(new PendataanBarang_BarangPanel(parent, rs.getInt("id_barang")), gbsBarangPanel);
                            panel_dockerBarang.remove(loadingLabel);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        if (docker.selectedPanel.equals(PendataanBarang_BarangTidakLayakPakaiPanel.this)) {
                            docker.revalidate();
                            panel_dockerBarang.updateUI();
                            panel_dockerBarang.revalidate();
                        }
                    }

                    return null;
                }
            };
            sw.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel_dockerBarang = new javax.swing.JPanel();

        setBackground(new java.awt.Color(102, 102, 102));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setToolTipText("");

        panel_dockerBarang.setBackground(new java.awt.Color(255, 255, 255));
        panel_dockerBarang.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(panel_dockerBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_dockerBarang;
    // End of variables declaration//GEN-END:variables
}
