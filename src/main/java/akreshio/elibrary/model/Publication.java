package akreshio.elibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Publication {

    private String name;

    private String isbn;

    private String author;

    private String type;

    private int page;

    private int count;

    private String publisher;


}
