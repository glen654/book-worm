package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDao;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;

public interface BranchDao extends CrudDao<Branch> {
    Branch search(String Id);
}
