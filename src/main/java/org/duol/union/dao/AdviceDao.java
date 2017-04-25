package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Advice;

import java.util.List;

/**
 * @author deity
 *         17-3-25 下午1:48
 */
public interface AdviceDao {

    /**
     * 返回Advice所有数据
     * @return Advice列表
     */
    List<Advice> queryAdviceList();

    /**
     * 返回指定id的Advice
     * @param adviceId    Advice id号
     * @return      Advice
     */
    Advice queryAdviceById(@Param("adviceId") Integer adviceId);

    /**
     * 删除指定id的Advice
     * @param adviceId    Advice id号
     */
    void deleteAdviceById(@Param("adviceId") Integer adviceId);

}
