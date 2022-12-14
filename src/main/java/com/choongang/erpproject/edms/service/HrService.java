package com.choongang.erpproject.edms.service;

import com.choongang.erpproject.edms.dto.AcResponseDto;
import com.choongang.erpproject.edms.dto.HrRequestDto;
import com.choongang.erpproject.edms.dto.HrResponseDto;

import java.util.List;

public interface HrService {

    String viewLevNum();
    List<HrResponseDto> getLevList(String id);

    List<HrResponseDto> findHr();

    //HrResponseDto getLevDetail(Long levId);
    HrResponseDto findByNum(Long levId);
    HrResponseDto findWriter(String id);


    void writeSave(HrRequestDto hrRequestDto);

    void stateSave(HrRequestDto hrRequestDto);

    HrResponseDto forOutputDetail(String levNum);

}
