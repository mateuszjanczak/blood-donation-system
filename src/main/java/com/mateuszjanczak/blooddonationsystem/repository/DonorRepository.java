package com.mateuszjanczak.blooddonationsystem.repository;

import com.mateuszjanczak.blooddonationsystem.domain.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {

}
