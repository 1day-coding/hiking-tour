package com.coding.converter;

import com.coding.dto.TrailDto;
import com.coding.model.Trail;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TrailToTrailDtoConverter implements Converter<Trail, TrailDto> {

    @Override
    public TrailDto convert(final Trail trail) {
        return TrailDto.builder()
                       .name(trail.getName())
                       .startTime(trail.getStartTime())
                       .endTime(trail.getEndTime())
                       .minAge(trail.getMinAge())
                       .maxAge(trail.getMaxAge())
                       .price(trail.getPrice())
                       .currency(trail.getCurrency())
                       .build();
    }
}
