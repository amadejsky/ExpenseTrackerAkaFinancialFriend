package com.madejsky.project.Services;


import com.madejsky.project.Exceptions.RecordNotFoundException;
import com.madejsky.project.Models.Expense;
import com.madejsky.project.Repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntityService {

    @Autowired
    EntityRepository repository;

    public Expense addExpense(Expense expense) {
        if (expense.getAmount() == null) {
            throw new IllegalArgumentException("[SERVICE ERROR] --Expense amount cannot be null!");
        }
        if (expense.getAmount() < 0) {
            throw new IllegalArgumentException("[SERVICE ERROR] --Expense amount cannot be negative!");
        }
        return repository.save(expense);
    }


    public List<Expense> getAll(){
        List<Expense> result = (List<Expense>) repository.findAll();
        if(result.size()>0)
        return result;
        else
            return new ArrayList<Expense>();
    }

    public void deleteExpenseById(Long id) throws RecordNotFoundException {
        Optional<Expense> expense = repository.findById(id);

        if(expense.isPresent())
            repository.deleteById(id);
        else
            throw new RecordNotFoundException("[SERVICE ERROR] No expense found");
    }
}
