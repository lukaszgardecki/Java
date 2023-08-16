package com.example.jparelacje2.domain.city;

import com.example.jparelacje2.Mapper;
import com.example.jparelacje2.exception.CityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    @Transactional
    public CityResponseDto addCity(CityRequestDto cityRequestDto) {
        City cityToSave = Mapper.mapCityRequestDtoToCity(cityRequestDto);
        City savedCity = cityRepository.save(cityToSave);
        return Mapper.mapCityToCityResponseDto(savedCity);
    }

    public List<CityResponseDto> getAllCities() {
        return cityRepository.findAll().stream()
                .map(Mapper::mapCityToCityResponseDto)
                .toList();
    }

    public CityResponseDto getCity(Long cityId) {
        City city = findCityById(cityId);
        return Mapper.mapCityToCityResponseDto(city);
    }

    public CityResponseDto deleteCity(Long cityId) {
        City cityToDelete = findCityById(cityId);
        cityRepository.deleteById(cityToDelete.getId());
        return Mapper.mapCityToCityResponseDto(cityToDelete);
    }

    @Transactional
    public CityResponseDto editCity(Long cityId, CityRequestDto cityRequestDto) {
        City cityToEdit = findCityById(cityId);
        cityToEdit.setName(cityRequestDto.getName());
        return Mapper.mapCityToCityResponseDto(cityToEdit);
    }

    private City findCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(CityNotFoundException::new);
    }
}
