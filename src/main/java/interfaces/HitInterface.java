package interfaces;

import model.PointBean;

import java.sql.SQLException;
import java.util.List;



public interface HitInterface {
    void insert(PointBean hit) throws SQLException;

    List<PointBean> getHits() throws SQLException;

    void clear();

}