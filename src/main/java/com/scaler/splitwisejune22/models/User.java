package com.scaler.splitwisejune22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseModel {
    private String username;
    private String hashedPassword;
    private String phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
