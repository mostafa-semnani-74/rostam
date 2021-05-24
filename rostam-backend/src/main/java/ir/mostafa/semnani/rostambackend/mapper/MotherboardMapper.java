package ir.mostafa.semnani.rostambackend.mapper;

import ir.mostafa.semnani.rostambackend.dto.MotherboardDTO;
import ir.mostafa.semnani.rostambackend.entity.Motherboard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MotherboardMapper {

    MotherboardMapper motherboardMapperInstance = Mappers.getMapper(MotherboardMapper.class);

    @Mapping(source = "model", target = "name")
    MotherboardDTO entityToDTO(Motherboard entity);

    @Mapping(source = "name", target = "model")
    Motherboard dtoToEntity(MotherboardDTO DTO);

}
