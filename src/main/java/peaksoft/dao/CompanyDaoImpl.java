package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.Config;
import peaksoft.entity.Car;
import peaksoft.entity.Company;

import java.util.List;

public class CompanyDaoImpl implements CompanyDao{
    SessionFactory sessionFactory = Config.getSessionFactory();
    @Override
    public void saveCompany(Company company) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(company);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Company getCompanyById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
         Company  company = (Company) session.createQuery("select c from  Company c where c.id = :id").setParameter("id", id);
        session.getTransaction().commit();
        session.close();
        return company;
    }

    @Override
    public List<Company> getAllCompanies() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<Company> companies =session.createQuery("select c from Company c").list();
        session.getTransaction().commit();
        session.close();
        return companies;
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Company company = session.find(Company.class, id);
        session.remove(company);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void creatTable() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.createNativeQuery("create table companies (id bigserial not null, companyName varchar(255), location varchar(255), primary key (id))");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Car updateCompany(Long id, Company company) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Company company1 = session.find(Company.class, id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocation(company.getLocation());
        session.merge(company1);
        session.getTransaction().commit();
        session.close();
        return null;
    }
}
