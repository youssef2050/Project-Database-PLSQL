/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.CourseTable;
import Model.StudentTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Youssef Ezz-Eldeen
 */
public class CourseDateAndControllerr {

    Connection conn;

    public CourseDateAndControllerr() {
        conn = Database.DatabaseConn.conn(UsernameAndPassword.USERNAME, UsernameAndPassword.PASSWORD, null);
    }

    public String InsertCourse(String CourseID, String Title, String DeptName, double Credits) {
        try {
            OracleCallableStatement cs = (OracleCallableStatement) conn.prepareCall("call PAG_Courses.insert_Course(?,?,?,?)");
            cs.setString(1, CourseID);
            cs.setString(2, Title);
            cs.setString(3, DeptName);
            cs.setDouble(4, Credits);
            cs.execute();
            return "تمت عملية الادخال بنجاح ";
        } catch (SQLException e) {

            return e.getMessage();
        }
    }

    public String UpdateCourse(String CourseIDOld, String CourseID, String Title, String DeptName, double Credits) {
        try {
            OracleCallableStatement cs = (OracleCallableStatement) conn.prepareCall("call PAG_Courses.Update_Course(?,?,?,?,?)");
            cs.setString(1, CourseIDOld);
            cs.setString(2, CourseID);
            cs.setString(3, Title);
            cs.setString(4, DeptName);
            cs.setDouble(5, Credits);
            cs.execute();
            return "تمت عملية التعديل بنجاح";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public String DeleteCourse(String CourseID) {
        try {
            OracleCallableStatement cs = (OracleCallableStatement) conn.prepareCall("call PAG_Courses.Delete_Course(?)");
            cs.setString(1, CourseID);
            cs.execute();
            return "تمت عملية الحذف بنجاح";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public List<CourseTable> DataCourse() {
        List<CourseTable> data = new ArrayList<>();
        try {
            OracleCallableStatement cs = (OracleCallableStatement) conn.prepareCall("call PAG_Courses.Select_Courses(?)");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet set = ((OracleCallableStatement) cs).getCursor(1);
            while (set.next()) {
                data.add(new CourseTable(set.getString(1), set.getString(2), set.getString(3), set.getDouble(4)));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return data;
    }
}
