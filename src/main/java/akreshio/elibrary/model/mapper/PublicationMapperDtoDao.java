package akreshio.elibrary.model.mapper;

import akreshio.elibrary.dao.entity.PublicationEntity;
import akreshio.elibrary.model.Publication;
import org.springframework.stereotype.Component;

@Component
public class PublicationMapperDtoDao {

    public Publication toDto(PublicationEntity edition) {
        return new Publication(
                edition.getName(),
                edition.getIsbn(),
                edition.getAuthor(),
                edition.getType(),
                edition.getPage(),
                edition.getCount(),
                edition.getPublisher()
        );
    }

    public PublicationEntity toDao(Publication publication) {
        return new PublicationEntity (
                publication.getName(),
                publication.getIsbn(),
                publication.getAuthor(),
                publication.getType(),
                publication.getPage(),
                publication.getCount(),
                publication.getPublisher()
        );
    }
}
