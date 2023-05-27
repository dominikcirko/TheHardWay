package com.example.ProductivityApp.Service.Implementation;

import com.example.ProductivityApp.Model.Account;
import com.example.ProductivityApp.Repository.AccountRepository;
import com.example.ProductivityApp.Service.Interface.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> createAccount(Account account) {
        return Optional.of(accountRepository.save(account));
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Optional<Account> findAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    ;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
