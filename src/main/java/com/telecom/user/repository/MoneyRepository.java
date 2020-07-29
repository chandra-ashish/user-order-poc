package com.telecom.user.repository;


import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.telecom.user.dto.Offer;
import com.telecom.user.model.Money;
@Repository
public interface MoneyRepository extends CassandraRepository<Money, String> 
{

}
