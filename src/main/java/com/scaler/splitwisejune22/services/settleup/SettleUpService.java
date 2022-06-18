package com.scaler.splitwisejune22.services.settleup;

import com.scaler.splitwisejune22.models.*;
import com.scaler.splitwisejune22.repositories.ExpenseOwingUserRepository;
import com.scaler.splitwisejune22.repositories.ExpensePayingUserRepository;
import com.scaler.splitwisejune22.repositories.GroupRepository;
import com.scaler.splitwisejune22.services.settleup.strategies.SettleUpTransactionsCalculatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {
    private SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy;
    private GroupRepository groupRepository;
    private ExpenseOwingUserRepository expenseOwingUserRepository;
    private ExpensePayingUserRepository expensePayingUserRepository;

    @Autowired
    public SettleUpService(SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy) {
        this.settleUpTransactionsCalculatorStrategy = settleUpTransactionsCalculatorStrategy;
    }

    public List<Transaction> settleUpUser(Long userId) {
        return null;
    }

    public List<Transaction> settleUpGroup(Long groupId) {

        // Algo:
        // settleUp(group_id) {
        //    1. Get all epu and eou for the group
        //    2. Do calculation to compute the transaction
        // }

        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (!groupOptional.isPresent()) {
            // throw some exception
            System.out.println("No group with that id");
        }

        Group group = groupOptional.get();

        List<ExpensePayingUser> expensePayingUsers = new ArrayList<>();
        List<ExpenseOwingUser> expenseOwingUsers = new ArrayList<>();

        for (Expense expense: group.getExpenses()) {
            expensePayingUsers.addAll(expensePayingUserRepository.findAllByExpense(expense));
            expenseOwingUsers.addAll(expenseOwingUserRepository.findAllByExpense(expense));
        }
        return settleUpTransactionsCalculatorStrategy.getTransactions(
                expensePayingUsers,
                expenseOwingUsers
        );
    }
}

//  search([AccountID]) -> List<Data>
// HDFC /search?ac_ids=[123, 456]
//  /search?ac_ids=[123, 491]&sec_token=""
//  /groups?user=123
//  /users

