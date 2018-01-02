package org.duol.union.entity;

public class Team {
    private Integer teamId;

    private String teamPass;

    private String teamName;

    public Team(Integer teamId, String teamPass, String teamName) {
        this.teamId = teamId;
        this.teamPass = teamPass;
        this.teamName = teamName;
    }

    public Team() {
        super();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamPass() {
        return teamPass;
    }

    public void setTeamPass(String teamPass) {
        this.teamPass = teamPass == null ? null : teamPass.trim();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }
}