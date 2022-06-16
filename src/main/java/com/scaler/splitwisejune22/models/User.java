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
}
