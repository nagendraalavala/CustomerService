package com.example.customerAccount.Entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="Debit")
public class DebitEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long debitId;

    private Long customerId;
    private Long pin;

}
