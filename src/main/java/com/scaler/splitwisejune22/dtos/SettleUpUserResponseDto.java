package com.scaler.splitwisejune22.dtos;

import com.scaler.splitwisejune22.services.settleup.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private List<Transaction> transactions;
}
