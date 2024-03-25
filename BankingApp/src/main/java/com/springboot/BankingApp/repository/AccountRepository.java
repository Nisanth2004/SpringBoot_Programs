package com.springboot.BankingApp.repository;

import com.springboot.BankingApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long>
{

}
