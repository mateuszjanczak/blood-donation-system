package com.mateuszjanczak.blooddonationsystem.service;

import com.mateuszjanczak.blooddonationsystem.domain.Blood;
import com.mateuszjanczak.blooddonationsystem.domain.BloodType;
import com.mateuszjanczak.blooddonationsystem.repository.BloodRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class BloodServiceTest {

    @Mock
    BloodRepository bloodRepository;

    @InjectMocks
    BloodService bloodService;

    @Test
    void findByBloodType() {
        // GIVEN
        Blood blood = new Blood();
        given(bloodRepository.findById(BloodType.O_MINUS)).willReturn(Optional.of(blood));

        // WHEN
        Blood foundBlood = bloodService.findByBloodType(BloodType.O_MINUS);

        // THEN
        assertThat(foundBlood).isNotNull();
        then(bloodRepository).should().findById(any());
        then(bloodRepository).shouldHaveNoMoreInteractions();
    }
}