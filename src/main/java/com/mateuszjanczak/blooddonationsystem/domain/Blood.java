package com.mateuszjanczak.blooddonationsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blood {
    @Id
    @Enumerated(EnumType.STRING)
    BloodType type;

    @OneToMany(mappedBy = "blood")
    List<Donor> donors;

    @OneToMany(mappedBy = "blood")
    List<Report> reports;

    public Blood(BloodType bloodType) {
    }

    @Override
    public String toString() {
        return "Blood{" +
                "type=" + type +
                ", donors=" + donors.size() +
                ", reports=" + reports.size() +
                '}';
    }
}
