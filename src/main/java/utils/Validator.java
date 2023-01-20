package utils;

import model.Coordinates;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Validator implements Serializable {
    public Validator() {
    }

    public Boolean validate(Coordinates coordinates) {

        int x = coordinates.getX();
        double y = coordinates.getY();
        double r = coordinates.getR();

        List<Integer> xList = Arrays.asList(-3, -2, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> rList = Arrays.asList(1, 2, 3, 4, 5);

        return (xList.contains(x) && (y > -3 && y < 5) && rList.contains(r));

    }

}

