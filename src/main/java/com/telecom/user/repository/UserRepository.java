package com.telecom.user.repository;



import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.telecom.user.model.User;
@Repository
public interface UserRepository extends CassandraRepository<User, String> 
{
	
	
}
