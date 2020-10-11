package com.coding.persistance;

import com.coding.model.Trail;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface TrailsRepository extends CrudRepository<Trail, Long> {

    Optional<Trail> findByName(final String name);
}

