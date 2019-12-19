package com.example.customerAccount.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CreditEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long creditId;
    private Long customerId;

   
}
