package com.saheed.JobApp.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    Boolean updateCompany(Long id, Company updatedCompany);
}
