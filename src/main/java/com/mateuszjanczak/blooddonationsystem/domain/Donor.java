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
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;

    @Column(unique = true)
    String pesel;

    @ManyToOne
    Blood blood;

    @OneToMany(mappedBy = "donor")
    List<Report> reports;

    @Override
    public String toString() {
        return "Donor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", blood=" + blood +
                ", reports=" + reports.size() +
                '}';
    }
}
