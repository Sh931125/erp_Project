package com.choongang.erpproject.edms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.util.List;

//insert & update
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcRequestDto {
    //결의번호
    private String expNum;
    //작성자
    private String empId;
    private String empName;
    //결재자
    private String appr;
    private String apprId;


    //소속
    private String hqName;
    private String depName;
    //상신일자(등록일자)
    private LocalDate applDate;
    //제목
    private String expTitle;

    //계정과목
    private String detCode;
    //적요
    private String remk;
    //카드/계좌
    private String comAcc;
    //금액
    private int expense;

    //증빙서류
    private String attFile;
    private String attFilepath;
    private int attFilesize;

    //승인상태& 날짜
    private String apprState;
    private String apprDate;
    private String majCode;

    //insert용 dto
    private List<AcRequestDto> acRequestDtoList;
    public List<AcRequestDto> getAcRequestDtoList() {
        return acRequestDtoList;
    }
    public void setAcRequestDtoList(List<AcRequestDto> acRequestDtoList) {
        this.acRequestDtoList = acRequestDtoList;
    }
}
