package model;


import lombok.*;

import java.io.Serializable;

@Data
public class Coordinates implements Serializable {
    private long id;
    private double x;
    private double y;
    private double r;
    private boolean result;
}
