package net.ukr.tigor.daoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GoodsDAOImlp extends AbstractDAO {

    public GoodsDAOImlp(Connection conn, String table) {
        super(conn, table);
    }

    public void initBD() {
        try {

            try (Statement st = getConn().createStatement()) {
                //st.execute("DROP TABLE IF EXISTS " + getTable());
                st.execute("CREATE TABLE IF NOT EXISTS " + getTable() + " (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), cost DOUBLE)");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
