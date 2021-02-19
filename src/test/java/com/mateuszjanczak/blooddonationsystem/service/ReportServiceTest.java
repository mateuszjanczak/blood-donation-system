package com.mateuszjanczak.blooddonationsystem.service;

import com.mateuszjanczak.blooddonationsystem.domain.Report;
import com.mateuszjanczak.blooddonationsystem.repository.ReportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {

    @Mock
    ReportRepository reportRepository;

    @InjectMocks
    ReportService reportService;

    @Test
    void findAll() {
        //given
        Report report = new Report();
        ArrayList<Report> reports = new ArrayList<>();
        reports.add(report);
        given(reportRepository.findAll()).willReturn(reports);

        //when
        List<Report> foundReports = reportService.findAll();

        //then
        then(reportRepository).should().findAll();
        assertThat(foundReports).hasSize(1);
    }

    @Test
    void findById() {
        //given
        Report report = new Report();
        given(reportRepository.findById(anyLong())).willReturn(Optional.of(report));

        //when
        Report foundReport = reportService.findById(1L);

        //then
        then(reportRepository).should().findById(anyLong());
        assertThat(foundReport).isNotNull();
    }

    @Test
    void save() {
        //given
        Report report = new Report();
        given(reportRepository.save(any(Report.class))).willReturn(report);

        //when
        Report savedReport = reportService.save(new Report());

        //then
        then(reportRepository).should().save(any(Report.class));
        assertThat(savedReport).isNotNull();
    }

    @Test
    void deleteById() {
        //when
        reportService.deleteById(1L);

        //then
        then(reportRepository).should().deleteById(anyLong());
    }

    @Test
    void delete() {
        //given
        Report report = new Report();

        //when
        reportService.delete(report);

        //then
        then(reportRepository).should().delete(any(Report.class));
    }
}