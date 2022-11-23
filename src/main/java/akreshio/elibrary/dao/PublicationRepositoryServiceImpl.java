package akreshio.elibrary.dao;

import akreshio.elibrary.dao.entity.*;
import akreshio.elibrary.service.dao.PublicationRepositoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class PublicationRepositoryServiceImpl implements PublicationRepositoryService {

    PublicationRepository publicationDao;

    @Override
    public List<PublicationEntity> get() {
        return publicationDao.get();
    }

    @Override
    public List<PublicationEntity> get(PublicationEntity publication) {
        return publicationDao.get(publication);
    }

    @Override
    public boolean add(PublicationEntity publication) {
        return publicationDao.add(publication);
    }

    @Override
    public boolean delete(PublicationEntity publication) {
        return publicationDao.delete(publication);
    }

    @Override
    public boolean update(PublicationEntity publicationOld, PublicationEntity publicationNew) {
        publicationDao.delete(publicationOld);
        publicationDao.add(publicationNew);
        return true;
    }

}
