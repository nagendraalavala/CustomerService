package com.example.customerAccount.Entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="Customer")
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
