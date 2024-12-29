package com.saheed.JobApp.company.Implementaion;

import com.saheed.JobApp.company.Company;
import com.saheed.JobApp.company.CompanyRepository;
import com.saheed.JobApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyImplementation implements CompanyService {
    CompanyRepository companyRepository;

    public CompanyImplementation(CompanyRepository companyRepository){
        this.companyRepository =companyRepository;
    }
    @Override
    public List<Company> findAll() {
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
}
