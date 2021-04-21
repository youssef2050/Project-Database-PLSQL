/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.CouresStudentAndTakesTable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Youssef Ezz-Eldeen
 */
public class CouresStuedentAndTakesControllerr {

    Connection conn;

    public CouresStuedentAndTakesControllerr() {
        conn = DatabaseConn.conn(UsernameAndPassword.USERNAME, UsernameAndPassword.PASSWORD, null);
    }

    public List<CouresStudentAndTakesTable> getData() {
        List<CouresStudentAndTakesTable> data = new ArrayList<>();
        try {
            OracleCallableStatement ocs = (OracleCallableStatement) conn.prepareCall("{? = call PAG_Course_Takes_Student.Select_Course_Takes_Student}");
            ocs.registerOutParameter(1, OracleTypes.CURSOR);
            ocs.executeUpdate();
            OracleResultSet ors = (OracleResultSet) ocs.getCursor(1);
            while (ors.next()) {
                data.add(new CouresStudentAndTakesTable(ors.getString(1), ors.getString(2), ors.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
}
