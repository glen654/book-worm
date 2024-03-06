package lk.ijse.dao;

import lk.ijse.entity.Admin;
import lk.ijse.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> extends SuperDao {
    boolean save(T entity) throws SQLException;
    List<T> getAll();
    Book exists(String title);
    boolean update(T entity) throws SQLException;
}
