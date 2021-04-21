/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.database.plsql;

import Database.Credits;
import Model.CreditsTable;
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

public class CourseCreditController implements Initializable {

    @FXML
    TableView<CreditsTable> CreditTable;
    @FXML
    TableColumn<CreditsTable, String> credits;
    @FXML
    TableColumn<CreditsTable, String> title;
    @FXML
    TableColumn<CreditsTable, String> NameStudent;
    Credits c = new Credits();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        credits.setCellValueFactory(new PropertyValueFactory<>("Credit"));
        title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        NameStudent.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ObservableList<CreditsTable> dataCridits = FXCollections.observableList(c.DataCridet());//list
        CreditTable.setItems(dataCridits);
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
