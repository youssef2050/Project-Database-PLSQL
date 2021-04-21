/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.database.plsql;

import Database.CouresStuedentAndTakesControllerr;
import Model.CouresStudentAndTakesTable;
import Model.TakesTable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Youssef Ezz-Eldeen
 */
public class CouresStudentAndTakesController implements Initializable {

    @FXML
    TableView<CouresStudentAndTakesTable> CouresStudentTakesTable;
    @FXML
    TableColumn<CouresStudentAndTakesTable, String> CouresStudentTakesIDColumn;
    @FXML
    TableColumn<CouresStudentAndTakesTable, String> CouresStudentTakesNameColumn;
    @FXML
    TableColumn<CouresStudentAndTakesTable, String> CouresStudentTakesTitleCouresColumn;
    CouresStuedentAndTakesControllerr controllerrr = new CouresStuedentAndTakesControllerr();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CouresStudentTakesIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        CouresStudentTakesNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        CouresStudentTakesTitleCouresColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        ObservableList<CouresStudentAndTakesTable> dataCridits = FXCollections.observableList(controllerrr.getData());//list
        CouresStudentTakesTable.setItems(dataCridits);
    }

    public void Back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Catowt.fxml"));
        Scene s = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(s);
        stage.setTitle("لوحة التحكم");
        stage.setResizable(false);

    }
}
