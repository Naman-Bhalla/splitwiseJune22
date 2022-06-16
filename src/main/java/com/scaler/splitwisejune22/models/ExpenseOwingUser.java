package com.scaler.splitwisejune22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class ExpenseOwingUser extends BaseModel {
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User user;
    private double amount;
}
