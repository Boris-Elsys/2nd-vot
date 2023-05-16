package com.example.bikeshopapi.repository;

import com.example.bikeshopapi.entity.CustomerBike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerBikeRepository extends JpaRepository<CustomerBike, Long> {
}
