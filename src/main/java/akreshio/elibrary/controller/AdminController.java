package akreshio.elibrary.controller;

import akreshio.elibrary.model.Publication;
import akreshio.elibrary.service.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    PublicationServiceImpl editionService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allPublication", editionService.get());
        return "admin";
    }

    @RequestMapping("/add")
    public String newForm(Map<String, Object> model) {
        Publication publication = new Publication();
        model.put("publication", publication);
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("publication") Publication publication) {
        editionService.add(publication);
        return "redirect:/admin";
    }

    @PostMapping("/admin/delete")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) String name,
                              @RequestParam(required = true, defaultValue = "" ) String isbn,
                              @RequestParam(required = true, defaultValue = "" ) String author,
                              @RequestParam(required = true, defaultValue = "" ) String publisher,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            Publication publication = new Publication();
            publication.setName(name);
            publication.setIsbn(isbn);
            publication.setAuthor(author);
            publication.setPublisher(publisher);
            editionService.remove(publication);
        }
        return "redirect:/admin";
    }
}
