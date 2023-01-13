package dao;

import interfaces.HitInterface;
import model.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "HitDAO", eager = true)
@ApplicationScoped
public class PointDAO implements HitInterface {

    static final Logger LOG = LoggerFactory.getLogger(PointDAO.class);
    private static final String DB_USER = "db.user";
    private static final String DB_PASSWORD = "db.password";
    private static final String DB_URL = "db.url";

    public Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(true);
            LOG.info("Соединение установлено");
        } catch (ClassNotFoundException e) {
            LOG.debug("Драйвер не найден");
        } catch (SQLException e) {
            LOG.debug(String.format("Ошибка при подключении к базе данных: %s", e.getMessage()));
        }
        return connection;
    }

    @Override
    public void insert(Table table) throws SQLException {
        Connection connection = getDBConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO result_table values (?, ?, ?, ?, ?, ?)");
        ps.setInt(1, table.getX());
        ps.setDouble(2, table.getY());
        ps.setInt(3, table.getR());
        ps.setBoolean(4, table.getResult());
        ps.setDate(5, Date.valueOf(table.getCurrentTime().toLocalDate()));
        ps.executeUpdate();
        ps.close();

    }

    @Override
    public List<Table> getHits() throws SQLException {
        Connection connection = getDBConnection();
        List<Table> hits = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from result_table");

        while (rs.next()) {
            Table hitTable = getHitData(rs);
            hits.add(hitTable);
        }
        st.close();
        rs.close();

        return hits;

    }


    private Table getHitData(ResultSet rs) throws SQLException {
        Table hits = new Table();
        hits.setX(rs.getInt("x"));
        hits.setY(rs.getDouble("y"));
        hits.setR(rs.getInt("r"));
        hits.setResult(rs.getBoolean("result"));
        hits.setCurrentTime(rs.getDate("currentTime").toLocalDate().atStartOfDay());
        //hits.setExecutionTime(rs.getString("executionTime"));
        return hits;
    }


    @Override
    public void clear() {
        Connection connection = getDBConnection();
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("delete from result_table");
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}