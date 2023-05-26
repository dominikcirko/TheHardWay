package com.example.ProductivityApp.Service.Interface;

import com.example.ProductivityApp.Model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

   Account createAccount(Account account);

   void deleteAccount(Long id);

   Optional<Account> findAccountById(Long id);

   List<Account> getAllAccounts();

}
