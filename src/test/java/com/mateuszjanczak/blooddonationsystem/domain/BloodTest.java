package com.mateuszjanczak.blooddonationsystem.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BloodTest {

    @Test
    void getBloodType() {
        Blood blood = new Blood();
        blood.setType(BloodType.B_PLUS);
        assertEquals(BloodType.B_PLUS, blood.getType());
    }

    @Test
    void setBloodType() {
        Blood blood = new Blood();
        blood.setType(BloodType.AB_MINUS);
        assertEquals(BloodType.AB_MINUS, blood.getType());
    }

    @Test
    void builder() {
        List<Donor> donorList = Collections.emptyList();
        List<Report> reportList = Collections.emptyList();

        Blood blood = Blood.builder()
                .type(BloodType.O_MINUS)
                .donors(donorList)
                .reports(reportList)
                .build();

        assertEquals(BloodType.O_MINUS, blood.getType());
        assertEquals(donorList, blood.getDonors());
        assertEquals(reportList, blood.getReports());
    }

    @Test
    void testToString() {
        Blood blood = Blood.builder()
                .type(BloodType.O_MINUS)
                .donors(Collections.emptyList())
                .reports(Collections.emptyList())
                .build();

        assertEquals("Blood{type=O_MINUS, donors=0, reports=0}", blood.toString());
    }

    @Test
    void getDonors() {
        List<Donor> donorList = Collections.emptyList();
        Blood blood = new Blood();
        blood.setDonors(donorList);
        assertEquals(donorList, blood.getDonors());
    }

    @Test
    void getReports() {
        List<Report> reportList = Collections.emptyList();
        Blood blood = new Blood();
        blood.setReports(reportList);
        assertEquals(reportList, blood.getReports());
    }

    @Test
    void setDonors() {
        List<Donor> donorList = Collections.emptyList();
        Blood blood = new Blood();
        blood.setDonors(donorList);
        assertEquals(donorList, blood.getDonors());
    }

    @Test
    void setReports() {
        List<Report> reportList = Collections.emptyList();
        Blood blood = new Blood();
        blood.setReports(reportList);
        assertEquals(reportList, blood.getReports());
    }
}