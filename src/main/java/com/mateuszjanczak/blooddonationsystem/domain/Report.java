package com.mateuszjanczak.blooddonationsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Donor donor;

    @ManyToOne
    Blood blood;

    int amount;

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", donor=" + donor +
                ", blood=" + blood +
                ", amount=" + amount +
                '}';
    }
}
