package com.mateuszjanczak.blooddonationsystem.service;

import com.mateuszjanczak.blooddonationsystem.domain.Report;

import java.util.List;

public interface IReportService {
    List<Report> findAll();

    Report findById(Long id);

    Report save(Report report);

    void deleteById(Long id);

    void delete(Report report);
}
