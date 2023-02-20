package controller;


import dao.PointDAO;

import lombok.*;
import model.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.HitChecker;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.io.Serializable;

import java.util.*;

@ManagedBean(name = "pointController")
@SessionScoped
public class PointController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(PointController.class);

    private final PointDAO pointDAO = PointDAO.getInstance();
    private final HitChecker hitChecker = new HitChecker();
    @Setter
    @Getter
    public final int[] possibleX = new int[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};

    @Setter
    @Getter
    private Coordinates coordinates;


    public PointController() {
        this.coordinates = new Coordinates();
        this.coordinates.setR(1.);
    }

    public void insertPoint() {
        coordinates.setResult(hitChecker.checkIfHit(coordinates));
        pointDAO.insert(coordinates);
        logger.info("PointController.insert coordinates: {}", coordinates);
    }

    public void insertClick() {
        try {
            Map<String, String> paramMap = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap();
            coordinates.setX(Double.parseDouble(paramMap.get("dot-form:valueX")));
            coordinates.setY(Double.parseDouble(paramMap.get("dot-form:valueY")));
            coordinates.setR(Double.parseDouble(paramMap.get("dot-form:valueR")));
            coordinates.setResult(hitChecker.checkIfHit(coordinates));
            pointDAO.insert(coordinates);
            logger.info("PointController.insert click: {}", coordinates);
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
        double r = this.coordinates.getR();
        double y = this.coordinates.getY();

        String e = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("plot-valueY");

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

