package lk.ijse.dao;

import java.sql.SQLException;

public interface CrudDao<T> extends SuperDao {
    boolean save(T entity) throws SQLException;
}
