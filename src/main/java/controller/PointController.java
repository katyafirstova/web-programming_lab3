package controller;


import dao.PointDAO;

import lombok.*;
import model.Coordinates;
import model.Table;
import utils.HitChecker;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.SQLException;

import java.util.*;

@ManagedBean(name = "pointController")
@ApplicationScoped
public class PointController implements Serializable {

    final private PointDAO pointDAO = new PointDAO();
    private final HitChecker hitChecker = new HitChecker();
    @Setter
    @Getter
    public final int[] possibleX = new int[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};

    @Setter
    @Getter
    private Coordinates coordinates = new Coordinates();

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

}


