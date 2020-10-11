package com.coding.service;

import com.coding.exception.AgeVerificationException;
import com.coding.exception.NotFoundException;
import com.coding.model.Booking;
import com.coding.model.Hiker;
import com.coding.model.Trail;
import com.coding.persistance.BookingRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class BookingService {

    public static final String BOOKING_CANNOT_BE_FOUND = "Booking with id [%d] cannot be found";

    private final BookingRepository bookingRepository;
    private final TrailService trailService;

    public Booking create(final String trailName, final List<Hiker> hikers, final LocalDate dateWhen) {
        final Trail trail = trailService.findTrailByNameOrThrowException(trailName);
        if (!validateAge(hikers, trail)) {
            throw new AgeVerificationException();
        }
        return bookingRepository.save(new Booking(trail, hikers, dateWhen));
    }

    public void delete(final Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking findBookingByIdOrThrowException(final Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> {
            String msg = format(BOOKING_CANNOT_BE_FOUND, id);
            return new NotFoundException(msg);
        });
    }

    public Stream<Booking> findBookingByIds(final List<Long> ids) {
        return StreamSupport.stream(bookingRepository.findAllById(ids).spliterator(), false);
    }

    public Stream<Booking> findBookingsByDate(final LocalDate dateWhen) {
        return StreamSupport.stream(bookingRepository.findAllByDateWhen(dateWhen).spliterator(), false);
    }

    private boolean validateAge(final List<Hiker> hikers, final Trail trail) {
        for (Hiker hiker : hikers) {
            if (hiker.getAge() < trail.getMinAge() || hiker.getAge() > trail.getMaxAge()) {
                return false;
            }
        }
        return true;
    }

}
