package dev.ante.email.mapper;

import dev.ante.email.dto.EmailDTO;
import dev.ante.email.entity.Email;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    Email dtoToEntity(EmailDTO dto);

    EmailDTO entityToDto(Email email);
}
