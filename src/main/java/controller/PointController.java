package controller;


import dao.PointDAO;

import lombok.*;
import model.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.HitChecker;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.io.Serializable;

import java.util.*;


public class PointController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(PointController.class);

    private final PointDAO pointDAO = PointDAO.getInstance();
    private final HitChecker hitChecker = new HitChecker();
    @Setter
    @Getter
    public final int[] possibleX = new int[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};


    public void insertPoint() {
        Map<String, String> paramMap = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        Coordinates c = new Coordinates();
        c.setX(Double.parseDouble(paramMap.get("form:x-coordinate")));
        c.setY(Double.parseDouble(paramMap.get("form:y-coordinate")));
        c.setR(Double.parseDouble(paramMap.get("form:r-coordinate")));
        c.setResult(hitChecker.checkIfHit(c));
        pointDAO.insert(c);
        logger.info("PointController.insert coordinates: {}", c);
    }

    public void insertClick() {
        try {
            Coordinates c = new Coordinates();
            Map<String, String> paramMap = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap();
            c.setX(Double.parseDouble(paramMap.get("dot-form:valueX")));
            c.setY(Double.parseDouble(paramMap.get("dot-form:valueY")));
            c.setR(Double.parseDouble(paramMap.get("dot-form:valueR")));
            c.setResult(hitChecker.checkIfHit(c));
            pointDAO.insert(c);
            logger.info("PointController.insert click: {}", c);
        } catch (Exception e) {
            logger.info("PointController.insert click ERROR {}", e.getLocalizedMessage());
        }
    }

    public List<Coordinates> getList() {
        logger.info("PointController.getList");
        return pointDAO.getList();
    }

    public void clear() {
        logger.info("PointController.clear()");
        pointDAO.clear();
    }

    public void validate()
    {

        Map<String, String> paramMap = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();

        double r = Double.parseDouble(paramMap.get("form:r-coordinate"));
        double y = Double.parseDouble(paramMap.get("form:y-coordinate"));

        if(r < 1. || r > 5.) {
            String msg = "Ожидается число от 1 до 5";
            FacesContext.getCurrentInstance().addMessage("table:r-coordinate",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        }
        if(y < -3. || r > 5.) {
            String msg = "Ожидается число от -3 до 5";
            FacesContext.getCurrentInstance().addMessage("table:y-coordinate",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        }
    }


}
