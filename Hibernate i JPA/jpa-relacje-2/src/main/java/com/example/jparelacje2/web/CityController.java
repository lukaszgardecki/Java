package com.example.jparelacje2.web;

import com.example.jparelacje2.domain.city.CityRequestDto;
import com.example.jparelacje2.domain.city.CityResponseDto;
import com.example.jparelacje2.domain.city.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;


    @PostMapping
    public ResponseEntity<CityResponseDto> addCity(@RequestBody CityRequestDto cityRequestDto) {
        CityResponseDto city = cityService.addCity(cityRequestDto);

        URI savedCityURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(city.getId())
                .toUri();

        return ResponseEntity.created(savedCityURI).body(city);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponseDto> getCityById(@PathVariable Long id) {
        CityResponseDto city = cityService.getCity(id);
        return ResponseEntity.ok(city);
    }

    @GetMapping
    public ResponseEntity<List<CityResponseDto>> getAllCities() {
        List<CityResponseDto> allCities = cityService.getAllCities();
        return ResponseEntity.ok(allCities);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CityResponseDto> deleteCity(@PathVariable Long id) {
        CityResponseDto removedCity = cityService.deleteCity(id);
        return ResponseEntity.ok(removedCity);
    }

    @PostMapping("/{id}")
    public ResponseEntity<CityResponseDto> editCity(@PathVariable Long id, @RequestBody CityRequestDto request) {
        CityResponseDto editedCity = cityService.editCity(id, request);
        return ResponseEntity.ok(editedCity);
    }
}
