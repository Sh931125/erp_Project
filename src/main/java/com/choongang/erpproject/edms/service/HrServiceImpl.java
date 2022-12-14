package com.choongang.erpproject.edms.service;

import com.choongang.erpproject.edms.dto.AcResponseDto;
import com.choongang.erpproject.edms.dto.HrRequestDto;
import com.choongang.erpproject.edms.dto.HrResponseDto;
import com.choongang.erpproject.edms.mapper.HrMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HrServiceImpl implements HrService {
    private final HrMapper hrMapper;

    @Override
    public String viewLevNum() {
        String viewLevNum = hrMapper.levNumView();
        return viewLevNum;
    }

    @Override
    public List<HrResponseDto> getLevList(String id) {
        List<HrResponseDto> list = Collections.emptyList();
        int listCount = hrMapper.listCount();
        if(listCount > 0) {
            list = hrMapper.getLevList(id);
        }
        return list;
    }

    @Override
    public HrResponseDto findByNum(Long levId) {
        HrResponseDto numDetail = hrMapper.selectDetail(levId);
        return numDetail;
    }

    @Override
    public List<HrResponseDto> findHr() {
        List<HrResponseDto> hrList = hrMapper.selectHrList();
        return hrList;
    }

    @Override
    public HrResponseDto findWriter(String id) {
        HrResponseDto writerInfo = hrMapper.selectWriter(id);
        return writerInfo;
    }


    @Override
    public void writeSave(HrRequestDto hrRequestDto) {
        hrMapper.writeSave(hrRequestDto);
    }

    @Override
    public void stateSave(HrRequestDto hrRequestDto) {
        hrMapper.stateSave(hrRequestDto);

    }

    @Override
    public HrResponseDto forOutputDetail(String levNum) {

        HrResponseDto param = hrMapper.forOutputDetail(levNum);

        return param;
    }


}
