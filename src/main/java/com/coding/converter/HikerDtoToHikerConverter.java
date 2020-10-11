package com.coding.converter;

import com.coding.dto.HikerDto;
import com.coding.model.Hiker;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HikerDtoToHikerConverter implements Converter<HikerDto, Hiker> {

    @Override
    public Hiker convert(final HikerDto hikerDto) {
        return Hiker.builder()
                    .firstName(hikerDto.getFirstName())
                    .lastName(hikerDto.getLastName())
                    .age(hikerDto.getAge())
                    .build();
    }
}
