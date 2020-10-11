package com.coding.controller;

import com.coding.converter.TrailToTrailDtoConverter;
import com.coding.dto.TrailDto;
import com.coding.dto.TrailsDto;
import com.coding.service.TrailService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrailController {
    public static final String TRAILS = "/trails";
    public static final String TRAILS_BY_NAME = "/trails/{name}";

    private final TrailService trailService;
    private final TrailToTrailDtoConverter trailToTrailDtoConverter;

    @GetMapping(path = TRAILS, produces = MediaType.APPLICATION_JSON_VALUE)
    public TrailsDto getTrails() {
        final List<TrailDto> trails = trailService.findAllTrails()
                                                  .map(trailToTrailDtoConverter::convert)
                                                  .collect(Collectors.toList());
        return TrailsDto.builder().total(trails.size()).trails(trails).build();
    }

    @GetMapping(path = TRAILS_BY_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
    public TrailDto getTrailByName(@PathVariable("name") final String name) {
        return trailToTrailDtoConverter.convert(trailService.findTrailByNameOrThrowException(name));
    }
}
