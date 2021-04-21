/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.database.plsql;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Youssef Ezz-Eldeen
 */
public class CatowtController implements Initializable {

    public void HomePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene s = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(s);
        stage.setTitle("العمليات على جدول الطلاب");
        stage.setResizable(false);

    }

    public void CouresStudentAndTakes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CouresStudentAndTakes.fxml"));
        Scene s = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(s);
        stage.setTitle("عرض جدول بالمساقات التى اخذها الطلاب");
        stage.setResizable(false);

    }

    public void CourseOp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Course.fxml"));
        Scene s = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(s);
        stage.setTitle("العمليات على جدول المساقات");
        stage.setResizable(false);

    }

    public void CouresCredit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CourseCredit.fxml"));
        Scene s = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(s);
        stage.setTitle("credits عرض");
        stage.setResizable(false);

    }

    public void DeptStudent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dept_Student.fxml"));
        Scene s = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(s);
        stage.setTitle("عدد الطلاب في كل قسم");
        stage.setResizable(false);

    }

    public void Takes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Takes.fxml"));
        Scene s = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(s);
        stage.setTitle("عرض جدولTakes");
        stage.setResizable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
