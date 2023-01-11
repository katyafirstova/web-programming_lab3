package utils;

import model.PointBean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Arrays;
import java.util.List;



public class HitChecker {


    PointBean pointBean = new PointBean();

    public boolean checkArea(int x, double y, int r) {
        if (checkIfValid(x, y, r)) {
            return checkIfHit(x, y, r);
        }
        return false;
    }

    private boolean checkX(int xVal) {
        try {
            List<Integer> list = Arrays.asList(-3, -2, -1, 0, 1, 2, 3, 4, 5);
            return (list.contains(xVal));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean checkY(double yVal) {
        try {
            return (yVal > -3 && yVal < 5);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean checkR(int rVal) {
        try {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
            return (list.contains(rVal));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean checkIfValid(int xVal, double yVal, int rVal) {
        return (checkX(xVal) & checkY(yVal) & checkR(rVal));
    }

    private boolean checkIfHit(int xVal, double yVal, int rVal) {
        return (checkRectangle(xVal, yVal, rVal) ||
                checkCircle(xVal, yVal, rVal) || checkTriangle(xVal, yVal, rVal));

    }

    private boolean checkTriangle(int xVal, double yVal, int rVal) {
        return (xVal >= 0 && yVal <= 0 && (rVal * rVal) <= (xVal * xVal + yVal * yVal));
    }

    private boolean checkCircle(int xVal, double yVal, int rVal) {
        return (xVal >= 0 && yVal >= 0 && (xVal * xVal + yVal * yVal) <= rVal * rVal);
    }

    private boolean checkRectangle(int xVal, double yVal, int rVal) {
        return (xVal <= 0 && yVal >= 0 && rVal <= 0 && xVal <= rVal / 2);
    }

}











































