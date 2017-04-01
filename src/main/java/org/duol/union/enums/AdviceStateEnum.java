package org.duol.union.enums;

/**
 * @author deity
 *         17-3-25 下午4:53
 */
public enum AdviceStateEnum {
    WAIT_CHECK(0,"待审核"),
    PASS_CHECK(1,"审核通过"),
    NOT_PASS_CHECK(-1,"审核未通过");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public String getStateInfo(int state) {
        return stateInfo;
    }

    AdviceStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
}
