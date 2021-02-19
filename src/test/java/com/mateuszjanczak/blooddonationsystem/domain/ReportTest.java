package com.mateuszjanczak.blooddonationsystem.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportTest {

    @Test
    void getId() {
        Report report = new Report();
        report.setId(1L);
        assertEquals(1L, report.getId());
    }

    @Test
    void getDonor() {
        Donor donor = new Donor();
        Report report = new Report();
        report.setDonor(donor);
        assertEquals(donor, report.getDonor());
    }

    @Test
    void getBlood() {
        Blood blood = new Blood();
        Report report = new Report();
        report.setBlood(blood);
        assertEquals(blood, report.getBlood());
    }

    @Test
    void getAmount() {
        Report report = new Report();
        report.setAmount(100);
        assertEquals(100, report.getAmount());
    }

    @Test
    void setId() {
        Report report = new Report();
        report.setId(5L);
        assertEquals(5L, report.getId());
    }

    @Test
    void setDonor() {
        Donor donor = new Donor();
        Report report = new Report();
        report.setDonor(donor);
        assertEquals(donor, report.getDonor());
    }

    @Test
    void setBlood() {
        Blood blood = new Blood();
        Report report = new Report();
        report.setBlood(blood);
        assertEquals(blood, report.getBlood());
    }

    @Test
    void setAmount() {
        Report report = new Report();
        report.setAmount(500);
        assertEquals(500, report.getAmount());
    }

    @Test
    void builder() {
        Donor donor = new Donor();
        Blood blood = new Blood();

        Report report = Report.builder()
                .id(1L)
                .donor(donor)
                .blood(blood)
                .amount(100)
                .build();

        assertEquals(1L, report.getId());
        assertEquals(donor, report.getDonor());
        assertEquals(blood, report.getBlood());
        assertEquals(100, report.getAmount());
    }

    @Test
    void testToString() {
        Blood blood = Blood.builder()
                .type(BloodType.O_MINUS)
                .donors(Collections.emptyList())
                .reports(Collections.emptyList())
                .build();

        List<Report> reportList = Collections.emptyList();

        Donor donor = Donor.builder()
                .id(1L)
                .firstName("Jan")
                .lastName("Kowalski")
                .pesel("12341234123")
                .blood(blood)
                .reports(reportList)
                .build();

        Report report = Report.builder()
                .id(1L)
                .donor(donor)
                .blood(blood)
                .amount(100)
                .build();

        assertEquals("Report{id=1, donor=Donor{id=1, firstName='Jan', lastName='Kowalski', pesel='12341234123', blood=Blood{type=O_MINUS, donors=0, reports=0}, reports=0}, blood=Blood{type=O_MINUS, donors=0, reports=0}, amount=100}", report.toString());
    }
}