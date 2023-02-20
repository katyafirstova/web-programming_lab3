package utils;


import model.Coordinates;

import java.io.Serializable;

public class HitChecker implements Serializable {

    public boolean checkIfHit(Coordinates coordinates) {

        return (checkRectangle(coordinates.getX(), coordinates.getY(), coordinates.getR()) ||
                checkCircle(coordinates.getX(), coordinates.getY(), coordinates.getR()) ||
                checkTriangle(coordinates.getX(), coordinates.getY(), coordinates.getR()));


    }

    private boolean checkTriangle(double xVal, double yVal, double rVal) {
        return (rVal > 0 && xVal >= 0 && xVal <= rVal / 2
                && yVal <= 0 &&  yVal >= -rVal
                && yVal >= -rVal + 2*xVal);
    }

    private boolean checkCircle(double xVal, double yVal, double rVal) {
        return (xVal >= 0 && yVal >= 0 && (xVal * xVal + yVal * yVal) <= rVal * rVal);
    }

    private boolean checkRectangle(double xVal, double yVal, double rVal) {
        return (xVal <= 0 && yVal >= 0 && rVal > 0 && xVal >= -rVal && yVal <= rVal / 2);
    }

}










































