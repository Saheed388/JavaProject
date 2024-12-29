package com.saheed.JobApp.company.Implementaion;

import com.saheed.JobApp.company.Company;
import com.saheed.JobApp.company.CompanyRepository;
import com.saheed.JobApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyImplementation implements CompanyService {
    CompanyRepository companyRepository;

    public CompanyImplementation(CompanyRepository companyRepository){
        this.companyRepository =companyRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);

    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try{
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);
            if(companyOptional.isPresent()) {
                Company company = companyOptional.get();
                company.setCompanyName(updatedCompany.getCompanyName());
                company.setCompanyAddress(updatedCompany.getCompanyAddress());
                company.setCountry(updatedCompany.getCountry());
                company.setState(updatedCompany.getState());
                company.setEmail(updatedCompany.getEmail());
                company.setPhoneNumber(updatedCompany.getPhoneNumber());
                company.setWebsiteUrl(updatedCompany.getWebsiteUrl());
                companyRepository.save(company);
                return true;
            }return false;
            }
    }

