package pl.javastart.equipy.components.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.equipy.components.user.dto.UserAssignmentDto;
import pl.javastart.equipy.components.user.dto.UserDto;
import pl.javastart.equipy.components.user.exception.DuplicatePeselException;
import pl.javastart.equipy.components.user.exception.UserNotFoundException;
import pl.javastart.equipy.components.user.mapper.UserAssignmentMapper;
import pl.javastart.equipy.components.user.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }

    List<UserDto> findByLastName(String lastName) {
        return userRepository.findAllByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }

    UserDto save(UserDto user) {
        Optional<User> userByPesel = userRepository.findByPesel(user.getPesel());
        userByPesel.ifPresent(u -> {
            throw new DuplicatePeselException();
        });
        return mapAndSaveUser(user);
    }

    Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDto);
    }

    UserDto update(UserDto user) {
        Optional<User> userByPesel = userRepository.findByPesel(user.getPesel());
        userByPesel.ifPresent(u -> {
            if (!u.getId().equals(user.getId())) {
                throw new DuplicatePeselException();
            }
        });
        return mapAndSaveUser(user);
    }

    private UserDto mapAndSaveUser(UserDto user) {
        User userEntity = UserMapper.toEntity(user);
        User savedUser = userRepository.save(userEntity);
        return UserMapper.toDto(savedUser);
    }

    List<UserAssignmentDto> getUserAssignments(Long userId) {
        return userRepository.findById(userId)
                .map(User::getAssignments)
                .orElseThrow(UserNotFoundException::new)
                .stream()
                .map(UserAssignmentMapper::toDto)
                .toList();
    }
}
