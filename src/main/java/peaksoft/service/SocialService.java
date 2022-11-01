package peaksoft.service;

import peaksoft.entity.Social;

import java.util.List;

public interface SocialService {
    void saveSocial(Social social);

    Social getSocialById(Long id);

    Social getAllSocials();

    void removeById(Long id);

    void creatTable();

    Social updateSocial(Long id,Social social);
}
