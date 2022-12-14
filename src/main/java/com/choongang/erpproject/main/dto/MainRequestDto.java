package com.choongang.erpproject.main.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MainRequestDto {
    private String empId;
    private LocalDate startDate;
    private String members;
}
