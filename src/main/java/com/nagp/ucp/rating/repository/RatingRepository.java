package com.nagp.ucp.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagp.ucp.rating.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query(value = "SELECT r FROM Rating r WHERE r.serviceId = ?1")
    public List<Rating> findByServiceId(int serviceId);
}
