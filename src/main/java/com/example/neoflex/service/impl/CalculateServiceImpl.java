package com.example.neoflex.service.impl;

import com.example.neoflex.exception.BadRequestException;
import com.example.neoflex.service.CalculateService;
import com.example.neoflex.web.constant.CalculateConstant;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public Double calculate(Long avgSalary, Long size) {
        if(avgSalary < 0 || size < 0){
            throw new BadRequestException("size and salary must be greater than 0");
        }

        return ((avgSalary * CalculateConstant.COUNT_MONTH)/CalculateConstant.COUNT_DAYS)*0.87*size;
    }


}
