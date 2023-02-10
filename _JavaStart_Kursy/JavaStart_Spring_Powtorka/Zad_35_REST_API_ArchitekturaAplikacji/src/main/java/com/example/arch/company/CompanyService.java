package com.example.arch.company;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final CompanyJobOfferMapper companyJobOfferMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper, CompanyJobOfferMapper companyJobOfferMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
        this.companyJobOfferMapper = companyJobOfferMapper;
    }

    Optional<CompanyDto> getCompanyById(Long id) {
        return companyRepository.findById(id)
                .map(companyMapper::map);
    }

    List<CompanyJobOfferDto> getJobOffersByCompanyId(Long companyId) {
        return companyRepository.findById(companyId)
                .map(Company::getJobOffers)
                .orElse(Collections.emptyList())
                .stream()
                .map(companyJobOfferMapper::map)
                .toList();
    }

    CompanyDto saveCompany(CompanyDto companyDto) {
        Company company = companyMapper.map(companyDto);
        Company savedCompany = companyRepository.save(company);
        return companyMapper.map(savedCompany);
    }

    Optional<CompanyDto> replaceCompany(Long companyId, CompanyDto companyDto) {
        if (!companyRepository.existsById(companyId)) {
            return Optional.empty();
        }
        companyDto.setId(companyId);
        Company companyToUpdate = companyMapper.map(companyDto);
        Company updatedCompany = companyRepository.save(companyToUpdate);
        return Optional.of(companyMapper.map(updatedCompany));
    }
}
