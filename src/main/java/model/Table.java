package model;

import lombok.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@ManagedBean(name = "table")
@SessionScoped
@AllArgsConstructor
public class Table {
    private int x;
    private double y;
    private double r;
    private boolean result;

    public Table() {
    }

    public boolean getResult() {
        return result;
    }
}

