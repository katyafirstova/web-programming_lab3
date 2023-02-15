package dao;

import model.Coordinates;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConnectionUtils;


public class PointDAO implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(PointDAO.class);

    private static final String DB_USER = "db.user";
    private static final String DB_PASSWORD = "db.password";
    private static final String DB_URL = "db.url";

    private static PointDAO instance;

    private PointDAO() {
    }

    public static synchronized PointDAO getInstance() {
        if (instance == null) {
            instance = new PointDAO();
        }
        return instance;
    }


    public Connection getDBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                ConnectionUtils.get(DB_URL),
                ConnectionUtils.get(DB_USER),
                ConnectionUtils.get(DB_PASSWORD));
    }


    public void insert(Coordinates coordinates) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getDBConnection();
            ps = connection.prepareStatement("INSERT INTO result_table values (?, ?, ?, ?)");
            ps.setInt(1, coordinates.getX());
            ps.setDouble(2, coordinates.getY());
            ps.setDouble(3, coordinates.getR());
            ps.setBoolean(4, coordinates.isResult());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            logger.debug(e.getLocalizedMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.debug(e.getLocalizedMessage());
            }
        }
    }

    public List<Coordinates> getList() {
        List<Coordinates> coordinates = new ArrayList<>();
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = getDBConnection();
            st = connection.createStatement();
            rs = st.executeQuery("select * from result_table");
            while (rs.next()) {
                coordinates.add(mapCoordinates(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.debug(e.getLocalizedMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.debug(e.getLocalizedMessage());
            }
        }
        return coordinates;
    }

    private Coordinates mapCoordinates(ResultSet rs) throws SQLException {
        Coordinates c = new Coordinates();
        c.setX(rs.getInt("x"));
        c.setY(rs.getDouble("y"));
        c.setR(rs.getDouble("r"));
        c.setResult(rs.getBoolean("result"));
        return c;
    }


    public void clear() {
        Connection connection = null;
        Statement st = null;
        try {
            connection = getDBConnection();
            st = connection.createStatement();
            st.executeUpdate("delete from result_table");
            st.close();
        } catch (SQLException | ClassNotFoundException e) {
            logger.debug(e.getLocalizedMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.debug(e.getLocalizedMessage());
            }
        }
    }
}