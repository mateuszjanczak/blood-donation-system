package com.mateuszjanczak.blooddonationsystem.service;

import com.mateuszjanczak.blooddonationsystem.domain.Blood;
import com.mateuszjanczak.blooddonationsystem.domain.BloodType;

public interface IBloodService {
    Blood findByBloodType(BloodType bloodType);
}
