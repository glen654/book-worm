package lk.ijse.dao;

import lk.ijse.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> extends SuperDao {
    boolean save(T entity) throws SQLException;

    List<T> getAll();
}
