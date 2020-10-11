package com.coding.converter;

import com.coding.dto.TrailDto;
import com.coding.model.CurrencyType;
import com.coding.model.Trail;
import java.math.BigDecimal;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TrailToTrailDtoConverterTest {
    private static final String TRAIL_NAME = "Some_trail";

    private TrailToTrailDtoConverter trailToTrailDtoConverter;

    @BeforeEach
    void setUp() {
        trailToTrailDtoConverter = new TrailToTrailDtoConverter();
    }

    @Test
    void shouldConvert() {
        Trail trail = createTrail();
        TrailDto actual = trailToTrailDtoConverter.convert(trail);
        TrailDto expected = createExpected();
        assertThat(expected).isEqualToComparingFieldByField(actual);
    }

    private Trail createTrail() {
        return Trail.builder()
                    .name(TRAIL_NAME)
                    .startTime(LocalTime.of(16, 0))
                    .endTime(LocalTime.of(18, 0))
                    .minAge(10)
                    .maxAge(50)
                    .price(BigDecimal.valueOf(10.0))
                    .currency(CurrencyType.EUR)
                    .build();
    }

    private TrailDto createExpected() {
        return TrailDto.builder()
                       .name(TRAIL_NAME)
                       .startTime(LocalTime.of(16, 0))
                       .endTime(LocalTime.of(18, 0))
                       .minAge(10)
                       .maxAge(50)
                       .price(BigDecimal.valueOf(10.0))
                       .currency(CurrencyType.EUR)
                       .build();
    }
}