package com.example.customerAccount.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DebitEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long debitId;

    private Long customerId;
    private Long pin;

}
