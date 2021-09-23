package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Advertisement;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    
}
