package com.coding.dto;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingDto {
    @NotBlank
    private String trailName;
    private LocalDate dateWhen;
    @NotEmpty
    private List<HikerDto> hikers;
}
