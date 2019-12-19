package com.example.customerAccount.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CustomerEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String name;
    private String address1line;
    private String address2line;
    private String city;
    private String state;
    private Long zip;
    private Long phone;
    private String email;

    

}
