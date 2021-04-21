package Database;

import Model.StudentTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class StudentDateAndControllerr {

    Connection conn;

    public StudentDateAndControllerr() {
        conn = Database.DatabaseConn.conn(UsernameAndPassword.USERNAME, UsernameAndPassword.PASSWORD, null);
    }

    public List DateDepartment() {
        List<String> data = new ArrayList<>();
        try {
            OracleCallableStatement ocs = (OracleCallableStatement) conn.prepareCall("call PAG_Global.Select_Departments(?)");
            ocs.registerOutParameter(1, OracleTypes.CURSOR);
            ocs.execute();
            ResultSet ors = ((OracleCallableStatement) ocs).getCursor(1);
            while (ors.next()) {
                data.add(ors.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDateAndControllerr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
//        data.add(new StudentTable(ors.getString("ID"), ors.getString("NAME"), ors.getString("DEPT_NAME"), ors.getDouble("TOT_CRED")));

    public List<StudentTable> DataStudent() {
        List<StudentTable> data = new ArrayList<>();
        try {
            OracleCallableStatement cs = (OracleCallableStatement) conn.prepareCall("call PAG_Students.Select_Students(?)");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet set = ((OracleCallableStatement) cs).getCursor(1);
            while (set.next()) {
                data.add(new StudentTable(set.getString("ID"), set.getString("NAME"), set.getString("DEPT_NAME"), set.getDouble("TOT_CRED")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return data;
    }
    //insert into student values(00126,'youssef','Biology',0);

    public String InsertStudent(String ID, String name, String Dept, double crid) {
        try {
            OracleCallableStatement cs = (OracleCallableStatement) conn.prepareCall("call PAG_Students.insert_Student(?,?,?,?)");
            cs.setString(1, ID);
            cs.setString(2, name);
            cs.setString(3, Dept);
            cs.setDouble(4, crid);
            cs.execute();
            return "تمت عملية الادخال بنجاح ";
        } catch (SQLException e) {

            return e.getMessage();
        }

    }

    public String DeleteStudent(String ID) {
        try {
            OracleCallableStatement cs = (OracleCallableStatement) conn.prepareCall("call PAG_Students.Delete_Student(?)");
            cs.setString(1, ID);
            cs.execute();
            return "تمت عملية الحذف بنجاح";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public String UpdateStudent(String IDold, String ID, String name, String Dept, double crid) {
        try {
            OracleCallableStatement cs = (OracleCallableStatement) conn.prepareCall("call PAG_Students.Update_Student(?,?,?,?,?)");
            cs.setString(1, IDold);
            cs.setString(2, ID);
            cs.setString(3, name);
            cs.setString(4, Dept);
            cs.setDouble(5, crid);
            cs.execute();
            return "تمت عملية التعديل بنجاح";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
