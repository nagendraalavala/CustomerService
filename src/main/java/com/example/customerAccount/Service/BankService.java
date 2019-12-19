package com.example.customerAccount.Service;

import com.example.customerAccount.DAO.CreditDAO;
import com.example.customerAccount.DAO.CustomerDAO;
import com.example.customerAccount.DAO.CustomerDetailsDAO;
import com.example.customerAccount.DAO.DebitDAO;
import com.example.customerAccount.DTO.CreditDTO;
import com.example.customerAccount.DTO.CustomerDTO;
import com.example.customerAccount.DTO.DebitDTO;
import com.example.customerAccount.Entity.CreditEntity;
import com.example.customerAccount.Entity.CustomerEntity;
import com.example.customerAccount.Entity.DebitEntity;
import com.example.customerAccount.Repositories.CreditRepository;
import com.example.customerAccount.Repositories.CustomerRepository;
import com.example.customerAccount.Repositories.DebitRepository;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {

    private CustomerRepository customerRepository;
    private DebitRepository debitRepository;
    private CustomerDAO customerDAO;
    private DebitDAO debitDAO;
    private CreditDAO creditDAO;
    private CustomerDetailsDAO customerDetailsDAO;
    private ModelMapper modelMapper;
    private CreditRepository creditRepository;
    private DebitEntity debitEntity;
    private CreditEntity creditEntity;
    

    public BankService(CustomerRepository customerRepository,DebitRepository debitRepository,CreditRepository creditRepository) {
        this.customerRepository = customerRepository;
        this.customerDAO = new CustomerDAO();
        this.modelMapper = new ModelMapper();
        this.debitRepository = debitRepository;
        this.creditRepository = creditRepository;
        this.debitDAO = new DebitDAO();
        this.creditDAO = new CreditDAO();
        this.customerDetailsDAO = new CustomerDetailsDAO();
        
    }

    public CustomerDAO saveCustomer(CustomerDTO customerNew)
    {
    	CustomerEntity customerEntity;
    	customerEntity = modelMapper.map(customerNew, CustomerEntity.class);
    	System.out.println("Customer" + customerEntity);
        customerRepository.save(customerEntity);
        Optional<CustomerEntity> customerPresent=customerRepository.findById(customerEntity.getCustomerId());
        if(customerPresent.isPresent()){
            CustomerEntity newCustomer;
            newCustomer=customerPresent.get();
            customerDAO.setCustomerId(newCustomer.getCustomerId());
            customerDAO.setStatus("Success");
            return  customerDAO;
        }
        else
        {
            throw new RuntimeException("Error in Saving Customer . Please try again");
        }

    }

	public DebitDAO openDebit(DebitDTO debitCard) {
		DebitEntity debitEntity;
		debitEntity = modelMapper.map(debitCard, DebitEntity.class);
		
		Optional<CustomerEntity> customer=customerRepository.findById(debitEntity.getCustomerId());

		if( customer.isPresent()) {
			debitRepository.save(debitEntity);
			debitDAO.setCustomerId(debitEntity.getCustomerId());
			debitDAO.setDebitId(debitEntity.getDebitId());
			return debitDAO;
		}
		else {
			throw new RuntimeException("Error in Opening Account . Please try again");
		}

	}
	
	
	public CreditDAO openCredit(CreditDTO creditCard) {
		CreditEntity creditEntity;
		creditEntity = modelMapper.map(creditCard, CreditEntity.class);
		Optional<CustomerEntity> customer=customerRepository.findById(creditEntity.getCustomerId());
		System.out.println("Customer" + customer);
		if( customer.isPresent()) {
			creditRepository.save(creditEntity);
			creditDAO.setCustomerId(creditEntity.getCustomerId());
			creditDAO.setCreditId(creditEntity.getCreditId());
			return creditDAO;
		}
		else {
			throw new RuntimeException("Error in Opening Account . Please try again");
		}


	}
	
	
	public CustomerDetailsDAO getCustomer(Long id) {
		Optional<CustomerEntity> customer=customerRepository.findById(id);
		if( customer.isPresent()) {
			customerDetailsDAO = modelMapper.map(customer.get(), CustomerDetailsDAO.class);
			debitEntity = debitRepository.findByCustomerId(customerDetailsDAO.getCustomerId());
			customerDetailsDAO.setDebitId(debitEntity.getDebitId());
			creditEntity = creditRepository.findByCustomerId(customerDetailsDAO.getCustomerId());
			customerDetailsDAO.setCreditId(creditEntity.getCreditId());
			
			System.out.println("Final details" + customerDetailsDAO);
			return customerDetailsDAO;
		}
		else {
			throw new RuntimeException("Error in Opening Account . Please try again");
		}
	}
	
}
