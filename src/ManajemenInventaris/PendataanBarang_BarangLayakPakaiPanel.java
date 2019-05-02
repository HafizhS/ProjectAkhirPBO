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
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class PendataanBarang_BarangLayakPakaiPanel extends javax.swing.JPanel {

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
    private String[] kondisi = {"Baik", "Sangat Baik"};

    public PendataanBarang_BarangLayakPakaiPanel(Manajemen_Main parent, Manajemen_PendataanBarangPanel docker) throws IOException {
        this.docker = docker;
        this.parent = parent;
        initComponents();
//        initBarang();
        initBarangfromDB();
        initGambar();

    }

    private void initBarangfromDB() {

        try {
            this.query = "select * from tbl_barang where status = 'SANGAT BAIK' OR status = 'BAIK'";
            ResultSet rs = DBconnection.getKoneksi().createStatement().executeQuery(query);
            int i = 0;
            
            SwingWorker<Void, String> sw = new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    while (rs.next()) {

                        System.out.println("BarangLayakPakai");
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

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        if (docker.selectedPanel.equals(PendataanBarang_BarangLayakPakaiPanel.this)) {
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

    private void initGambar() throws IOException {
        BufferedImage tambahBtn = ImageIO.read(new File("image\\button\\tambah_btn.png"));

        button_tambah.setIcon(new ImageIcon(tambahBtn.getScaledInstance(tambahBtn.getWidth(), tambahBtn.getHeight(), Image.SCALE_SMOOTH)));
        button_tambah.setText("");
    }

    private void initBarang() {
        SwingWorker<Void, String> sw = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < DEVONLY_JUMLAH_BARANG; i++) {
                    System.out.println("BarangLayakPakai");
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
                        panel_dockerBarang.add(new PendataanBarang_BarangPanel(parent,
                                namaBarangs[new Random().nextInt(namaBarangs.length)],
                                kondisi[new Random().nextInt(kondisi.length)],
                                ImageIO.read(gambarBarangs[new Random().nextInt(gambarBarangs.length)]),
                                ""), gbsBarangPanel);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (docker.selectedPanel.equals(PendataanBarang_BarangLayakPakaiPanel.this)) {
                        docker.revalidate();
                        panel_dockerBarang.updateUI();
                        panel_dockerBarang.revalidate();
                    }
                }
                return null;
            }
        };
        sw.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel_dockerBarang = new javax.swing.JPanel();
        panel_bottom = new javax.swing.JPanel();
        button_tambah = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setToolTipText("");

        panel_dockerBarang.setBackground(new java.awt.Color(255, 255, 255));
        panel_dockerBarang.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(panel_dockerBarang);

        panel_bottom.setBackground(new java.awt.Color(255, 255, 255));

        button_tambah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_tambah.setText("tambah_button");
        button_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_tambahMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_bottomLayout = new javax.swing.GroupLayout(panel_bottom);
        panel_bottom.setLayout(panel_bottomLayout);
        panel_bottomLayout.setHorizontalGroup(
            panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_bottomLayout.setVerticalGroup(
            panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
                    .addComponent(panel_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panel_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_tambahMouseClicked
        BarangLayakPakai_TambahForm form = new BarangLayakPakai_TambahForm();
        form.setVisible(true);
    }//GEN-LAST:event_button_tambahMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_tambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_bottom;
    private javax.swing.JPanel panel_dockerBarang;
    // End of variables declaration//GEN-END:variables
}
