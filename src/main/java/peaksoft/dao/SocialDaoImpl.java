package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.Config;
import peaksoft.entity.Social;

import java.util.List;

public class SocialDaoImpl implements SocialDao {

    SessionFactory sessionFactory = Config.getSessionFactory();

    @Override
    public void saveSocial(Social social) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(social);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Social getSocialById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Social social = session.find(Social.class, id);
        session.getTransaction().commit();
        session.close();
        return social;
    }

    @Override
    public List<Social> getAllSocials() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<Social> list = session.createQuery("select s from  Social  s ").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Social social = session.find(Social.class, id);
        session.remove(social);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void creatTable() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.createNativeQuery("create table socials (id bigserial not null, socialMedia varchar(255), primary key (id))");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Social updateSocial(Long id, Social social) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Social social1 = session.find(Social.class, id);
        social1.setSocialMedia(social.getSocialMedia());
        session.merge(social1);
        session.getTransaction().commit();
        session.close();
        return social1;
    }
}
