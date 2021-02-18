package com.mateuszjanczak.blooddonationsystem.service;

import com.mateuszjanczak.blooddonationsystem.domain.Donor;
import com.mateuszjanczak.blooddonationsystem.repository.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService implements IDonorService {

    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    @Override
    public Donor findById(Long id){
        return donorRepository.findById(id).orElse(null);
    }

    @Override
    public Donor save(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public void deleteById(Long id) {
        donorRepository.deleteById(id);
    }

    @Override
    public void delete(Donor donor) {
        donorRepository.delete(donor);
    }
}
