package pl.javastart.equipy.components.user.mapper;

import pl.javastart.equipy.components.user.User;
import pl.javastart.equipy.components.user.dto.UserDto;

public class UserMapper {
    static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        return dto;
    }

    static User toEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPesel(dto.getPesel());
        return entity;
    }
}
