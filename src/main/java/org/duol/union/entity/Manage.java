package org.duol.union.entity;

/**
 * @author Duolaimon
 *         17-6-25 下午6:01
 */
public class Manage {
    private String manageId;

    private String managePass;

    public String getManageId() {
        return manageId;
    }

    public Manage(String manageId, String managePass) {
        this.manageId = manageId;
        this.managePass = managePass;
    }

    public void setManageId(String manageId) {
        this.manageId = manageId;
    }

    public String getManagePass() {
        return managePass;
    }

    public void setManagePass(String managePass) {
        this.managePass = managePass;
    }
}
