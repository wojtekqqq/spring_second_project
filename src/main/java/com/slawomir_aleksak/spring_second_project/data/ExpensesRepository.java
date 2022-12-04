package com.slawomir_aleksak.spring_second_project.data;

import com.slawomir_aleksak.spring_second_project.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpensesRepository extends JpaRepository<Expense, Long> {
    
}