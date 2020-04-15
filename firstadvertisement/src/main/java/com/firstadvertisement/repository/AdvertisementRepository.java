package com.firstadvertisement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstadvertisement.entity.Advertise;

public interface AdvertisementRepository extends JpaRepository<Advertise, Long> {
	List<Advertise> findByName(String name);
	List<Advertise> findByOrderByNameAsc();
	List<Advertise> findByOrderByNameDesc();
	List<Advertise> findByStatus(String status);
	List<Advertise> findById(long id);
	List<Advertise> findByPostId(String postId);
}

