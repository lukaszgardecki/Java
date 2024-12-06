package com.example.przyklad_4.adapter.rest;

import com.example.przyklad_4.appliaction.dto.RegisterUserDTO;
import com.example.przyklad_4.appliaction.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
class UserController {
    private final UserFacade userFacade;

    @GetMapping("/{userUUID}")
    public ResponseEntity<UserDTO> getUser(@PathVariable UUID userUUID) {
        return ResponseEntity.ok(userFacade.getUser(userUUID));
    }
    @PostMapping("/register")
    public ResponseEntity<UUID> registerUser(@RequestBody @Valid RegisterUserDTO dto) {
        UUID user = userFacade.registerUser(dto);
        return ResponseEntity.ok(user);
    }
}
