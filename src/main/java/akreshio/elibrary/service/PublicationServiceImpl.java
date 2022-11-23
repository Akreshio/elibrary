package akreshio.elibrary.service;

import akreshio.elibrary.model.mapper.PublicationMapperDtoDao;
import akreshio.elibrary.service.dao.PublicationRepositoryService;
import akreshio.elibrary.dao.entity.PublicationEntity;
import akreshio.elibrary.model.Publication;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PublicationServiceImpl implements PublicationService {

    PublicationRepositoryService daoService;
    PublicationMapperDtoDao mapper;

    @Override
    public List<Publication> get() {
        List<Publication> list = new ArrayList<>();
        for (PublicationEntity entity: daoService.get()) {
            list.add(mapper.toDto(entity));
        }
        return list;
    }

    @Override
    public List<Publication> get(Publication publication) {
        List<Publication> list = new ArrayList<>();
        for (PublicationEntity entity: daoService.get(mapper.toDao(publication))) {
            list.add(mapper.toDto(entity));
        }
        return list;
    }

    @Override
    public boolean add(Publication publication) {
        return daoService.add(mapper.toDao(publication));
    }

    @Override
    public boolean remove(Publication publication) {
        return daoService.delete(mapper.toDao(publication));
    }

    @Override
    public boolean update(Publication publicationOld, Publication publicationNew) {
        return daoService.update(
                mapper.toDao(publicationOld),
                mapper.toDao(publicationNew)
        );
    }
}
