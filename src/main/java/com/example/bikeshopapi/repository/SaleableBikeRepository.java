package com.example.bikeshopapi.repository;

import com.example.bikeshopapi.entity.SaleableBike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleableBikeRepository extends JpaRepository<SaleableBike, Long> {
}
