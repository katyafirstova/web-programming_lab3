package dao.interfaces;

import model.Table;

import java.sql.SQLException;
import java.util.List;



public interface HitInterface {
    void insert(Table hit) throws SQLException;

    List<Table> getHits() throws SQLException;

    void clear();

}