package com.coding.persistance;

import com.coding.model.Booking;
import java.time.LocalDate;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {

    Iterable<Booking> findAllByDateWhen(final LocalDate dateWhen);

}

