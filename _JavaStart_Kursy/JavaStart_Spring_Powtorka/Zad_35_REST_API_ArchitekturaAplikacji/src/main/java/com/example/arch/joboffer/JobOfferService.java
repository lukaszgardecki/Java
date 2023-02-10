package com.example.arch.joboffer;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
class JobOfferService {
    private final JobOfferRepository jobOfferRepository;
    private final JobOfferMapper jobOfferMapper;

    public JobOfferService(JobOfferRepository jobOfferRepository, JobOfferMapper jobOfferMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.jobOfferMapper = jobOfferMapper;
    }

    Optional<JobOfferDto> getOfferById(Long id) {
        return jobOfferRepository.findById(id)
                .map(jobOfferMapper::map);
    }

    JobOfferDto saveOffer(JobOfferDto jobOfferDto) {
        JobOffer jobOfferToSave = jobOfferMapper.map(jobOfferDto);
        jobOfferToSave.setDateAdded(LocalDateTime.now());
        JobOffer savedJobOffer = jobOfferRepository.save(jobOfferToSave);
        return jobOfferMapper.map(savedJobOffer);
    }

    void updateOffer(JobOfferDto jobOfferDto) {
        JobOffer jobOffer = jobOfferMapper.map(jobOfferDto);
        jobOfferRepository.save(jobOffer);
    }
}
