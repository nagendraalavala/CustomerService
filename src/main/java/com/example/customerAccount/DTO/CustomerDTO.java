package com.example.customerAccount.DTO;

import lombok.Data;

@Data
public class CustomerDTO
{
    private String Name;
    private String Address1line;
    private String Address2line;
    private String city;
    private String state;
    private Long zip;
    private Long phone;
    private String email;

   
}
