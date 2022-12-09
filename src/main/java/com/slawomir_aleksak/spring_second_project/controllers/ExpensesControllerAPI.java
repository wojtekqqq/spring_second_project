package com.slawomir_aleksak.spring_second_project.controllers;

import com.slawomir_aleksak.spring_second_project.data.ExpensesRepository;
import com.slawomir_aleksak.spring_second_project.models.Expense;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses/api")
public class ExpensesControllerAPI {

    private ExpensesRepository expensesData;

    public ExpensesControllerAPI(ExpensesRepository repo) {
        super();
        expensesData = repo;
    }

    @GetMapping(value = "/list")
    public List<Expense> expenses() {
        List<Expense> allExpenses = expensesData.findAll();
        return allExpenses;
    }

    @PostMapping(value = "/save")
    public String save(Expense expense) {
        if (expense!=null) {
            expensesData.save(expense);
        }
        return ("redirect:/expenses/list");
    }

    @GetMapping(value = "/edit/{id}")
    public Expense editExpense(@PathVariable long id) {
        Optional<Expense> expense = expensesData.findById(id);

        if (expense!=null) {
            return expense.get();
        } else {
            return expenses().get(0);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean deleteExpense(@PathVariable long id) {
        Optional<Expense> expense = expensesData.findById(id);
        if (expense != null) {
            expensesData.delete(expense.get());
            return true;
        }
        return false;
    }


}














