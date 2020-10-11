package com.coding.controller;

import com.coding.converter.BookingToBookingDtoConverter;
import com.coding.converter.HikerDtoToHikerConverter;
import com.coding.dto.BookingDto;
import com.coding.dto.CreateBookingDto;
import com.coding.model.Booking;
import com.coding.service.BookingService;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static java.time.LocalDate.now;

@RestController
@RequiredArgsConstructor
public class BookingController {
    public static final String BOOKINGS = "/bookings";
    public static final String BOOKING_BY_ID = "/bookings/{id}";

    private final BookingService bookingService;
    private final HikerDtoToHikerConverter hikerDtoToHikerConverter;
    private final BookingToBookingDtoConverter bookingToBookingDtoConverter;

    @PostMapping(path = BOOKINGS, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody final CreateBookingDto createBookingDto) {
        final Booking booking = bookingService.create(createBookingDto.getTrailName(),
                                                      createBookingDto.getHikers()
                                                                      .stream()
                                                                      .map(hikerDtoToHikerConverter::convert)
                                                                      .collect(Collectors.toList()),
                                                      createBookingDto.getDateWhen() != null ? createBookingDto.getDateWhen() : now());

        return ResponseEntity.created(URI.create(BOOKINGS + "/" + booking.getId())).body(bookingToBookingDtoConverter.convert(booking));
    }

    @DeleteMapping(path = BOOKING_BY_ID)
    public ResponseEntity cancelBooking(@PathVariable("id") final Long bookingId) {
        bookingService.delete(bookingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = BOOKING_BY_ID)
    public BookingDto viewBooking(@PathVariable("id") final Long bookingId) {
        return bookingToBookingDtoConverter.convert(bookingService.findBookingByIdOrThrowException(bookingId));
    }

/*
    @GetMapping(path = BOOKINGS)
    public List<BookingDto> viewBookings(@RequestParam("ids") final List<Long> bookingIds) {
        return bookingService.findBookingByIds(bookingIds).map(bookingToBookingDtoConverter::convert).collect(Collectors.toList());
    }
*/

    @GetMapping(path = BOOKINGS)
    public List<BookingDto> viewBookingsByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate date) {
        return bookingService.findBookingsByDate(date).map(bookingToBookingDtoConverter::convert).collect(Collectors.toList());
    }

}
