package com.mateuszjanczak.blooddonationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends CrudRepository<DonorRepository, Long> {
}
