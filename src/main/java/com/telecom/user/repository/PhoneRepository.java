package com.telecom.user.repository;



import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.telecom.user.model.Phonenumber;
@Repository
public interface PhoneRepository extends CassandraRepository<Phonenumber, String> 
{
	
	
}
