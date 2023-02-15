package controller;


import dao.PointDAO;

import lombok.*;
import model.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.HitChecker;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.sql.SQLException;

import java.util.*;

@ManagedBean(name = "pointController")
@ApplicationScoped
public class PointController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(PointController.class);

    final private PointDAO pointDAO = PointDAO.getInstance();
    private final HitChecker hitChecker = new HitChecker();
    @Setter
    @Getter
    public final int[] possibleX = new int[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};

    @Setter
    @Getter
    private Coordinates coordinates = new Coordinates();

    public void insertPoint() throws SQLException, ClassNotFoundException {
        coordinates.setResult(hitChecker.checkIfHit(coordinates));
        pointDAO.insert(coordinates);
        logger.info("PointController.insert coordinates: {}", coordinates);
    }

    public List<Coordinates> getList() {
        logger.info("PointController.getList");
        return pointDAO.getList();
    }

    public void clear() {
        logger.info("PointController.clear");
        pointDAO.clear();
    }

}

