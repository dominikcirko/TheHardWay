package com.example.ProductivityApp.Controller;

import com.example.ProductivityApp.Model.Account;
import com.example.ProductivityApp.Service.Interface.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;

    }

    @PostMapping("/register")
    public ResponseEntity<Optional<Account>> registerUser(@RequestBody Account account) {
        Optional<Account> usernameFound = accountService.findAccountByUsername(account.getUsername());
        Optional<Account> emailFound = accountService.findByEmail(account.getEmail());
        //if account with entered username or email already exist, return CONFLICT
        //otherwise, create account
        if (usernameFound.isPresent() || emailFound.isPresent()) {
            return new ResponseEntity<>(Optional.empty(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable Optional<Long> id) {
        if (id.isPresent()) {
            accountService.deleteAccount(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Optional<Account>> loginUser(@RequestBody Account account) {
        Optional<Account> findAccount = accountService.findAccountByUsername(account.getUsername());
        if (findAccount.isPresent()) {
            Account accountFound = findAccount.get();
            //if user's entered credentials and credentials from account found in db match, then return account
            //otherwise, return empty Optional + 401 UNAUTHORIZED
            if (account.getPassword().equals(accountFound.getPassword()) && account.getEmail().equals(accountFound.getEmail())) {
                return new ResponseEntity<>(findAccount, HttpStatus.FOUND);
            }
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

}
