package model;

import javax.faces.bean.ViewScoped;
import java.text.SimpleDateFormat;
import java.util.Date;

@ViewScoped
public class ClockBean{
    private SimpleDateFormat simpleDateFormat;
    private Date date;

    public ClockBean(SimpleDateFormat simpleDateFormat, Date date) {
        this.simpleDateFormat = simpleDateFormat;
        this.date = date;
    }

    public String getCurrentDate() {
        return simpleDateFormat.format(date);
    }

    public void updateDate() {
        date = new Date();
    }
}