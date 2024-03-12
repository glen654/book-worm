package lk.ijse.dao.impl;

import lk.ijse.dao.custom.BorrowedBooksDao;
import lk.ijse.entity.BorrowedBooks;

import java.sql.SQLException;
import java.util.List;

public class BorrowedDaoImpl implements BorrowedBooksDao {
    @Override
    public boolean save(BorrowedBooks entity) throws SQLException {
        return false;
    }

    @Override
    public List<BorrowedBooks> getAll() {
        return null;
    }

    @Override
    public BorrowedBooks exists(String title) {
        return null;
    }

    @Override
    public boolean update(BorrowedBooks entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String title) throws SQLException {
        return false;
    }

    @Override
    public String getCount() {
        return null;
    }

    @Override
    public BorrowedBooks search(String title) {
        return null;
    }
}
