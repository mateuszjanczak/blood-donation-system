package com.mateuszjanczak.blooddonationsystem.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BloodTypeTest {

    @Test
    void values() {
        assertEquals(8, BloodType.values().length);
    }

    @Test
    void valueOf() {
        assertEquals("O_MINUS", BloodType.O_MINUS.name());
        assertEquals("O_PLUS", BloodType.O_PLUS.name());
        assertEquals("A_MINUS", BloodType.A_MINUS.name());
        assertEquals("A_PLUS", BloodType.A_PLUS.name());
        assertEquals("B_MINUS", BloodType.B_MINUS.name());
        assertEquals("B_PLUS", BloodType.B_PLUS.name());
        assertEquals("AB_MINUS", BloodType.AB_MINUS.name());
        assertEquals("AB_PLUS", BloodType.AB_PLUS.name());
    }
}