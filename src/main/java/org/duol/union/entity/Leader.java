package org.duol.union.entity;

public class Leader {
    private Integer leaderId;

    private String leaderPassword;

    private String leaderName;

    public Leader(Integer leaderId, String leaderPassword, String leaderName) {
        this.leaderId = leaderId;
        this.leaderPassword = leaderPassword;
        this.leaderName = leaderName;
    }

    public Leader() {
        super();
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderPassword() {
        return leaderPassword;
    }

    public void setLeaderPassword(String leaderPassword) {
        this.leaderPassword = leaderPassword == null ? null : leaderPassword.trim();
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName == null ? null : leaderName.trim();
    }
}