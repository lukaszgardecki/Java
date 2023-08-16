package com.example.jparelacje2.domain.zipcode;

import com.example.jparelacje2.Mapper;
import com.example.jparelacje2.domain.city.City;
import com.example.jparelacje2.domain.city.CityRepository;
import com.example.jparelacje2.exception.CityNotFoundException;
import com.example.jparelacje2.exception.ZipcodeNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZipcodeService {
    private final ZipcodeRepository zipcodeRepository;
    private final CityRepository cityRepository;

    @Transactional
    public ZipcodeResponseDto addZipcode(ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcodeToSave = Mapper.mapZipcodeRequestDtoToZipcode(zipcodeRequestDto);

        if (zipcodeRequestDto.getCityId() != null) {
            City cityToSet = findCityById(zipcodeRequestDto.getCityId());
            zipcodeToSave.setCity(cityToSet);
        }
        Zipcode savedZipcode = zipcodeRepository.save(zipcodeToSave);
        return Mapper.mapZipcodeToZipcodeResponseDto(savedZipcode);
    }

    public List<ZipcodeResponseDto> getAllZipcodes() {
        return zipcodeRepository.findAll().stream()
                .map(Mapper::mapZipcodeToZipcodeResponseDto)
                .toList();
    }

    public ZipcodeResponseDto getZipcode(Long zipcodeId) {
        Zipcode zipcode = findZipcodeById(zipcodeId);
        return Mapper.mapZipcodeToZipcodeResponseDto(zipcode);
    }

    public ZipcodeResponseDto deleteZipcode(Long zipcodeId) {
        ZipcodeResponseDto zipcodeToDelete = getZipcode(zipcodeId);
        zipcodeRepository.deleteById(zipcodeToDelete.getId());
        return zipcodeToDelete;
    }

    @Transactional
    public ZipcodeResponseDto editZipcode(Long zipcodeId, ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcodeToUpdate = findZipcodeById(zipcodeId);
        zipcodeToUpdate.setName(zipcodeRequestDto.getName());

        if (zipcodeRequestDto.getCityId() != null) {
            City cityToSet = findCityById(zipcodeRequestDto.getCityId());
            zipcodeToUpdate.setCity(cityToSet);
        }
        return Mapper.mapZipcodeToZipcodeResponseDto(zipcodeToUpdate);
    }

    @Transactional
    public ZipcodeResponseDto addCityToZipcode(Long zipcodeId, Long cityId) {
        Zipcode zipcode = findZipcodeById(zipcodeId);

        if (zipcode.getCity().getId() != null) {
            throw new IllegalStateException("Zipcode already has a city.");
        }
        City city = findCityById(cityId);
        zipcode.setCity(city);
        return Mapper.mapZipcodeToZipcodeResponseDto(zipcode);
    }

    @Transactional
    public ZipcodeResponseDto removeCityFromZipcode(Long zipcodeId) {
        Zipcode zipcode = findZipcodeById(zipcodeId);

        if (zipcode.getCity().getId() == null) {
            throw new IllegalStateException("Zipcode does not have a city.");
        }
        zipcode.setCity(null);
        return Mapper.mapZipcodeToZipcodeResponseDto(zipcode);
    }

    private Zipcode findZipcodeById(Long zipcodeId) {
        return zipcodeRepository.findById(zipcodeId)
                .orElseThrow(ZipcodeNotFoundException::new);
    }

    private City findCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(CityNotFoundException::new);
    }
}
