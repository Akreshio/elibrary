package akreshio.elibrary.controller;

import akreshio.elibrary.service.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    PublicationServiceImpl editionService;
        @GetMapping("/publication")
        public String userList(Model model) {
            model.addAttribute("allPublication", editionService.get());
            return "publication";
        }
}
