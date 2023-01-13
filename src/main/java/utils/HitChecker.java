package utils;


import model.Coordinates;

public class HitChecker {

    public boolean checkIfHit(Coordinates coordinates) {
        return (checkRectangle(coordinates.getX(), coordinates.getY(), coordinates.getR()) ||
                checkCircle(coordinates.getX(), coordinates.getY(), coordinates.getR()) ||
                checkTriangle(coordinates.getX(), coordinates.getY(), coordinates.getR()));

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











































