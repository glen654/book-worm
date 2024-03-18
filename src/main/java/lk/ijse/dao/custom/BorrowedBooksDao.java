package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDao;
import lk.ijse.entity.BorrowedBooks;

import java.util.List;

public interface BorrowedBooksDao extends CrudDao<BorrowedBooks> {
    public List<BorrowedBooks> getBorrowedBooks(String userId);
}
