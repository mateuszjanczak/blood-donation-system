package com.mateuszjanczak.blooddonationsystem;

import com.mateuszjanczak.blooddonationsystem.domain.Blood;
import com.mateuszjanczak.blooddonationsystem.domain.BloodType;
import com.mateuszjanczak.blooddonationsystem.repository.BloodRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class BloodDonationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationSystemApplication.class, args);
    }

    @Bean
    public ApplicationRunner initDb(BloodRepository bloodRepository) {
        return args -> bloodRepository.saveAll(
                Arrays.asList(
                        Blood.builder()
                                .type(BloodType.A_PLUS)
                                .build(),
                        Blood.builder()
                                .type(BloodType.A_MINUS)
                                .build(),
                        Blood.builder()
                                .type(BloodType.AB_PLUS)
                                .build(),
                        Blood.builder()
                                .type(BloodType.AB_MINUS)
                                .build(),
                        Blood.builder()
                                .type(BloodType.B_PLUS)
                                .build(),
                        Blood.builder()
                                .type(BloodType.B_MINUS)
                                .build(),
                        Blood.builder()
                                .type(BloodType.O_PLUS)
                                .build(),
                        Blood.builder()
                                .type(BloodType.O_MINUS)
                                .build()
                )
        );
    }
}
