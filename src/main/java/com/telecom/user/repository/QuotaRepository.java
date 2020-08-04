package com.telecom.user.repository;




import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.telecom.user.model.Quota;
@Repository
public interface QuotaRepository extends CassandraRepository<Quota, String> 
{

}
