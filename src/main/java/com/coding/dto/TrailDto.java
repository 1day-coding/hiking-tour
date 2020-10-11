package com.coding.dto;

import com.coding.model.CurrencyType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TrailDto {
    private String name;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;
    private Integer minAge;
    private Integer maxAge;
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    private BigDecimal price;
    private CurrencyType currency;
}
