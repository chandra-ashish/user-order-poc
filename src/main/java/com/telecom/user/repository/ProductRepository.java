package com.telecom.user.repository;



import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.telecom.user.model.Product;
@Repository
public interface ProductRepository extends CassandraRepository<Product, String> 
{
	
}
