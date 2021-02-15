package com.mateuszjanczak.blooddonationsystem.repository;

import com.mateuszjanczak.blooddonationsystem.domain.Blood;
import com.mateuszjanczak.blooddonationsystem.domain.BloodType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRepository extends CrudRepository<Blood, BloodType> {

}
