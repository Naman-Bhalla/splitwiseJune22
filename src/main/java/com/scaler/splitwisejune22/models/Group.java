package com.scaler.splitwisejune22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends BaseModel {
    private String name;
    @ManyToMany
    private List<User> participants;
    @ManyToMany
    private List<User> admins;
    private String description;
    @ManyToOne
    private User createdBy;
    @OneToMany
    private List<Expense> expenses;
}
