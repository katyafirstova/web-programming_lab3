package utils;

import model.Coordinates;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public Boolean validate(Coordinates coordinates) {
        int x = coordinates.getX();
        double y = coordinates.getY();
        int r = coordinates.getR();

        List<Integer> xList = Arrays.asList(-3, -2, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> rList = Arrays.asList(1, 2, 3, 4, 5);

        return (xList.contains(x) && (y > -3 && y < 5) && rList.contains(r));

    }

}

