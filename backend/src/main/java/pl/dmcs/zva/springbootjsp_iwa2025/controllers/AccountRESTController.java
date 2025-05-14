package pl.dmcs.zva.springbootjsp_iwa2025.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.zva.springbootjsp_iwa2025.model.Account;
import pl.dmcs.zva.springbootjsp_iwa2025.repository.AccountRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountRESTController {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountRESTController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        accountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") long id) {
        Account account = accountRepository.findById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@RequestBody Account account,
                                                 @PathVariable("id") long id) {
        account.setId(id);
        accountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Account> updatePartOfAccount(@RequestBody Map<String, Object> updates,
                                                       @PathVariable("id") long id) {
        Account account = accountRepository.findById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (updates.containsKey("accountName")) {
            account.setAccountName((String) updates.get("accountName"));
        }
        accountRepository.save(account);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable("id") long id) {
        Account account = accountRepository.findById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAllAccounts() {
        accountRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<List<Account>> updateAllAccounts(@RequestBody List<Account> accounts) {
        accountRepository.deleteAll();
        List<Account> updated = accountRepository.saveAll(accounts);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}