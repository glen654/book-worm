package lk.ijse.bo.impl;

import lk.ijse.bo.custom.BranchBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.custom.BranchDao;
import lk.ijse.dto.BranchDto;
import lk.ijse.entity.Branch;

import java.sql.SQLException;

public class BranchBoImpl implements BranchBo {
    BranchDao branchDao = (BranchDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.BRANCH);
    @Override
    public boolean saveBranch(BranchDto dto) throws SQLException {
        return branchDao.save(new Branch(dto.getbId(), dto.getAddress(), dto.getbNumber(), dto.getStatus(), dto.getAdminId()));
    }
}
