package ManajemenInventaris;

import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer
 */
public class DatabaseConnection {
    
    public static Connection getKoneksi() {
     
    String[] dataKoneksi = DatabaseConnection.readSettings();
        
        String host = dataKoneksi[0];
        String port = dataKoneksi[1];
        String username = dataKoneksi[2];
        String password = dataKoneksi[3];
        String db = dataKoneksi[4];
        String konString = "jdbc:mysql://" + host + ":" + port + 
		"/" + db;
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(konString,username,password);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi Database Error");
            koneksi = null;
        }
        return koneksi;
    }

    public static String[] readSettings() {
        String[] data = new String[5];
        BufferedReader br = null;
        FileReader fr = null;

        try {
             fr = new FileReader("lib//data.dea");
             br = new BufferedReader(fr);

            String sCurrentLine;
            
            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                 data[i] = sCurrentLine;  
                 i++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Setting Tidak ditemukan");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }
}