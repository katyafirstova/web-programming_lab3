package db;

import model.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.*;

public class DBHitUtils extends DBConnection {

    static final Logger LOG = LoggerFactory.getLogger(DBHitUtils.class);

    public boolean insertHits(Table table) throws SQLException {

        Connection connection = getDBConnection();
        Statement statement = connection.createStatement();
        try {
            statement.execute("insert into result_table (id, x, y, r, result, current_time_, execution_time) " + "values (" +
                    "'" + table.getId() + "', " +
                    "'" + (table.getX()) + "', " +
                    "'" + (table.getY()) + "', " +
                    "'" + (table.getR()) + "', " +
                    "'" + (table.getResult()) + "'," +
                    "timestamp '" + Timestamp.valueOf(table.getCurrentTime()) + "', " +
                    "'" + (table.getExecutionTime()) + "')");
            return true;
        } catch (SQLException e) {
            LOG.debug(e.getMessage());
            return false;
        }
    }


}



