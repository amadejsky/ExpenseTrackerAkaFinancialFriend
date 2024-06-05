package com.madejsky.project.Repository;

import com.madejsky.project.Models.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntityRepository extends CrudRepository<Expense,Long> {
}
