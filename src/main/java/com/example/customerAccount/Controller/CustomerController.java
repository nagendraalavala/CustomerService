package com.example.customerAccount.Controller;

import com.example.customerAccount.DAO.CreditDAO;
import com.example.customerAccount.DAO.CustomerDAO;
import com.example.customerAccount.DAO.CustomerDetailsDAO;
import com.example.customerAccount.DAO.DebitDAO;
import com.example.customerAccount.DTO.CreditDTO;
import com.example.customerAccount.DTO.CustomerDTO;
import com.example.customerAccount.DTO.DebitDTO;
import com.example.customerAccount.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private BankService bankService;

    @PostMapping("/registration")
    public CustomerDAO registration(@RequestBody CustomerDTO customer){
        return  bankService.saveCustomer(customer);
    }
    
    @PostMapping("/debitAct")
    public DebitDAO debitService(@RequestBody DebitDTO debitCard) {
    	System.out.println("Debit" + debitCard);
    	return bankService.openDebit(debitCard);
    }
    
    @PostMapping("/creditAct")
    public CreditDAO creditService(@RequestBody CreditDTO creditCard) {
    	System.out.println("Debit" + creditCard);
    	return bankService.openCredit(creditCard);
    }
    
    @GetMapping("/getCustomer/{id}")
    public CustomerDetailsDAO getCustomer(@PathVariable("id") Long id) {
    	System.out.println("Id" + id);
    	return bankService.getCustomer(id);
    }
}
