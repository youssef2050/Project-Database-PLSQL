/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.database.plsql;

import Database.TakesControllerrr;
import Model.CreditsTable;
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
public class TakesController implements Initializable {

    @FXML
    TableView<TakesTable> TakesTable;
    @FXML
    TableColumn<TakesTable, String> ID_Column;
    @FXML
    TableColumn<TakesTable, String> Coutse_Id_column;
    @FXML
    TableColumn<TakesTable, String> Sec_id_column;
    @FXML
    TableColumn<TakesTable, String> Semester_column;
    @FXML
    TableColumn<TakesTable, String> Year_column;
    @FXML
    TableColumn<TakesTable, String> Grade_column;
    TakesControllerrr controllerrr = new TakesControllerrr();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ID_Column.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Coutse_Id_column.setCellValueFactory(new PropertyValueFactory<>("COURSE_ID"));
        Sec_id_column.setCellValueFactory(new PropertyValueFactory<>("SEC_ID"));
        Semester_column.setCellValueFactory(new PropertyValueFactory<>("SEMESTER"));
        Year_column.setCellValueFactory(new PropertyValueFactory<>("YEAR"));
        Grade_column.setCellValueFactory(new PropertyValueFactory<>("GRADE"));
        ObservableList<TakesTable> dataCridits = FXCollections.observableList(controllerrr.getData());//list
        TakesTable.setItems(dataCridits);
    }

    public void Back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Catowt.fxml"));
        Scene s = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(s);
        stage.setTitle("???????? ????????????");
        stage.setResizable(false);
    }
}
