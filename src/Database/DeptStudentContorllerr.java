/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.DeptStudentTable;
import Model.TakesTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Youssef Ezz-Eldeen
 */
public class DeptStudentContorllerr {

    Connection conn;

    public DeptStudentContorllerr() {
        conn = Database.DatabaseConn.conn(UsernameAndPassword.USERNAME, UsernameAndPassword.PASSWORD, null);
    }

    public List<DeptStudentTable> getDataTable() {
        List<DeptStudentTable> data = new ArrayList<>();
        try {
            OracleCallableStatement ocs = (OracleCallableStatement) conn.prepareCall("{? = call PAG_Dept_Student.Select_Dept_Student}");
            ocs.registerOutParameter(1, OracleTypes.CURSOR);
            ocs.executeUpdate();
            ResultSet ors = ((OracleCallableStatement) ocs).getCursor(1);
            while (ors.next()) {
                data.add(new DeptStudentTable(ors.getInt(1), ors.getString(2)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public ObservableList<PieChart.Data> getDataChart() {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        List<DeptStudentTable> data1 = getDataTable();
        for (DeptStudentTable deptStudentTable : data1) {
            data.add(new PieChart.Data(deptStudentTable.getNameDepartment(), deptStudentTable.getNumberStudent()));
        }
        return data;
    }
}
