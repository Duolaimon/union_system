package org.duol.union.entity;

public class Committee {
    private String committeeId;

    private String committeePass;

    private String committeeName;

    public Committee(String committeeId, String committeePass, String committeeName) {
        this.committeeId = committeeId;
        this.committeePass = committeePass;
        this.committeeName = committeeName;
    }

    public Committee() {
        super();
    }

    public String getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(String committeeId) {
        this.committeeId = committeeId == null ? null : committeeId.trim();
    }

    public String getCommitteePass() {
        return committeePass;
    }

    public void setCommitteePass(String committeePass) {
        this.committeePass = committeePass == null ? null : committeePass.trim();
    }

    public String getCommitteeName() {
        return committeeName;
    }

    public void setCommitteeName(String committeeName) {
        this.committeeName = committeeName == null ? null : committeeName.trim();
    }
}