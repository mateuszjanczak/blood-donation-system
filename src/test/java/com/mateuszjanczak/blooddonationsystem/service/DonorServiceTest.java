package com.mateuszjanczak.blooddonationsystem.service;

import com.mateuszjanczak.blooddonationsystem.domain.Donor;
import com.mateuszjanczak.blooddonationsystem.repository.DonorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DonorServiceTest {

    @Mock
    DonorRepository donorRepository;

    @InjectMocks
    DonorService donorService;


    @Test
    void findAll() {
        //given
        Donor donor = new Donor();
        ArrayList<Donor> donors = new ArrayList<>();
        donors.add(donor);
        given(donorRepository.findAll()).willReturn(donors);

        //when
        List<Donor> foundDonors = donorService.findAll();

        //then
        then(donorRepository).should().findAll();
        assertThat(foundDonors).hasSize(1);
    }

    @Test
    void findById() {
        //given
        Donor donor = new Donor();
        given(donorRepository.findById(anyLong())).willReturn(Optional.of(donor));

        //when
        Donor foundDonor = donorService.findById(1L);

        //then
        then(donorRepository).should().findById(anyLong());
        assertThat(foundDonor).isNotNull();
    }

    @Test
    void save() {
        //given
        Donor donor = new Donor();
        given(donorRepository.save(any(Donor.class))).willReturn(donor);

        //when
        Donor savedDonor = donorService.save(new Donor());

        //then
        then(donorRepository).should().save(any(Donor.class));
        assertThat(savedDonor).isNotNull();
    }

    @Test
    void deleteById() {
        //when
        donorService.deleteById(1L);

        //then
        then(donorRepository).should().deleteById(anyLong());
    }

    @Test
    void delete() {
        //given
        Donor donor = new Donor();

        //when
        donorService.delete(donor);

        //then
        then(donorRepository).should().delete(any(Donor.class));
    }

    @Test
    void findByIdMockito() {
        // GIVEN
        Donor donor = new Donor();
        given(donorRepository.findById(1L)).willReturn(Optional.of(donor));

        // WHEN
        Donor foundDonor = donorService.findById(1L);

        // THEN
        assertThat(foundDonor).isNotNull();
        then(donorRepository).should().findById(any());
        then(donorRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void findByIDThrowsMockito() {
        given(donorRepository.findById(1L)).willThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> donorService.findById(1L));

        then(donorRepository).should().findById(1L);
    }

    @Test
    void testSaveLambdaMockito() {
        //given
        final String MATCH_ME = "12341234123";
        Donor donor = new Donor();
        donor.setPesel(MATCH_ME);

        Donor savedDonor = new Donor();
        savedDonor.setId(1L);

        //need mock to only return on match MATCH_ME string
        given(donorRepository.save(argThat(argument -> argument.getPesel().equals(MATCH_ME)))).willReturn(savedDonor);

        //when
        Donor returnedDonor = donorService.save(donor);

        //then
        assertThat(returnedDonor.getId()).isEqualTo(1L);
    }

    @Test
    void testSaveLambdaNoMatchMockito() {
        //given
        final String MATCH_ME = "MATCH_ME";
        Donor donor = new Donor();
        donor.setPesel("Not a match");

        Donor savedDonor = new Donor();
        savedDonor.setId(1L);

        //need mock to only return on match MATCH_ME string
        given(donorRepository.save(argThat(argument -> argument.getPesel().equals(MATCH_ME)))).willReturn(savedDonor);

        //when
        Donor returnedDonor = donorService.save(donor);

        //then
        assertNull(returnedDonor);
    }

    @Test
    void deleteByIdMockito() {
        donorService.deleteById(1L);
        donorService.deleteById(1L);

        then(donorRepository).should(times(2)).deleteById(1L);
    }

    @Test
    void deleteByIdAtLeastMockito() {
        //given

        //when
        donorService.deleteById(1L);
        donorService.deleteById(1L);

        //then
        then(donorRepository).should(atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteByIdAtMostMockito() {
        //when
        donorService.deleteById(1L);
        donorService.deleteById(1L);

        //then
        then(donorRepository).should(atMost(5)).deleteById(1L);
    }

    @Test
    void deleteByIdNeverMockito() {
        //when
        donorService.deleteById(1L);
        donorService.deleteById(1L);

        //then
        then(donorRepository).should(atLeastOnce()).deleteById(1L);
        then(donorRepository).should(never()).deleteById(5L);
    }

    @Test
    void deleteMockito() {
        //when
        donorService.delete(new Donor());

        //then
        then(donorRepository).should().delete(any());
    }

    @Test
    void deleteBDDMockito() {
        willThrow(new RuntimeException("boom")).given(donorRepository).delete(any());

        assertThrows(RuntimeException.class, () -> donorRepository.delete(new Donor()));

        then(donorRepository).should().delete(any());
    }

    @Test
    void deleteDoThrowMockito() {
        doThrow(new RuntimeException("boom")).when(donorRepository).delete(any());

        assertThrows(RuntimeException.class, () -> donorRepository.delete(new Donor()));

        verify(donorRepository).delete(any());
    }
}