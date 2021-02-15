package com.mateuszjanczak.blooddonationsystem.service;

import com.mateuszjanczak.blooddonationsystem.domain.Blood;
import com.mateuszjanczak.blooddonationsystem.domain.BloodType;
import com.mateuszjanczak.blooddonationsystem.repository.BloodRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BloodService implements IBloodService {

    private final BloodRepository bloodRepository;

    public BloodService(BloodRepository bloodRepository) {
        this.bloodRepository = bloodRepository;
    }

    @Override
    public Blood findByBloodType(BloodType bloodType){
        return bloodRepository.findById(bloodType).orElse(null);
    }
}
