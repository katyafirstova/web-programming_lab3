package dao.interfaces;

import model.Table;

import java.sql.SQLException;
import java.util.Deque;


public interface HitInterface {
    Table insert(Table hit) throws SQLException, ClassNotFoundException;

    Deque<Table> getHits() throws SQLException, ClassNotFoundException;

    void clear() throws SQLException, ClassNotFoundException;

}