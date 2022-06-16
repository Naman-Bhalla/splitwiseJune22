package com.scaler.splitwisejune22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    private double amount;
    @ManyToOne
    private User createdBy;
    private String description;
    private Date createdAt;
    @ManyToOne
    private Currency baseCurrency;
    @ManyToMany
    private List<User> participants;
}
