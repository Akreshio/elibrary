package akreshio.elibrary.service;

import akreshio.elibrary.model.Publication;
import java.util.List;

public interface PublicationService {

    List<Publication> get ();
    List<Publication> get (Publication publication);
    boolean add (Publication publication);
    boolean remove (Publication publication);
    boolean update (Publication publicationOld, Publication publicationNew);
}
