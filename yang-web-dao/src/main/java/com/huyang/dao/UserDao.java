package com.huyang.dao;

public class UserDao<T> {
    public T getUser() {
        return user;
    }

    public void setUser(T user) {
        this.user = user;
    }

    private T user;

    public UserDao(T user) {
        this.user = user;
    }


}
