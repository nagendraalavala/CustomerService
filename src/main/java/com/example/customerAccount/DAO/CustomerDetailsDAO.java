package com.example.customerAccount.DAO;

import lombok.Data;

@Data
public class CustomerDetailsDAO {
	   private Long customerId;
	    private String name;
	    private String address1line;
	    private String address2line;
	    private String city;
	    private String state;
	    private Long zip;
	    private Long phone;
	    private String email;
	    private Long debitId;
	    private Long creditId;

}