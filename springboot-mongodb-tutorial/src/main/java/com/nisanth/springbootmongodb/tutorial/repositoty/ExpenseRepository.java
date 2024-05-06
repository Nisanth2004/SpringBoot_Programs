package com.nisanth.springbootmongodb.tutorial.repositoty;

import com.nisanth.springbootmongodb.tutorial.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense,String> {
    @Query("{'name':?0}" ) // get the first parameter
   Optional<Expense> findByName(String name);
}
