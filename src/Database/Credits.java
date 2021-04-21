package Database;

import Model.CreditsTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class Credits {

    Connection conn;

    public Credits() {
        conn = DatabaseConn.conn(UsernameAndPassword.USERNAME, UsernameAndPassword.PASSWORD, null);
    }

    public List<CreditsTable> DataCridet() {
        List<CreditsTable> data = new ArrayList<>();
        try {
            OracleCallableStatement ocs = (OracleCallableStatement) conn.prepareCall("call PAG_Course_Credit.Select_Course_Credit(?)");
            ocs.registerOutParameter(1, OracleTypes.CURSOR);
            ocs.execute();
            ResultSet ors = ((OracleCallableStatement) ocs).getCursor(1);
            if (ors.getMetaData().getColumnCount() == 2) {
                while (ors.next()) {
                    data.add(new CreditsTable(ors.getString(1), ors.getString(2)));
                }
            } else {
                while (ors.next()) {
                    data.add(new CreditsTable(ors.getString(3), ors.getString(2), ors.getString(1)));
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;

    }
}
