package com.example.arch.joboffer;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class JobOfferService {
    private JobOfferRepository jobOfferRepository;
    private JobOfferDtoMapper jobOfferDtoMapper;

    public JobOfferService(JobOfferRepository jobOfferRepository, JobOfferDtoMapper jobOfferDtoMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.jobOfferDtoMapper = jobOfferDtoMapper;
    }

    Optional<JobOfferDto> getOfferById(Long id) {
        return jobOfferRepository.findById(id)
                .map(jobOfferDtoMapper::map);
    }

    JobOfferDto saveOffer(JobOfferDto jobOfferDto) {
        JobOffer jobOfferToSave = jobOfferDtoMapper.map(jobOfferDto);
        jobOfferToSave.setDateAdded(LocalDateTime.now());
        JobOffer savedJobOffer = jobOfferRepository.save(jobOfferToSave);
        return jobOfferDtoMapper.map(savedJobOffer);
    }

    void updateOffer(JobOfferDto jobOfferDto) {
        JobOffer jobOffer = jobOfferDtoMapper.map(jobOfferDto);
        jobOfferRepository.save(jobOffer);
    }

    void deleteOffer(Long id) {
        jobOfferRepository.deleteById(id);
    }
}
