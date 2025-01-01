package com.saheed.JobApp.company.Implementaion;

import com.saheed.JobApp.company.Company;
import com.saheed.JobApp.company.CompanyRepository;
import com.saheed.JobApp.company.CompanyService;
import com.saheed.JobApp.jobs.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyImplementation implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {

        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();
            companyToUpdate.setCompanyName(company.getCompanyName());
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setJobs(company.getJobs());
            companyRepository.save(companyToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);

    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }else
            return false;
        }

    @Override
    public Company getCompanyById(Long id) {
            return companyRepository.findById(id).orElse(null);
        }
    }






