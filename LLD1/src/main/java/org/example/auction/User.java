package org.example.auction;

abstract class User {
    protected int userId;
    protected String username;

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
}