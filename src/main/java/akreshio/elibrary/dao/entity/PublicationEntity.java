package akreshio.elibrary.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publication")
@Getter
@Setter
public class PublicationEntity {

    public PublicationEntity(String name, String isbn, String author, String type, int page, int count, String publisher) {
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.type = type;
        this.page = page;
        this.count = count;
        this.publisher = publisher;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "page", nullable = false)
    private int page;

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "publisher", nullable = false)
    private String publisher;

}
