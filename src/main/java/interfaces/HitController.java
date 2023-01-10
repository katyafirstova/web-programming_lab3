package interfaces;

import model.HitTable;

import java.sql.SQLException;
import java.util.List;

public interface HitController {

    void insert(HitTable hit) throws SQLException;

    List<HitTable> getHits() throws SQLException;

    void clear();

}
