package com.springboot.BankingApp.service.impl;

import com.springboot.BankingApp.dto.AccountDto;
import com.springboot.BankingApp.entity.Account;
import com.springboot.BankingApp.mapper.AccountMapper;
import com.springboot.BankingApp.repository.AccountRepository;
import com.springboot.BankingApp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService
{
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto)
    {
        Account account= AccountMapper.mapToAccount(accountDto);
       Account saveAccount= accountRepository.save(account);

        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id)
    {

        Account account=accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exists sorry"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount)
    {
        // check holder names exist in db
        Account account=accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exists sorry"));


        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount =accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withDraw(Long id, double amount)
    {
        // check holder names exist in db
        Account account=accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exists sorry"));
        if(account.getBalance()<amount)
        {
            throw  new RuntimeException("Insufficeient amount");
        }
        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account saveAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts()
    {
        List<Account> accounts=accountRepository.findAll();
      return  accounts.stream().map((account)->AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        // check holder names exist in db
        Account account=accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exists sorry"));
        accountRepository.deleteById(id);
    }
}
