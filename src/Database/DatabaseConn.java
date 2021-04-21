/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Label;

/**
 *
 * @author Youssef Ezz-Eldeen
 */
public class DatabaseConn {

    public static Connection conn(String username, String password, Label message) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", username, password);

        } catch (ClassNotFoundException | SQLException ex) {
            message.setText(ex.getMessage());
        }
        return conn;
    }

}
