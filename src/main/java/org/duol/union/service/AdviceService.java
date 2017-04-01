package org.duol.union.service;

import org.duol.union.entity.Advice;

import java.util.List;

/**
 * @author deity
 *         17-3-25 下午2:34
 */
public interface AdviceService {
    /**
     * 返回Advice所有数据
     *
     * @return Advice列表
     */
    List<Advice> getAdviceList();

    /**
     * 返回指定id的Advice
     *
     * @param id Advice id号
     * @return Advice
     */
    Advice getById(Integer id);

    /**
     * 删除指定id的Advice
     *
     * @param id Advice id号
     */
    void deleteById(Integer id);
}
