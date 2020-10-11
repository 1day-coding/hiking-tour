package com.coding.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TrailsDto {
    private long total;
    private List<TrailDto> trails;
}
