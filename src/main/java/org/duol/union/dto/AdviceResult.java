package org.duol.union.dto;

import org.duol.union.entity.Advice;
import org.duol.union.enums.AdviceStateEnum;

/**
 * @author deity
 *         17-3-25 下午5:04
 */
public class AdviceResult {
    private Advice advice;

    private int state;

    private String stateInfo;

    public AdviceResult(Advice advice,AdviceStateEnum adviceStateEnum) {
        this.advice = advice;
        this.state = adviceStateEnum.getState();
        this.stateInfo = adviceStateEnum.getStateInfo();
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
