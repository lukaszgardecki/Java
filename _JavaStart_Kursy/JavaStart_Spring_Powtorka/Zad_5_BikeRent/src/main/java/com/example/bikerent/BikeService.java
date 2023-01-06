package com.example.bikerent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Transactional
    public void add(BikeDto dto) {
        Bike bike = new Bike(
                dto.getId(),
                dto.getModel(),
                dto.getSerialNo(),
                dto.getHourPrice(),
                dto.getDayPrice()
        );
        bikeRepository.save(bike);
    }

    @Transactional
    public void deleteById(Long id) {
        bikeRepository.deleteById(id);
    }

    @Transactional
    public double rentForHours(String serialNo, int hours, String borrowerId) {
        LocalDateTime dateOfReturn = LocalDateTime.now().plusHours(hours);
        double hourPrice = updateBike(serialNo, dateOfReturn, borrowerId).getHourPrice();
        return hourPrice * hours;
    }

    @Transactional
    public double rentForDay(String serialNo, String borrowerId) {
        LocalDateTime dateOfReturn = LocalDateTime.now().withHour(23).withMinute(59);
        return updateBike(serialNo, dateOfReturn, borrowerId).getDayPrice();
    }

    @Transactional
    public void returnBike(String serialNo) {
        updateBike(serialNo, null, null);
    }

    private Bike updateBike(String serialNo, LocalDateTime dateOfReturn, String borrowerId) {
        Bike bike = bikeRepository
                .findBySerialNoIgnoreCase(serialNo)
                .orElseThrow(BikeNotFoundException::new);
        bike.setDateOfReturn(dateOfReturn);
        bike.setBorrowerId(borrowerId);
        return bike;
    }

    public List<BikeDto> findAllAvailableBikes() {
        return bikeRepository.findAllByBorrowerIdIsNullOrderByDayPrice()
                .stream().map(bike -> new BikeDto(
                        bike.getId(),
                        bike.getModel(),
                        bike.getSerialNo(),
                        bike.getHourPrice(),
                        bike.getDayPrice()
                )).toList();
    }

    public int countBorrowedBikes() {
        return bikeRepository.countAllByBorrowerIdIsNotNull();
    }
}
