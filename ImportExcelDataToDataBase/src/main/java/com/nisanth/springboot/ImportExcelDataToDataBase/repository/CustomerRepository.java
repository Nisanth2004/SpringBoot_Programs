package com.nisanth.springboot.ImportExcelDataToDataBase.repository;

import com.nisanth.springboot.ImportExcelDataToDataBase.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{

}


