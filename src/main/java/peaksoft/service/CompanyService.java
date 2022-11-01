package peaksoft.service;

import peaksoft.entity.Car;
import peaksoft.entity.Company;

import java.util.List;

public interface CompanyService {
    void saveCompany(Company company);

    Company getCompanyById(Long id);

    Company getAllCompanies();

    void removeById(Long id);

    void creatTable();

    Car updateCompany(Long id, Company company);
}
