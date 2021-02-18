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
public class Donor {
    @Id
    Long id;
    String firstName;
    String lastName;
    String pesel;

    @ManyToOne
    Blood blood;
}
