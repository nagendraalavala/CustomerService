package com.example.customerAccount.Repositories;

import com.example.customerAccount.Entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<CreditEntity,Long>
{
	public CreditEntity findByCustomerId(Long customerId);
}
