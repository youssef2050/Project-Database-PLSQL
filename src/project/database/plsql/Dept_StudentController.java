/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.database.plsql;

import Database.DeptStudentContorllerr;
import Model.DeptStudentTable;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Youssef Ezz-Eldeen
 */
public class Dept_StudentController implements Initializable {

    @FXML
    TableView<DeptStudentTable> Dept_StudentTable;
    @FXML
    TableColumn<DeptStudentTable, Integer> countNumberColumn;
    @FXML
    TableColumn<DeptStudentTable, String> DeptNameColumn;

    @FXML
    PieChart PieChartCountStudentDeptName;
    DeptStudentContorllerr contorllerr = new DeptStudentContorllerr();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        countNumberColumn.setCellValueFactory(new PropertyValueFactory<>("numberStudent"));
        DeptNameColumn.setCellValueFactory(new PropertyValueFactory<>("NameDepartment"));
        ObservableList<DeptStudentTable> dataCridits = FXCollections.observableList(contorllerr.getDataTable());//list
        Dept_StudentTable.setItems(dataCridits);
        PieChartCountStudentDeptName.setData(contorllerr.getDataChart());

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
