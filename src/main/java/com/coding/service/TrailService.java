package com.coding.service;

import com.coding.exception.NotFoundException;
import com.coding.model.Trail;
import com.coding.persistance.TrailsRepository;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class TrailService {
    public static final String TRAIL_CANNOT_BE_FOUND = "Trail with name [%s] cannot be found";

    private final TrailsRepository trailsRepository;

    public Trail findTrailByNameOrThrowException(final String name) {
        return trailsRepository.findByName(name).orElseThrow(() -> {
            String msg = format(TRAIL_CANNOT_BE_FOUND, name);
            return new NotFoundException(msg);
        });
    }

    public Stream<Trail> findAllTrails() {
        return StreamSupport.stream(trailsRepository.findAll().spliterator(), false);
    }
}
