package com.madejsky.project.Services;


import com.madejsky.project.Models.Expense;
import com.madejsky.project.Repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityService {

    @Autowired
    EntityRepository repository;

    public Expense addExpense(Expense expense){
        return repository.save(expense);
    }

    public List<Expense> getAll(){
        List<Expense> result = (List<Expense>) repository.findAll();
        if(result.size()>0)
        return result;
        else
            return new ArrayList<Expense>();
    }
}
