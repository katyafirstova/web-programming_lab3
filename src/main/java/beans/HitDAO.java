package beans;

import interfaces.HitController;
import model.HitTable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "HitDAO", eager = true)
@ApplicationScoped
public class HitDAO implements HitController {
    Connection connection;


    @Override
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

    @Override
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

    @Override
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

