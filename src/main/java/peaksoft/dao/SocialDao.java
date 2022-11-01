package peaksoft.dao;

import peaksoft.entity.Social;

import java.util.List;

public interface SocialDao {
    void saveSocial(Social social);

    Social getSocialById(Long id);

   List<Social> getAllSocials();

    void removeById(Long id);

    void creatTable();

    Social updateSocial(Long id,Social social);
}
