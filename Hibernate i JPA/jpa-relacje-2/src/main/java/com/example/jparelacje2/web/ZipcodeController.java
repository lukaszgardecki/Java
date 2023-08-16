package com.example.jparelacje2.web;

import com.example.jparelacje2.domain.zipcode.ZipcodeRequestDto;
import com.example.jparelacje2.domain.zipcode.ZipcodeResponseDto;
import com.example.jparelacje2.domain.zipcode.ZipcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/zipcodes")
@RequiredArgsConstructor
public class ZipcodeController {
    private final ZipcodeService zipcodeService;

    @PostMapping
    public ResponseEntity<ZipcodeResponseDto> addZipcode(@RequestBody ZipcodeRequestDto request) {
        ZipcodeResponseDto savedZipcode = zipcodeService.addZipcode(request);
        URI savedZipcodeURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedZipcode.getId())
                .toUri();

        return ResponseEntity.created(savedZipcodeURI).body(savedZipcode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZipcodeResponseDto> getZipcode(@PathVariable Long id) {
        ZipcodeResponseDto zipcode = zipcodeService.getZipcode(id);
        return ResponseEntity.ok(zipcode);
    }

    @GetMapping
    public ResponseEntity<List<ZipcodeResponseDto>> getAllZipcodes() {
        List<ZipcodeResponseDto> allZipcodes = zipcodeService.getAllZipcodes();
        return ResponseEntity.ok(allZipcodes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ZipcodeResponseDto> deleteZipcode(@PathVariable Long id) {
        ZipcodeResponseDto removedZipcode = zipcodeService.deleteZipcode(id);
        return ResponseEntity.ok(removedZipcode);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ZipcodeResponseDto> editZipcode(@PathVariable Long id, @RequestBody ZipcodeRequestDto request) {
        ZipcodeResponseDto editedZipcode = zipcodeService.editZipcode(id, request);
        return ResponseEntity.ok(editedZipcode);
    }

    @PostMapping("/{zipcodeId}/addCity/{cityId}")
    public ResponseEntity<ZipcodeResponseDto> addCityToZipcode(@PathVariable Long zipcodeId, @PathVariable Long cityId) {
        ZipcodeResponseDto zipcode = zipcodeService.addCityToZipcode(zipcodeId, cityId);
        return ResponseEntity.ok(zipcode);
    }

    @PostMapping("/{zipcodeId}/removeCity")
    public ResponseEntity<ZipcodeResponseDto> removeCityFromZipcode(@PathVariable Long zipcodeId) {
        ZipcodeResponseDto zipcode = zipcodeService.removeCityFromZipcode(zipcodeId);
        return ResponseEntity.ok(zipcode);
    }
}
