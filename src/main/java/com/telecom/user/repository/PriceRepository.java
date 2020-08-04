package com.telecom.user.repository;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.telecom.user.model.PriceData;
@Repository
public interface PriceRepository extends CassandraRepository<PriceData, String> 
{

}
