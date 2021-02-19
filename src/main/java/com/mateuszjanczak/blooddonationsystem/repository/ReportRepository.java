package com.mateuszjanczak.blooddonationsystem.repository;

import com.mateuszjanczak.blooddonationsystem.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
