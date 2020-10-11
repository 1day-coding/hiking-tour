package com.coding.converter;

import com.coding.dto.HikerDto;
import com.coding.model.Hiker;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HikerToHikerDtoConverter implements Converter<Hiker, HikerDto> {

    @Override
    public HikerDto convert(final Hiker hiker) {
        return HikerDto.builder()
                    .firstName(hiker.getFirstName())
                    .lastName(hiker.getLastName())
                    .age(hiker.getAge())
                    .build();
    }
}
