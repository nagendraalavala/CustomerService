package com.example.customerAccount.Entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="Credit")
public class CreditEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long creditId;
    private Long customerId;

   
}
