package com.coding.controller;

import com.coding.converter.TrailToTrailDtoConverter;
import com.coding.service.TrailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TrailControllerTest {

    @InjectMocks
    private TrailController underTest;

    @Mock
    private TrailService trailService;

    @Mock
    private TrailToTrailDtoConverter trailToTrailDtoConverter;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnTrails() {
        // given
        //doReturn(Stream.of(Optional.of(...))).when(trailService).findAllTrails();
        // when & then
        var trailsDto = underTest.getTrails();
        //assertThat(expected).containsExactly(trailsDto);
    }

}