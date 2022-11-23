package akreshio.elibrary.service.dao;

import akreshio.elibrary.dao.entity.PublicationEntity;
import java.util.List;

public interface PublicationRepositoryService {

    List<PublicationEntity> get();
    List<PublicationEntity> get(PublicationEntity publication);
    boolean add(PublicationEntity publication);
    boolean delete(PublicationEntity publication);
    boolean update(PublicationEntity publicationOld, PublicationEntity publicationNew);

}
