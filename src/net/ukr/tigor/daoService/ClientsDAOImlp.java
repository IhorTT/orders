package net.ukr.tigor.daoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientsDAOImlp extends AbstractDAO {

    public ClientsDAOImlp(Connection conn, String table) {
        super(conn, table);
    }

    public void initBD() {
        try {

            try (Statement st = getConn().createStatement()) {
                //st.execute("DROP TABLE IF EXISTS " + getTable());
                st.execute("CREATE TABLE IF NOT EXISTS " + getTable() + " (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, fullName VARCHAR(100),phone VARCHAR(20))");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
