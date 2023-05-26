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
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
    @Override
    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
    @Override
    public Optional<Account> findAccountById(Long id){
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
