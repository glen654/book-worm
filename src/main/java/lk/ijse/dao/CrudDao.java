package lk.ijse.dao;

import lk.ijse.entity.Admin;

import java.sql.SQLException;

public interface CrudDao<T> extends SuperDao {
    boolean save(T entity) throws SQLException;

}
