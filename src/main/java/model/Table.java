package model;

import lombok.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@ManagedBean(name = "table")
@SessionScoped
@AllArgsConstructor
public class Table implements Serializable {

    private int x;
    private double y;
    private int r;
    private boolean result;

  //  private String executionTime;
    public Table() {
    }
    public boolean getResult() {
        return result;
    }

}

