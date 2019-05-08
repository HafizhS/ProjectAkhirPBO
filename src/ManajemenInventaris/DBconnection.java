package ManajemenInventaris;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Driver;

public class DBconnection {

    public static Connection getKoneksi() {

        String host = "localhost";
        String port = "3306";
        String username = "root";
        String password = "";
        String db = "inventory_app";
        String konString = "jdbc:mysql://" + host + ":" + port + "/" + db;
        Connection koneksi = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(konString, username, password);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi Error");
            koneksi = null;
        }

        return koneksi;
    }

    public static void main(String[] args) {
        getKoneksi();
    }
}
