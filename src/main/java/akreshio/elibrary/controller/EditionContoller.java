package akreshio.elibrary.controller;

import akreshio.elibrary.model.Publication;
import akreshio.elibrary.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/edition")
@Validated
public class EditionContoller {

    @Autowired
    PublicationService editionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publication> get(@RequestParam (value = "isbn", required = false) String isbn) {
            if (isbn!=null) {
                Publication publication = new Publication();
                publication.setIsbn(isbn);
                return editionService.get(publication);
            }
        return  editionService.get();
    }

    @PutMapping
    public ResponseEntity<Void> add(@Valid @RequestBody Publication publication, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        editionService.add(publication);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Void> update(@RequestBody List<Publication> publications) {
        if (publications.size()==2){
            editionService.update(publications.get(0), publications.get(1));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Publication publication) {
        editionService.remove(publication);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}

