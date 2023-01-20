package model;

import javax.faces.bean.ApplicationScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.time.*;
import java.time.format.DateTimeFormatter;

@ManagedBean(name="clockBean")
@ApplicationScoped
    public class ClockBean implements Serializable {

        private OffsetDateTime odt = OffsetDateTime.now();

        public String getCurrentTime() {
            return odt.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
        public String getCurrentDate() {
            return odt.format(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy"));
        }
        public void setOffset(String offset) {
            odt = odt.withOffsetSameLocal(ZoneOffset.of(offset));
        }
        public String getOffset() {
            return odt.getOffset().getId();
        }
        public void updateTime() {
            odt = odt.plusSeconds(5);
        }
    }