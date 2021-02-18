package com.mateuszjanczak.blooddonationsystem.service;

import com.mateuszjanczak.blooddonationsystem.domain.Donor;

import java.util.List;

public interface IDonorService {
    List<Donor> findAll();

    Donor findById(Long id);

    Donor save(Donor donor);

    void deleteById(Long id);

    void delete(Donor donor);
}
