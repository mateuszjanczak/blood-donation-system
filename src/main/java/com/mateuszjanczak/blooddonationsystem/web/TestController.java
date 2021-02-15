package com.mateuszjanczak.blooddonationsystem.web;

import com.mateuszjanczak.blooddonationsystem.domain.BloodType;
import com.mateuszjanczak.blooddonationsystem.service.IBloodService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final IBloodService bloodService;

    public TestController(IBloodService bloodService) {
        this.bloodService = bloodService;
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody void test(){

    }
}
