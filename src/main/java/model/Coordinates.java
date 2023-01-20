package model;


import lombok.*;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Coordinates implements Serializable {
    public Coordinates() {
    }

    private int x;
    private double y;
    private double r;
}
