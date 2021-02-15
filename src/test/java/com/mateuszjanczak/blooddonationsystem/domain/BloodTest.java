package com.mateuszjanczak.blooddonationsystem.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BloodTest {

    @Test
    void getBloodType() {
        Blood blood = new Blood();
        blood.setBloodType(BloodType.B_PLUS);
        assertEquals(BloodType.B_PLUS, blood.getBloodType());
    }

    @Test
    void setBloodType() {
        Blood blood = new Blood();
        blood.setBloodType(BloodType.AB_MINUS);
        assertEquals(BloodType.AB_MINUS, blood.getBloodType());
    }

    @Test
    void builder() {
        Blood blood = Blood.builder().bloodType(BloodType.O_MINUS).build();
        assertEquals(BloodType.O_MINUS, blood.getBloodType());
    }
}