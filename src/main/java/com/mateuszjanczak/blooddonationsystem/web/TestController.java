package com.mateuszjanczak.blooddonationsystem.web;

import com.mateuszjanczak.blooddonationsystem.domain.Blood;
import com.mateuszjanczak.blooddonationsystem.domain.BloodType;
import com.mateuszjanczak.blooddonationsystem.domain.Donor;
import com.mateuszjanczak.blooddonationsystem.domain.Report;
import com.mateuszjanczak.blooddonationsystem.service.IBloodService;
import com.mateuszjanczak.blooddonationsystem.service.IDonorService;
import com.mateuszjanczak.blooddonationsystem.service.IReportService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final IBloodService bloodService;
    private final IDonorService donorService;
    private final IReportService reportService;

    public TestController(IBloodService bloodService, IDonorService donorService, IReportService reportService) {
        this.bloodService = bloodService;
        this.donorService = donorService;
        this.reportService = reportService;
    }

    @GetMapping("/test1")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void test() {

        Blood blood = bloodService.findById(BloodType.O_MINUS);

        Donor donor = Donor.builder()
                .firstName("Andrzej")
                .lastName("Akiso")
                .pesel("3213321")
                .blood(blood)
                .build();

        donorService.save(donor);
    }

    @GetMapping("/test2")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void test2() {

        Blood blood = bloodService.findById(BloodType.O_MINUS);
        Donor donor = donorService.findById(1L);

        Report report = new Report();
        report.setDonor(donor);
        report.setBlood(blood);
        report.setAmount(500);
        reportService.save(report);
    }

    @GetMapping("/test3")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void test3() {
        System.out.println(donorService.findById(1L).getReports());
        System.out.println(donorService.findById(1L).getBlood());
        System.out.println(reportService.findById(1L).getDonor());
        System.out.println(reportService.findById(1L).getBlood());
    }
}
