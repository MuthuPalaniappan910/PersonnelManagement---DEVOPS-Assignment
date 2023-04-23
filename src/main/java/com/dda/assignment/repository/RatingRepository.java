package com.dda.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dda.assignment.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{

}
