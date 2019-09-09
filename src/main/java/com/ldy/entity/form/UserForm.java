package com.ldy.entity.form;

import java.io.Serializable;

public class UserForm implements Serializable {
    private static final long serialVersionUID = -1228997288483966431L;

    private String name;
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
