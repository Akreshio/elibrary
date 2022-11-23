package akreshio.elibrary.dao;

import akreshio.elibrary.dao.entity.PublicationEntity;
import java.util.List;

public interface PublicationRepository {

    List <PublicationEntity> get();
    List <PublicationEntity> get(Long id);
    List <PublicationEntity> get(PublicationEntity publication);

    boolean add(PublicationEntity publication);
    boolean delete(PublicationEntity publication);
}
