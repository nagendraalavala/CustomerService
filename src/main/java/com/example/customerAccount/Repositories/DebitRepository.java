package com.example.customerAccount.Repositories;

import com.example.customerAccount.Entity.DebitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitRepository extends JpaRepository<DebitEntity,Long>
{

	public DebitEntity findByCustomerId(Long customerId);
	
}
