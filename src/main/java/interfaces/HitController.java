package interfaces;

import model.HitTable;

import java.sql.SQLException;
import java.util.List;

public abstract interface HitController {

    void insertHit(HitTable hit) throws SQLException;

    public abstract List<HitTable> getHits() throws SQLException;

    public abstract void clear();

}
