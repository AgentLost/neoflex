package com.example.neoflex.web.controller;

import com.example.neoflex.service.CalculateService;
import com.example.neoflex.web.constant.WebConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping(value = WebConstant.VERSION_URL + "/calculate")
public class CalculateController {

    private final CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping
    @Operation(summary = "Calculate vacation pay", responses = {
            @ApiResponse(description = "calculate",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Long.class)))})
    public Double calculate(@RequestParam Long avg,
                          @RequestParam Long size){
        Double res = calculateService.calculate(avg, size);
        log.info("calculate vacation pay: {}", res);
        return res;
    }
}
