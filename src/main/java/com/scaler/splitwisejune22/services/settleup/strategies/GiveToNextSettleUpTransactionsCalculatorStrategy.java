package com.scaler.splitwisejune22.services.settleup.strategies;

import com.scaler.splitwisejune22.controllers.UserController;
import com.scaler.splitwisejune22.models.Expense;
import com.scaler.splitwisejune22.models.ExpenseOwingUser;
import com.scaler.splitwisejune22.models.ExpensePayingUser;
import com.scaler.splitwisejune22.models.User;
import com.scaler.splitwisejune22.services.settleup.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Qualifier("giveToNextSettleUpStrategy")
public class GiveToNextSettleUpTransactionsCalculatorStrategy
    implements SettleUpTransactionsCalculatorStrategy {

    @Override
    public List<Transaction> getTransactions(List<ExpensePayingUser> expensePayingUsers,
                                             List<ExpenseOwingUser> expenseOwingUsers) {
        Map<User, Double> extraAmounts = new HashMap<>(); // User: Amount

        for (ExpensePayingUser expensePayingUser: expensePayingUsers) {
            if (!extraAmounts.containsKey(expensePayingUser.getUser())) {
                extraAmounts.put(expensePayingUser.getUser(), 0.);
            }

            extraAmounts.put(
                    expensePayingUser.getUser(),
                    extraAmounts.get(expensePayingUser.getUser()) + expensePayingUser.getAmount()
            );
        }

        for (ExpenseOwingUser expenseOwingUser: expenseOwingUsers) {
            if (!extraAmounts.containsKey(expenseOwingUser.getUser())) {
                extraAmounts.put(expenseOwingUser.getUser(), 0.);
            }

            extraAmounts.put(
                    expenseOwingUser.getUser(),
                    extraAmounts.get(expenseOwingUser.getUser()) - expenseOwingUser.getAmount()
            );
        }

        List<Map.Entry<User, Double>> entries = new ArrayList<>(extraAmounts.entrySet());

        List<Transaction> answer = new ArrayList<>();

        int n = entries.size();

        for (int i = 0; i < n - 1; ++i) {
            Transaction transaction = new Transaction();
            if (entries.get(i).getValue() < 0) { // have paid lesser
                transaction.setFrom(entries.get(i).getKey());
                transaction.setTo(entries.get(i + 1).getKey());
                transaction.setAmount(Math.abs(entries.get(i).getValue()));

                entries.get(i + 1).setValue(entries.get(i + 1).getValue() - Math.abs(entries.get(i).getValue()));
            } else if (entries.get(i).getValue() > 0) { // have paid extra
                transaction.setFrom(entries.get(i + 1).getKey());
                transaction.setTo(entries.get(i).getKey());
                transaction.setAmount(Math.abs(entries.get(i).getValue()));

                entries.get(i + 1).setValue(entries.get(i + 1).getValue() + Math.abs(entries.get(i).getValue()));
            }
        }

        return answer;
    }
}
