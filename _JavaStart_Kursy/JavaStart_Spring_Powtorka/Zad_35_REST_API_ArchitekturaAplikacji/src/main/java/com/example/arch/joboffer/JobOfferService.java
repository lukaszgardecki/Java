package com.example.arch.joboffer;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobOfferService {
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
}
