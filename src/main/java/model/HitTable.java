package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@ManagedBean(name="table")
@SessionScoped
public class HitTable {
    private String id;
    private int x;
    private double y;
    private int r;
    private String result;
    private LocalDateTime currentTime;
    private Double executionTime;
    private boolean clickedOnGraph;
    public HitTable() {}

}

