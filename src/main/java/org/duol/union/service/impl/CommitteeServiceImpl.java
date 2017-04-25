package org.duol.union.service.impl;

import org.duol.union.entity.Committee;
import org.duol.union.dao.CommitteeDao;
import org.duol.union.service.CommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author deity
 *         17-3-25 下午3:06
 */
@Service
public class CommitteeServiceImpl implements CommitteeService {
    private final CommitteeDao CommitteeDao;

    @Autowired
    public CommitteeServiceImpl(CommitteeDao CommitteeDao) {
        this.CommitteeDao = CommitteeDao;
    }

    @Override
    public List<Committee> getCommitteeList() {
        return CommitteeDao.queryCommitteeList();
    }

    @Override
    public Committee getCommitteeById(String CommitteeId) {
        return CommitteeDao.queryCommitteeById(CommitteeId);
    }

    @Override
    public void addCommittee(String CommitteeId) {
        CommitteeDao.insertCommittee(CommitteeId);
    }

    @Override
    public void deleteCommitteeById(String CommitteeId) {
        CommitteeDao.deleteCommitteeById(CommitteeId);
    }

    @Override
    public void updateCommitteePassword(String CommitteeId, String CommitteePass) {
        CommitteeDao.updateCommitteePassword(CommitteeId, CommitteePass);
    }

    @Override
    public void updateCommitteeName(String CommitteeId, String CommitteeName) {
        CommitteeDao.updateCommitteeName(CommitteeId, CommitteeName);
    }

    @Override
    public void updateCommittee(String CommitteeId, String CommitteePass, String CommitteeName) {
        CommitteeDao.updateCommittee(CommitteeId,CommitteePass,CommitteeName);
    }
}
