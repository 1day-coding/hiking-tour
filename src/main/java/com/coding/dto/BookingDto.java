package com.coding.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookingDto {
    private Long id;    // Would be better to return not internal, but something safe as UUID
    private String trailName;
    private List<HikerDto> hikers;
    private LocalDate dateWhen;
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    private BigDecimal totalPrice;
}
