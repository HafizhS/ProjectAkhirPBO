/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManajemenInventaris;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Farhanunnasih
 */
public class DBConnection {
    public static Connection getConnection() {
            Connection connection = null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/inventory_app";
		String user = "root";
		String password = "";
		try {
                    Class.forName(JDBC_DRIVER);
                    connection = DriverManager.getConnection(url, user, password);
		}catch(SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                    return connection = null;
		}
		return connection;
	}
}
