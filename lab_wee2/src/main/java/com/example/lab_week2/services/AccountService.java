package com.example.lab_week2.services;

import com.example.lab_week2.entity.Account;
import com.example.lab_week2.entity.Role;
import com.example.lab_week2.repositoty.AccountRepository;

import java.util.List;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService() {
        accountRepository = new AccountRepository();
    }
    public void insert(Account account){
        accountRepository.insert(account);
    }
    public Account findOne(String id){
        return accountRepository.findOne(id);
    }
    public List<Account> fillAll(){
        return accountRepository.fillAll();
    }
    public List<Role> getRoleByAccount(String id){
        return accountRepository.getRoleByAccount(id);
    }

}
