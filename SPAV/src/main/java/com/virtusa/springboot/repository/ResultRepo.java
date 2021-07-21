package com.virtusa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.virtusa.springboot.model.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {
	
}
