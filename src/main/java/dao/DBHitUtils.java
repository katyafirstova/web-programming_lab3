package dao;

import model.HitTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHitUtils extends DBConnection{

    static final Logger LOG = LoggerFactory.getLogger(DBHitUtils.class);

    Connection connection;

    public void insertHit(HitTable hit) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO result_table values (?, ?, ?, ?, ?, ?)");
        ps.setInt(1, hit.getX());
        ps.setDouble(2, hit.getY());
        ps.setInt(3, hit.getR());
        ps.setString(4, hit.getResult());
        ps.setDate(5, Date.valueOf(hit.getCurrentTime().toLocalDate()));
        ps.setDouble(6, hit.getExecutionTime());
        ps.executeUpdate();
        ps.close();
    }

    public List<HitTable> getHits() throws SQLException {
        List<HitTable> hits = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from result_table");
        while (rs.next()) {
            HitTable hitTable = getHitData(rs);
            hits.add(hitTable);
        }
        st.close();
        rs.close();
        return hits;
    }

    private HitTable getHitData(ResultSet rs) throws SQLException {
        HitTable hits = new HitTable();
        hits.setX(rs.getInt("x"));
        hits.setY(rs.getDouble("y"));
        hits.setR(rs.getInt("r"));
        hits.setResult(rs.getString("result"));
        hits.setCurrentTime(rs.getDate("currentTime").toLocalDate().atStartOfDay());
        hits.setExecutionTime(rs.getDouble("executionTime"));
        return hits;
    }

    public void clear() {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("delete from result_table");
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



