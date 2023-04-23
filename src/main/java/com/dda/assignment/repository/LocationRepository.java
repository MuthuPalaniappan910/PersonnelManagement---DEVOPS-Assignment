package com.dda.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dda.assignment.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

}
