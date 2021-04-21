/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.TakesTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Youssef Ezz-Eldeen
 */
public class TakesControllerrr {

    Connection conn;

    public TakesControllerrr() {
        conn = Database.DatabaseConn.conn(UsernameAndPassword.USERNAME, UsernameAndPassword.PASSWORD, null);
    }

    public List<TakesTable> getData() {
        List<TakesTable> data = new ArrayList<>();
        //{? = CALL balance(?)}
        try {
            OracleCallableStatement ocs = (OracleCallableStatement) conn.prepareCall("{? = call PAG_Takes.Select_Takes}");
            ocs.registerOutParameter(1, OracleTypes.CURSOR);
            ocs.executeUpdate();
            ResultSet ors = ((OracleCallableStatement) ocs).getCursor(1);
            while (ors.next()) {
                data.add(new TakesTable(ors.getString(1), ors.getString(2), ors.getString(3),
                        ors.getString(4), ors.getString(5), ors.getString(6)));
            }
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
}
