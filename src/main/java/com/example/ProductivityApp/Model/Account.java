package com.example.ProductivityApp.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @Column(name = "user_name", nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "point_count")
    private Integer pointCount;
    @Column(name = "add_to_group", nullable = false)
    private Boolean addToGroup;

    public Account(long accountId, String username, String email, String password, int pointCount, boolean addToGroup) {
        this.accountId = accountId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.pointCount = pointCount;
        this.addToGroup = addToGroup;
    }

    public Account() {
    }

    public long getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPointCount() {
        return pointCount;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public boolean isAddToGroup() {
        return addToGroup;
    }

    public void setAddToGroup(boolean addToGroup) {
        this.addToGroup = addToGroup;
    }

}
