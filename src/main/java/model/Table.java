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
    private int r;
    private boolean result;
    private LocalDateTime currentTime;
  //  private String executionTime;
    public Table() {
    }

    public boolean getResult() {
        return result;
    }
}

