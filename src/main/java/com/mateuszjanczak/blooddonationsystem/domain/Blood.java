package com.mateuszjanczak.blooddonationsystem.domain;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Builder
public class Blood {
    @Id
    @Enumerated(EnumType.STRING)
    BloodType bloodType;

    public Blood() {

    }

    public Blood(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
}
