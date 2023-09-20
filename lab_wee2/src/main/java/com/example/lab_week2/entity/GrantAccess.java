package com.example.lab_week2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_grant_access")
public class GrantAccess {
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;
    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountId;
    private IsGrant isGrant;
    private String note;

    public GrantAccess(Role roleId, Account accountId, IsGrant isGrant, String note) {
        this.roleId = roleId;
        this.accountId = accountId;
        this.isGrant = isGrant;
        this.note = note;
    }

    public GrantAccess() {
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public IsGrant getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(IsGrant isGrant) {
        this.isGrant = isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "roleId=" + roleId +
                ", accountId=" + accountId +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
