package controller;


import dao.PointDAO;
import lombok.Getter;
import lombok.Setter;
import model.Coordinates;
import model.Table;
import utils.HitChecker;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;

import java.util.*;

@ManagedBean(name = "pointController", eager = true)
@SessionScoped
public class PointController implements Serializable {

    final private PointDAO pointDAO = new PointDAO();
    private final HitChecker hitChecker = new HitChecker();
    @Setter
    @Getter
    public final int[] possibleX = new int[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};

    @Setter
    @Getter
    private Coordinates coordinates = new Coordinates(0, 0.0, 1);

    private Table table;

    public void insertPoint() throws SQLException, ClassNotFoundException {
        if (Objects.isNull(pointDAO.getDBConnection()))
            return;

        Table result = new Table(
                coordinates.getX(),
                coordinates.getY(),
                coordinates.getR(),
                hitChecker.checkIfHit(coordinates));

        pointDAO.insert(result);

    }

    public Object[] getHits() throws SQLException, ClassNotFoundException {
        if (Objects.isNull(pointDAO.getDBConnection()))
            return new LinkedList[]{new LinkedList<>()};

        return pointDAO.getHits().toArray();

    }

    public void clear() throws SQLException, ClassNotFoundException {
        if (Objects.isNull(pointDAO.getDBConnection()))
            return;

        pointDAO.clear();

    }

    public void updateRadius(Integer newR) {
        coordinates.setR(newR);
    }
}



