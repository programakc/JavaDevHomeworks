package ru.klgd.javadev.homework19.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.klgd.javadev.homework19.dto.TelevisionRequest;
import ru.klgd.javadev.homework19.dto.TelevisionResponse;
import ru.klgd.javadev.homework19.entities.Television;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TelevisionMapper {

    TelevisionResponse toTelevisionResponse(Television television);

    Television fromTelevisionCreateRequest(TelevisionRequest televisionRequest);
}
