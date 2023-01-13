package controller;


import dao.PointDAO;
import lombok.Getter;
import lombok.Setter;
import model.Coordinates;
import model.Table;
import utils.HitChecker;

import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ManagedBean(name = "pointController")
public class PointController {
    private PointDAO pointDAO;
    private final HitChecker hitChecker = new HitChecker();

    @Setter
    @Getter
    private Coordinates coordinates = new Coordinates(0, 0, 1);


    public void insertPoint() throws SQLException {
        if (Objects.isNull(pointDAO.getDBConnection()))
            return;

        Table result = new Table(
                coordinates.getX(),
                coordinates.getY(),
                coordinates.getR(),
                hitChecker.checkIfHit(coordinates),
                LocalDateTime.now());

        pointDAO.insert(result);

    }

    public List<Table> getHits() throws SQLException {
        if (Objects.isNull(pointDAO.getDBConnection()))
            return new ArrayList<>();

        return pointDAO.getHits();

    }

    public void clear() {
        if (Objects.isNull(pointDAO.getDBConnection()))
            return;

        pointDAO.clear();

    }

    public void updateRadius(Integer newR) {
        coordinates.setR(newR);
    }






}
