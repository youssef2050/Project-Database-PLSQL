package project.database.plsql;

import Database.CourseDateAndControllerr;
import Database.StudentDateAndControllerr;
import Model.CourseTable;
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
public class CourseController implements Initializable {

    CourseDateAndControllerr coursedataandcontrollerr = new CourseDateAndControllerr();
    URL url;
    ResourceBundle rb;
    @FXML
    TextField Course_ID;
    @FXML
    TextField Course_Name;
    @FXML
    ComboBox Course_Dept;
    @FXML
    TextField Course_Cred;
    @FXML
    TableView<CourseTable> DataCourse;
    @FXML
    TableColumn<CourseTable, String> CourseID;
    @FXML
    TableColumn<CourseTable, String> CourseName;
    @FXML
    TableColumn<CourseTable, String> CourseDeptName;
    @FXML
    TableColumn<CourseTable, Double> CourseTotCred;
    ObservableList<CourseTable> dataCourse;
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
            if (!Course_Dept.getSelectionModel().isEmpty() && !Course_Cred.getText().isEmpty() && !Course_ID.getText().isEmpty() && !Course_Name.getText().isEmpty()) {
                coursedataandcontrollerr.InsertCourse(Course_ID.getText(),
                        Course_Name.getText(),
                        Course_Dept.getSelectionModel().getSelectedItem().toString(),
                        Double.parseDouble(Course_Cred.getText()));
                Course_ID.setText("");
                Course_Name.setText("");
                Course_Cred.setText("");
                Course_Dept.getSelectionModel().clearSelection();
            } else {
                message.setText("تأكد من جميع القيم مدخل بشكل صحيح ...");
            }
        } else if (button.getText().equals("Update")) {
            if (!Course_Dept.getSelectionModel().isEmpty() && !Course_Cred.getText().isEmpty() && !Course_ID.getText().isEmpty() && !Course_Name.getText().isEmpty()) {
                messageerror = coursedataandcontrollerr.UpdateCourse(ID, Course_ID.getText(), Course_Name.getText(),
                        Course_Dept.getSelectionModel().getSelectedItem().toString(),
                        Double.parseDouble(Course_Cred.getText()));
                button.setText("Add");
                Course_ID.setText("");
                Course_Name.setText("");
                Course_Cred.setText("");
                Course_Dept.getSelectionModel().clearSelection();
                message.setText(messageerror);
            } else {
                messageerror = coursedataandcontrollerr.UpdateCourse(null, null, null, null, 0);
                message.setText(messageerror);
            }

        } else if (button.getText().equals("Delete")) {
            if (!ID.equals("")) {
                messageerror = coursedataandcontrollerr.DeleteCourse(ID);
                button.setText("Add");
                Course_ID.setText("");
                Course_Name.setText("");
                Course_Cred.setText("");
                Course_Dept.getSelectionModel().clearSelection();
                message.setText(messageerror);
            } else {
                messageerror = coursedataandcontrollerr.DeleteCourse(null);
                message.setText(messageerror);
            }
        }
        initialize(url, rb);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.url = url;
        this.rb = rb;

        ObservableList<String> Course_Dept_data = FXCollections.observableList(new StudentDateAndControllerr().DateDepartment());//list
        Course_Dept.setItems(Course_Dept_data);
        //Table Data
        ArrayList<CourseTable> Data = (ArrayList<CourseTable>) coursedataandcontrollerr.DataCourse();
        search.textProperty().addListener((observable, oldText, newText) -> {

            ArrayList<CourseTable> searchData = new ArrayList<>();

            for (CourseTable st : Data) {
                if (st.getTitle().contains(newText) || st.getCourseID().contains(newText) || st.getDeptName().contains(newText) || (st.getCredits() + "").contains(newText)) {
                    searchData.add(st);
                } else {

                }
            }

            dataCourse = FXCollections.observableList(searchData);
            DataCourse.setItems(dataCourse);
        });

        dataCourse = FXCollections.observableList(Data);
        DataCourse.setItems(dataCourse);
        DataCourse.setRowFactory((TableView<CourseTable> tv) -> {

            TableRow<CourseTable> row = new TableRow<>();
            row.setOnMouseClicked((MouseEvent event) -> {
                CourseTable rowData = row.getItem();
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    ID = rowData.getCourseID();
                    Course_ID.setText(rowData.getCourseID());
                    Course_Name.setText(rowData.getTitle());
                    Course_Dept.getSelectionModel().select(rowData.getDeptName());
                    Course_Cred.setText(rowData.getCredits() + "");
                    button.setText("Delete");
                } else {
                    ID = rowData.getCourseID();
                    Course_ID.setText(rowData.getCourseID());
                    Course_Name.setText(rowData.getTitle());
                    Course_Dept.getSelectionModel().select(rowData.getDeptName());
                    Course_Cred.setText(rowData.getCredits() + "");
                    button.setText("Update");
                }
            });
            return row;
        });
        CourseID.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
        CourseName.setCellValueFactory(new PropertyValueFactory<>("Title"));
        CourseDeptName.setCellValueFactory(new PropertyValueFactory<>("DeptName"));
        CourseTotCred.setCellValueFactory(new PropertyValueFactory<>("Credits"));
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button.setText("Add");
                Course_ID.setText("");
                Course_Name.setText("");
                Course_Cred.setText("");
                Course_Dept.getSelectionModel().clearSelection();
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
