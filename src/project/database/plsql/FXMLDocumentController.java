/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.database.plsql;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Youssef Ezz-Eldeen
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label message;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        message.setText("");
        Connection c = Database.DatabaseConn.conn(username.getText(), password.getText(), message);
        if (c == null) {
            username.setText("");
            password.setText("");
            message.setText("لا يوجد اتصال");
        } else {
            message.setText("تم تسجيل الدخول بنجاح");
            Database.UsernameAndPassword.USERNAME = username.getText();
            Database.UsernameAndPassword.PASSWORD = password.getText();
            username.setText("");
            password.setText("");
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Catowt.fxml"));
                Scene s = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(s);
                stage.setTitle("لوحة التحكم");
                stage.setResizable(false);

            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
