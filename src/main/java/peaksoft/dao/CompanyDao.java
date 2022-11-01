package peaksoft.dao;

import peaksoft.entity.Car;
import peaksoft.entity.Company;

import java.util.List;

public interface CompanyDao {
    void saveCompany(Company company);

    Company getCompanyById(Long id);

   List<Company> getAllCompanies();

    void removeById(Long id);

    void creatTable();

    Car updateCompany(Long id,Company company);
}
