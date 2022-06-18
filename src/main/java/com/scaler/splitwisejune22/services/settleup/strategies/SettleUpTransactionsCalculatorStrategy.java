package com.scaler.splitwisejune22.services.settleup.strategies;

import com.scaler.splitwisejune22.models.ExpenseOwingUser;
import com.scaler.splitwisejune22.models.ExpensePayingUser;
import com.scaler.splitwisejune22.services.settleup.Transaction;

import java.util.List;

public interface SettleUpTransactionsCalculatorStrategy {

    List<Transaction> getTransactions(List<ExpensePayingUser> expensePayingUsers,
                                      List<ExpenseOwingUser> expenseOwingUsers);
}
