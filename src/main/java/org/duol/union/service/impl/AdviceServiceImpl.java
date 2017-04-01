package org.duol.union.service.impl;

import org.duol.union.entity.Advice;
import org.duol.union.dao.AdviceDao;
import org.duol.union.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author deity
 *         17-3-25 下午2:34
 */
@Service
public class AdviceServiceImpl implements AdviceService {
    private final AdviceDao adviceDao;

    @Autowired
    public AdviceServiceImpl(AdviceDao adviceDao) {
        this.adviceDao = adviceDao;
    }

    @Override
    public List<Advice> getAdviceList() {
        return adviceDao.queryAdviceList();
    }

    @Override
    public Advice getById(Integer id) {
        return adviceDao.queryAdviceById(id);
    }

    @Override
    public void deleteById(Integer id) {
        adviceDao.deleteAdviceById(id);
    }
}
