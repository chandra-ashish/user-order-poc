package com.telecom.user.repository;




import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.telecom.user.model.Offer;


@Repository
public interface OfferRepository extends CassandraRepository<Offer,String> 
{
	//Offer findById(String id);
}
