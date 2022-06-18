package com.scaler.splitwisejune22.repositories;

import com.scaler.splitwisejune22.models.Expense;
import com.scaler.splitwisejune22.models.ExpenseOwingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseOwingUserRepository
extends JpaRepository<ExpenseOwingUser, Long> {
    List<ExpenseOwingUser> findAllByExpense(Expense expense);
}
