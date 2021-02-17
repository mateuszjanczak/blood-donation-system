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
    BloodType bloodType;

    @OneToMany
    List<Donor> donors;
}
