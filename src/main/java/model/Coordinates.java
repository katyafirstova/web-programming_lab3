package model;


import lombok.*;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@Data
public class Coordinates implements Serializable {
    private int x;
    private double y;
    private double r;
    private boolean result;
}
