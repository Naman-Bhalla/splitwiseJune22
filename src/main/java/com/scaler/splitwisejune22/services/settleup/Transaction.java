package com.scaler.splitwisejune22.services.settleup;

import com.scaler.splitwisejune22.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private double amount;
}
