package com.example.arch.joboffer;

import com.example.arch.company.Company;
import com.example.arch.company.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class JobOfferDtoMapper {
    private final CompanyRepository companyRepository;

    public JobOfferDtoMapper(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    JobOfferDto map(JobOffer jobOffer) {
        JobOfferDto dto = new JobOfferDto();
        dto.setId(jobOffer.getId());
        dto.setTitle(jobOffer.getTitle());
        dto.setDescription(jobOffer.getDescription());
        dto.setRequirements(jobOffer.getRequirements());
        dto.setDuties(jobOffer.getDuties());
        dto.setLocation(jobOffer.getLocation());
        dto.setMinSalary(jobOffer.getMinSalary());
        dto.setMaxSalary(jobOffer.getMaxSalary());
        dto.setDateAdded(jobOffer.getDateAdded());
        dto.setCompanyId(jobOffer.getCompany().getId());
        dto.setCompanyName(jobOffer.getCompany().getName());
        return dto;
    }

    JobOffer map(JobOfferDto dto) {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setId(dto.getId());
        jobOffer.setTitle(dto.getTitle());
        jobOffer.setDescription(dto.getDescription());
        jobOffer.setRequirements(dto.getRequirements());
        jobOffer.setDuties(dto.getDuties());
        jobOffer.setLocation(dto.getLocation());
        jobOffer.setMinSalary(dto.getMinSalary());
        jobOffer.setMaxSalary(dto.getMaxSalary());
        jobOffer.setDateAdded(dto.getDateAdded());
        Company company = companyRepository.findById(dto.getCompanyId()).orElseThrow();
        jobOffer.setCompany(company);
        return jobOffer;
    }
}
