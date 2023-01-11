package dao;

import dao.DBHitUtils;
import interfaces.HitInterface;
import model.PointBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.util.List;

@ManagedBean(name = "HitDAO", eager = true)
@ApplicationScoped
public class PointDAO implements HitInterface {

    @Override
    public void insert(PointBean hit) throws SQLException {
        DBHitUtils dbHitUtils = new DBHitUtils();
        dbHitUtils.insertHit(hit);

    }

    @Override
    public List<PointBean> getHits() throws SQLException {
        DBHitUtils dbHitUtils = new DBHitUtils();
        return dbHitUtils.getHits();

    }

    @Override
    public void clear() {
        DBHitUtils dbHitUtils = new DBHitUtils();
        dbHitUtils.clear();

    }
}