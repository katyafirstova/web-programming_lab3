package controller;


import dao.PointDAO;
import model.PointBean;

import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "pointController")
public class PointController {
    private PointDAO pointDAO;
    private PointBean point;

    public void insertPoint() throws SQLException {
        pointDAO.insert(point);
    }

    public List<PointBean> getPoints() throws SQLException {
        return pointDAO.getHits();
    }

    public void clearPoints() {
        pointDAO.clear();
    }

}
