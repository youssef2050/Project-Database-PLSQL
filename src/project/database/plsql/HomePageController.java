/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.database.plsql;

import Database.StudentDateAndControllerr;
import Model.StudentTable;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Youssef Ezz-Eldeen
 */
public class HomePageController implements Initializable {

    StudentDateAndControllerr andControllerr = new StudentDateAndControllerr();
    URL url;
    ResourceBundle rb;
    @FXML
    TextField Student_ID;
    @FXML
    TextField Student_Name;
    @FXML
    ComboBox Student_Dept;
    @FXML
    TextField Student_Cred;
    @FXML
    TableView<StudentTable> DataStudent;
    @FXML
    TableColumn<StudentTable, String> SutdentID;
    @FXML
    TableColumn<StudentTable, String> SutdentName;
    @FXML
    TableColumn<StudentTable, String> SutdentDeptName;
    @FXML
    TableColumn<StudentTable, Double> SutdentTotCred;
    ObservableList<StudentTable> dataStudent;
    @FXML
    TextField search;
    @FXML
    Button button;
    @FXML
    Button close;
    static String ID;
    String messageerror;
    @FXML
    Label message;

    @FXML
    private void Add(ActionEvent e) throws Exception {
        if (button.getText().equals("Add")) {
            if (!Student_Dept.getSelectionModel().isEmpty() && !Student_Cred.getText().isEmpty() && !Student_ID.getText().isEmpty() && !Student_Name.getText().isEmpty()) {
                andControllerr.InsertStudent(Student_ID.getText(),
                        Student_Name.getText(),
                        Student_Dept.getSelectionModel().getSelectedItem().toString(),
                        Double.parseDouble(Student_Cred.getText()));
                Student_ID.setText("");
                Student_Name.setText("");
                Student_Cred.setText("");
                Student_Dept.getSelectionModel().clearSelection();
            } else {
                message.setText("تأكد من جميع القيم مدخل بشكل صحيح ...");
            }
        } else if (button.getText().equals("Update")) {
            if (!Student_Dept.getSelectionModel().isEmpty() && !Student_Cred.getText().isEmpty() && !Student_ID.getText().isEmpty() && !Student_Name.getText().isEmpty()) {
                messageerror = andControllerr.UpdateStudent(ID, Student_ID.getText(), Student_Name.getText(),
                        Student_Dept.getSelectionModel().getSelectedItem().toString(),
                        Double.parseDouble(Student_Cred.getText()));
                button.setText("Add");
                Student_ID.setText("");
                Student_Name.setText("");
                Student_Cred.setText("");
                Student_Dept.getSelectionModel().clearSelection();
                message.setText(messageerror);
            } else {
                messageerror = andControllerr.UpdateStudent(null, null, null, null, 0);
                message.setText(messageerror);
            }

        } else if (button.getText().equals("Delete")) {
            if (!ID.equals("")) {
                messageerror = andControllerr.DeleteStudent(ID);
                button.setText("Add");
                Student_ID.setText("");
                Student_Name.setText("");
                Student_Cred.setText("");
                Student_Dept.getSelectionModel().clearSelection();
                message.setText(messageerror);
            } else {
                messageerror = andControllerr.DeleteStudent(null);
                message.setText(messageerror);
            }
        }
        initialize(url, rb);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.url = url;
        this.rb = rb;

        ObservableList<String> Student_Dept_data = FXCollections.observableList(andControllerr.DateDepartment());//list
        Student_Dept.setItems(Student_Dept_data);
        //Table Data
        ArrayList<StudentTable> Data = (ArrayList<StudentTable>) andControllerr.DataStudent();
        search.textProperty().addListener((observable, oldText, newText) -> {

            ArrayList<StudentTable> searchData = new ArrayList<>();

            for (StudentTable st : Data) {
                if (st.getName().contains(newText) || st.getId().contains(newText) || st.getDeptID().contains(newText) || (st.getTot_cred() + "").contains(newText)) {
                    searchData.add(st);
                } else {

                }
            }

            dataStudent = FXCollections.observableList(searchData);
            DataStudent.setItems(dataStudent);
        });

        dataStudent = FXCollections.observableList(Data);
        DataStudent.setItems(dataStudent);
        DataStudent.setRowFactory((TableView<StudentTable> tv) -> {

            TableRow<StudentTable> row = new TableRow<>();
            row.setOnMouseClicked((MouseEvent event) -> {
                StudentTable rowData = row.getItem();
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    ID = rowData.getId();
                    Student_ID.setText(rowData.getId());
                    Student_Name.setText(rowData.getName());
                    Student_Dept.getSelectionModel().select(rowData.getDeptID());
                    Student_Cred.setText(rowData.getTot_cred() + "");
                    button.setText("Delete");
                } else {
                    ID = rowData.getId();
                    Student_ID.setText(rowData.getId());
                    Student_Name.setText(rowData.getName());
                    Student_Dept.getSelectionModel().select(rowData.getDeptID());
                    Student_Cred.setText(rowData.getTot_cred() + "");
                    button.setText("Update");
                }
            });
            return row;
        });
        SutdentID.setCellValueFactory(new PropertyValueFactory<>("id"));
        SutdentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        SutdentDeptName.setCellValueFactory(new PropertyValueFactory<>("DeptID"));
        SutdentTotCred.setCellValueFactory(new PropertyValueFactory<>("Tot_cred"));
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button.setText("Add");
                Student_ID.setText("");
                Student_Name.setText("");
                Student_Cred.setText("");
                Student_Dept.getSelectionModel().clearSelection();
                message.setText("");
                initialize(url, rb);
            }
        });
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
