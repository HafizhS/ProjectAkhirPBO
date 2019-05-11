package ManajemenInventaris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Manajemen_PendataanBarangPanel extends javax.swing.JPanel {

    public Manajemen_Main parent;
    public JPanel selectedPanel = null;
    private final Color BAR_COLOR_BUTTON_ACTIVE = new Color(79, 134, 243);
    private final Color BAR_COLOR_BUTTON_UNACTIVE = new Color(102, 153, 255);
    private final Font BAR_FONT_BUTTON_ACTIVE = new java.awt.Font("Tahoma", 1, 16);
    private final Font BAR_FONT_BUTTON_UNACTIVE = new java.awt.Font("Tahoma", 0, 16);

    private PendataanBarang_BarangLayakPakaiPanel barangLayakPakaiPanel = null;
    private PendataanBarang_BarangTidakLayakPakaiPanel barangTidakLayakPakaiPanel = null;
    private PendataanBarang_PinjamHistoryPanel pinjamHistoryPanel = null;
    private PendataanBarang_PengembalianHistoryPanel pengembalianHistoryPanel = null;
    private PendataanBarang_DataSiswaPanel dataSiswaPanel = null;
    public int level;
    public Manajemen_PendataanBarangPanel(Manajemen_Main parent, int level) throws IOException {
        this.parent = parent;
        initComponents();
        initGambar();
        this.docker_panel.setLayout(new BorderLayout());
        this.level = level;
        barangTidakLayakPakaiPanel = new PendataanBarang_BarangTidakLayakPakaiPanel(parent, this,this.level);
        barangLayakPakaiPanel = new PendataanBarang_BarangLayakPakaiPanel(parent, this, this.level);
        pinjamHistoryPanel = new PendataanBarang_PinjamHistoryPanel(parent, this, this.level);
        pengembalianHistoryPanel = new PendataanBarang_PengembalianHistoryPanel(parent, this);
        dataSiswaPanel = new PendataanBarang_DataSiswaPanel(parent, this, this.level);

        this.docker_panel.add(barangLayakPakaiPanel, BorderLayout.CENTER);
        this.selectedPanel = barangLayakPakaiPanel;
    }

    private void initGambar() {
        try {
            BufferedImage homeBtn = ImageIO.read(new File("image\\button\\home_white_btn.png"));
            button_home.setIcon(new ImageIcon(homeBtn.getScaledInstance(homeBtn.getWidth(),homeBtn.getHeight(), Image.SCALE_FAST)));
            button_home.setText("");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void reloadLayakPakaiPanel() throws IOException{
        this.docker_panel.remove(barangLayakPakaiPanel);
        this.docker_panel.add(barangLayakPakaiPanel = new PendataanBarang_BarangLayakPakaiPanel(parent, this,this.level));
        this.docker_panel.revalidate();
        this.docker_panel.updateUI();
        this.revalidate();
        this.updateUI();       
    }
    
    public void reloadTidakLayakPakaiPanel() throws IOException{
        this.docker_panel.remove(barangLayakPakaiPanel);
        this.docker_panel.add(barangTidakLayakPakaiPanel = new PendataanBarang_BarangTidakLayakPakaiPanel(parent, this, this.level));
        this.docker_panel.revalidate();
        this.docker_panel.updateUI();
        this.revalidate();
        this.updateUI();    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        button_home = new javax.swing.JLabel();
        bar_barangLayakPakai = new javax.swing.JLabel();
        bar_dataSiswa = new javax.swing.JLabel();
        bar_barangRusak = new javax.swing.JLabel();
        bar_peminjaman = new javax.swing.JLabel();
        bar_pengembalian = new javax.swing.JLabel();
        docker_panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1350, 720));

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

        button_home.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button_home.setForeground(new java.awt.Color(255, 255, 255));
        button_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_home.setText("home_button");
        button_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_homeMouseClicked(evt);
            }
        });

        bar_barangLayakPakai.setBackground(new java.awt.Color(76, 135, 255));
        bar_barangLayakPakai.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bar_barangLayakPakai.setForeground(new java.awt.Color(255, 255, 255));
        bar_barangLayakPakai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bar_barangLayakPakai.setText("Barang layak pakai");
        bar_barangLayakPakai.setOpaque(true);
        bar_barangLayakPakai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bar_barangLayakPakaiMouseClicked(evt);
            }
        });

        bar_dataSiswa.setBackground(new java.awt.Color(102, 153, 255));
        bar_dataSiswa.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bar_dataSiswa.setForeground(new java.awt.Color(255, 255, 255));
        bar_dataSiswa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bar_dataSiswa.setText("Data Siswa");
        bar_dataSiswa.setOpaque(true);
        bar_dataSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bar_dataSiswaMouseClicked(evt);
            }
        });

        bar_barangRusak.setBackground(new java.awt.Color(102, 153, 255));
        bar_barangRusak.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bar_barangRusak.setForeground(new java.awt.Color(255, 255, 255));
        bar_barangRusak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bar_barangRusak.setText("Barang rusak");
        bar_barangRusak.setOpaque(true);
        bar_barangRusak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bar_barangRusakMouseClicked(evt);
            }
        });

        bar_peminjaman.setBackground(new java.awt.Color(102, 153, 255));
        bar_peminjaman.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bar_peminjaman.setForeground(new java.awt.Color(255, 255, 255));
        bar_peminjaman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bar_peminjaman.setText("Peminjaman");
        bar_peminjaman.setOpaque(true);
        bar_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bar_peminjamanMouseClicked(evt);
            }
        });

        bar_pengembalian.setBackground(new java.awt.Color(102, 153, 255));
        bar_pengembalian.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bar_pengembalian.setForeground(new java.awt.Color(255, 255, 255));
        bar_pengembalian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bar_pengembalian.setText("Pengembalian");
        bar_pengembalian.setOpaque(true);
        bar_pengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bar_pengembalianMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_home, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(bar_barangLayakPakai, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bar_barangRusak, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bar_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bar_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bar_dataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_home, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bar_barangLayakPakai, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bar_dataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bar_barangRusak, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bar_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bar_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        docker_panel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(docker_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(docker_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_homeMouseClicked
        this.parent.backToHome(this);
    }//GEN-LAST:event_button_homeMouseClicked

    private void changeBarState(JLabel whichActive) {
        bar_barangLayakPakai.setBackground(BAR_COLOR_BUTTON_UNACTIVE);
        bar_barangLayakPakai.setFont(BAR_FONT_BUTTON_UNACTIVE);

        bar_barangRusak.setBackground(BAR_COLOR_BUTTON_UNACTIVE);
        bar_barangRusak.setFont(BAR_FONT_BUTTON_UNACTIVE);

        bar_peminjaman.setBackground(BAR_COLOR_BUTTON_UNACTIVE);
        bar_peminjaman.setFont(BAR_FONT_BUTTON_UNACTIVE);

        bar_pengembalian.setBackground(BAR_COLOR_BUTTON_UNACTIVE);
        bar_pengembalian.setFont(BAR_FONT_BUTTON_UNACTIVE);

        bar_dataSiswa.setBackground(BAR_COLOR_BUTTON_UNACTIVE);
        bar_dataSiswa.setFont(BAR_FONT_BUTTON_UNACTIVE);

        whichActive.setBackground(BAR_COLOR_BUTTON_ACTIVE);
        whichActive.setFont(BAR_FONT_BUTTON_ACTIVE);
    }

    private void bar_barangLayakPakaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bar_barangLayakPakaiMouseClicked
        changeBarState(bar_barangLayakPakai);

        this.selectedPanel = barangLayakPakaiPanel;
        this.docker_panel.removeAll();
        this.docker_panel.add(barangLayakPakaiPanel, BorderLayout.CENTER);

        this.docker_panel.updateUI();
        this.docker_panel.revalidate();
    }//GEN-LAST:event_bar_barangLayakPakaiMouseClicked

    private void bar_barangRusakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bar_barangRusakMouseClicked
        changeBarState(bar_barangRusak);

        this.selectedPanel = barangTidakLayakPakaiPanel;
        this.docker_panel.removeAll();
        this.docker_panel.add(barangTidakLayakPakaiPanel, BorderLayout.CENTER);

        this.docker_panel.updateUI();
        this.docker_panel.revalidate();
    }//GEN-LAST:event_bar_barangRusakMouseClicked

    private void bar_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bar_peminjamanMouseClicked
        changeBarState(bar_peminjaman);

        this.selectedPanel = pinjamHistoryPanel;
        this.docker_panel.removeAll();
        this.docker_panel.add(pinjamHistoryPanel, BorderLayout.CENTER);

        this.docker_panel.updateUI();
        this.docker_panel.revalidate();
    }//GEN-LAST:event_bar_peminjamanMouseClicked

    private void bar_pengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bar_pengembalianMouseClicked
        changeBarState(bar_pengembalian);

        this.selectedPanel = pengembalianHistoryPanel;
        this.docker_panel.removeAll();
        this.docker_panel.add(pengembalianHistoryPanel, BorderLayout.CENTER);

        this.docker_panel.updateUI();
        this.docker_panel.revalidate();
    }//GEN-LAST:event_bar_pengembalianMouseClicked

    private void bar_dataSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bar_dataSiswaMouseClicked
        changeBarState(bar_dataSiswa);

        this.selectedPanel = dataSiswaPanel;
        this.docker_panel.removeAll();
        this.docker_panel.add(dataSiswaPanel, BorderLayout.CENTER);

        this.docker_panel.updateUI();
        this.docker_panel.revalidate();
    }//GEN-LAST:event_bar_dataSiswaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bar_barangLayakPakai;
    private javax.swing.JLabel bar_barangRusak;
    private javax.swing.JLabel bar_dataSiswa;
    private javax.swing.JLabel bar_peminjaman;
    private javax.swing.JLabel bar_pengembalian;
    private javax.swing.JLabel button_home;
    private javax.swing.JPanel docker_panel;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
