package com.example.ProductivityApp.Service.Interface;

import com.example.ProductivityApp.Model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Optional<Account> createAccount(Account account);

    void deleteAccount(Long id);

    Optional<Account> findAccountByUsername(String username);

    Optional<Account> findByEmail(String email);

    List<Account> getAllAccounts();

}
