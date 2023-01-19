package dao;

import model.Table;
import java.io.Serializable;
import java.sql.*;
import java.util.Deque;
import java.util.LinkedList;

import dao.interfaces.HitInterface;
import utils.ConnectionUtils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="dao")
@ApplicationScoped
public class PointDAO implements HitInterface, Serializable {

    private static final String DB_USER = "db.user";
    private static final String DB_PASSWORD = "db.password";
    private static final String DB_URL = "db.url";

    public Connection getDBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                ConnectionUtils.get(DB_URL),
                ConnectionUtils.get(DB_USER),
                ConnectionUtils.get(DB_PASSWORD));
    }


    @Override
    public Table insert(Table table) throws SQLException, ClassNotFoundException {
        Connection connection = getDBConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO result_table values (?, ?, ?, ?)");
            ps.setInt(1, table.getX());
            ps.setDouble(2, table.getY());
            ps.setInt(3, table.getR());
            ps.setBoolean(4, table.getResult());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return table;
    }

    @Override
    public Deque<Table> getHits() throws SQLException, ClassNotFoundException {
        Deque<Table> hits = new LinkedList<>();
        Connection connection = getDBConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select * from result_table");
            while (rs.next()) {
                Table hitTable = getHitData(rs);
                hits.push(hitTable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return hits;
    }


    private Table getHitData(ResultSet rs) throws SQLException, ClassNotFoundException {
        Table hits = new Table();
        hits.setX(rs.getInt("x"));
        hits.setY(rs.getDouble("y"));
        hits.setR(rs.getInt("r"));
        hits.setResult(rs.getBoolean("result"));
        return hits;

    }


    @Override
    public void clear() throws SQLException, ClassNotFoundException {
        Connection connection = getDBConnection();
        Statement st = null;
        try {
            st = connection.createStatement();
            st.executeUpdate("delete from result_table");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
