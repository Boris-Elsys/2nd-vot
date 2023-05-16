package com.example.bikeshopapi.repository;

import com.example.bikeshopapi.entity.BikeShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeShopRepository extends JpaRepository<BikeShop, Long> {
}
