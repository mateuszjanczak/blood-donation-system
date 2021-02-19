package com.mateuszjanczak.blooddonationsystem.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DonorTest {

    @Test
    void getId() {
        Donor donor = new Donor();
        donor.setId(1L);
        assertEquals(1L, donor.getId());
    }

    @Test
    void getFirstName() {
        Donor donor = new Donor();
        donor.setFirstName("Jan");
        assertEquals("Jan", donor.getFirstName());
    }

    @Test
    void getLastName() {
        Donor donor = new Donor();
        donor.setLastName("Kowalski");
        assertEquals("Kowalski", donor.getLastName());
    }

    @Test
    void getPesel() {
        Donor donor = new Donor();
        donor.setPesel("12341234123");
        assertEquals("12341234123", donor.getPesel());
    }

    @Test
    void getBlood() {
        Donor donor = new Donor();
        donor.setBlood(new Blood(BloodType.O_MINUS));
        assertEquals(new Blood(BloodType.O_MINUS), donor.getBlood());
    }

    @Test
    void setId() {
        Donor donor = new Donor();
        donor.setId(2L);
        assertEquals(2L, donor.getId());
    }

    @Test
    void setFirstName() {
        Donor donor = new Donor();
        donor.setFirstName("Adam");
        assertEquals("Adam", donor.getFirstName());
    }

    @Test
    void setLastName() {
        Donor donor = new Donor();
        donor.setLastName("Nowak");
        assertEquals("Nowak", donor.getLastName());
    }

    @Test
    void setPesel() {
        Donor donor = new Donor();
        donor.setPesel("10987654321");
        assertEquals("10987654321", donor.getPesel());
    }

    @Test
    void setBlood() {
        Donor donor = new Donor();
        donor.setBlood(new Blood(BloodType.AB_MINUS));
        assertEquals(new Blood(BloodType.AB_MINUS), donor.getBlood());
    }

    @Test
    void builder() {
        List<Report> reportList = Collections.emptyList();
        Donor donor = Donor.builder()
                .id(1L)
                .firstName("Jan")
                .lastName("Kowalski")
                .pesel("12341234123")
                .blood(new Blood(BloodType.O_MINUS))
                .reports(reportList)
                .build();

        assertEquals(1L, donor.getId());
        assertEquals("Jan", donor.getFirstName());
        assertEquals("Kowalski", donor.getLastName());
        assertEquals("12341234123", donor.getPesel());
        assertEquals(new Blood(BloodType.O_MINUS), donor.getBlood());
        assertEquals(reportList, donor.getReports());
    }

    @Test
    void getReports() {
        List<Report> reportList = Collections.emptyList();
        Donor donor = new Donor();
        donor.setReports(reportList);
        assertEquals(reportList, donor.getReports());
    }

    @Test
    void setReports() {
        List<Report> reportList = Collections.emptyList();
        Donor donor = new Donor();
        donor.setReports(reportList);
        assertEquals(reportList, donor.getReports());
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

        assertEquals("Donor{id=1, firstName='Jan', lastName='Kowalski', pesel='12341234123', blood=Blood{type=O_MINUS, donors=0, reports=0}, reports=0}", donor.toString());
    }
}