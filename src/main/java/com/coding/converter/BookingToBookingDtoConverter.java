package com.coding.converter;

import com.coding.dto.BookingDto;
import com.coding.model.Booking;
import com.coding.model.Trail;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class BookingToBookingDtoConverter implements Converter<Booking, BookingDto> {

    private final HikerToHikerDtoConverter hikerToHikerDtoConverter;

    @Override
    public BookingDto convert(final Booking booking) {
        final Trail trail = booking.getTrail();
        final BigDecimal price = trail.getPrice();
        return BookingDto.builder()
                         .id(booking.getId())
                         .trailName(trail.getName())
                         .dateWhen(booking.getDateWhen())
                         .hikers(booking.getHikers().stream().map(hikerToHikerDtoConverter::convert).collect(toList()))
                         .totalPrice(price.multiply(new BigDecimal(booking.getHikers().size())))
                         .build();
    }
}
