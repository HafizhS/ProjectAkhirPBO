package ManajemenInventaris;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

public class SplashScreen extends javax.swing.JFrame {
    // JANGAN GANTI CODE KALAU TIDAK MENGERTI
    // GANTI HANYA ANDA TAU APA YANG ANDA LAKUKAN

    private int mouse_x;
    private int mouse_y;
    private Manajemen_Main mm = null;
    private boolean isUnableToStart = false;

    public SplashScreen() {
        initComponents(); //membuat semua component SplashScreen
        initImage(); // memuat image
        this.setAlwaysOnTop(true); // form selalu didepan
        this.setLocationRelativeTo(null); // center form
        this.setResizable(false); //resizeable form

        draggablePanel(); //membuat jpanel bisa di drag 
        startLoad(); // swing worker
    }

    private void initImage() {

        //membuat dan resize tombol close
        BufferedImage closebtn = null;
        BufferedImage mulaiBtn = null;
        try {
            mulaiBtn = ImageIO.read(new File("image\\button\\mulai_btn.png"));
            closebtn = ImageIO.read(new File("image\\button\\closeX_btn.png"));
            ImageIcon mulaiBtnImage = new ImageIcon(mulaiBtn.getScaledInstance(126, 32, Image.SCALE_SMOOTH));
            ImageIcon closeBtnImage = new ImageIcon(closebtn.getScaledInstance(42, 42, Image.SCALE_SMOOTH));
            button_mulai.setIcon(mulaiBtnImage);
            button_close.setIcon(closeBtnImage);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            button_mulai.setText("");
            button_close.setText("");
        }
    }

    private void draggablePanel() {
        //membuat mouse listener
        panel_splashscreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                //menyimpan coord mouse jika mouse di click
                mouse_x = me.getX();
                mouse_y = me.getY();
                super.mousePressed(me);
            }
        });

        //membuat mouse motion listener
        panel_splashscreen.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                int x = me.getXOnScreen() - mouse_x; //menyimpan coord X dari cursor di layar
                int y = me.getYOnScreen() - mouse_y; //menyimpan coord Y dari cursor di layar
                setLocation(x, y); // menggati posisi FORM/Window
                super.mouseDragged(me);
            }
        });
    }

    private void startLoad() {
        SwingWorker<Void, String> swingWorker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                this.publish("Memuat Komponen Utama...");
                try {
                    mm = new Manajemen_Main();
                    isUnableToStart = true;
                } catch (Exception ex) {
                    this.publish("<html><font color=red>Error memuat komponen utama </font>(" + ex.getMessage() + ")</html>");
                    ex.printStackTrace();
                    this.cancel(true);
                }

                return null;
            }

            @Override
            protected void process(List<String> list) {
                super.process(list);
                label_loading.setText(list.get(list.size() - 1));
            }

            @Override
            protected void done() {
                super.done();
                if (!this.isCancelled()) {
                    this.publish("<html><font color=green>Memuat selesai</font></html>");
                    if (isUnableToStart) {
                        button_mulai.setEnabled(true);
                    }
                }
            }
        };
        swingWorker.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_splashscreen = new javax.swing.JPanel();
        label_title2 = new javax.swing.JLabel();
        label_loading = new javax.swing.JLabel();
        button_close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button_mulai = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manajemen Inventaris");
        setFocusCycleRoot(false);
        setName(""); // NOI18N
        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);

        panel_splashscreen.setBackground(new java.awt.Color(255, 255, 255));
        panel_splashscreen.setForeground(new java.awt.Color(51, 51, 51));

        label_title2.setBackground(new java.awt.Color(10, 136, 240));
        label_title2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        label_title2.setForeground(new java.awt.Color(102, 153, 255));
        label_title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_title2.setText("SMK Negeri 4 Bandung");

        label_loading.setBackground(new java.awt.Color(51, 51, 51));
        label_loading.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        label_loading.setForeground(new java.awt.Color(51, 51, 51));
        label_loading.setText("Loading..");

        button_close.setBackground(new java.awt.Color(255, 255, 255));
        button_close.setForeground(new java.awt.Color(51, 51, 51));
        button_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_close.setText("btn_close");
        button_close.setOpaque(true);
        button_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                button_closeMouseReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selamat Datang Di");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 85)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inventory App");

        button_mulai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_mulai.setText("btn_mulai");
        button_mulai.setEnabled(false);
        button_mulai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_mulaiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_splashscreenLayout = new javax.swing.GroupLayout(panel_splashscreen);
        panel_splashscreen.setLayout(panel_splashscreenLayout);
        panel_splashscreenLayout.setHorizontalGroup(
            panel_splashscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_title2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_splashscreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_splashscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addComponent(label_loading, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_splashscreenLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(button_close))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_splashscreenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(264, 264, 264))
        );
        panel_splashscreenLayout.setVerticalGroup(
            panel_splashscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_splashscreenLayout.createSequentialGroup()
                .addComponent(button_close, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_title2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(button_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_loading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_splashscreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_splashscreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(680, 360));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_closeMouseReleased
        System.exit(0); //close system 0=normal 1=error
    }//GEN-LAST:event_button_closeMouseReleased

    private void button_mulaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_mulaiMouseClicked
        if (isUnableToStart) {
            mm.setVisible(true);
            SplashScreen.this.dispose();
        }
    }//GEN-LAST:event_button_mulaiMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_close;
    private javax.swing.JLabel button_mulai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_loading;
    private javax.swing.JLabel label_title2;
    private javax.swing.JPanel panel_splashscreen;
    // End of variables declaration//GEN-END:variables
}
