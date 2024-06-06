package com.madejsky.project.Services;


import com.madejsky.project.Models.Expense;
import com.madejsky.project.Repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityService {

    @Autowired
    EntityRepository repository;

    public Expense addExpense(Expense expense){
        return repository.save(expense);
    }
}
