package com.telecom.user.repository;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.telecom.user.model.Money;
@Repository
public interface MoneyRepository extends CassandraRepository<Money, String> 
{

}
