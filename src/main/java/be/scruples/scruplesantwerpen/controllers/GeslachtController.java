package be.scruples.scruplesantwerpen.controllers;


import be.scruples.scruplesantwerpen.domain.Geslacht;
import be.scruples.scruplesantwerpen.services.GeslachtService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("geslachten")
class GeslachtController {
    private final GeslachtService geslachtService;

    GeslachtController(GeslachtService geslachtService) {
        this.geslachtService = geslachtService;
    }

    @GetMapping
    public ModelAndView geslachten() {
        return new ModelAndView("geslachten")
                .addObject("vindAlleGeslachten", geslachtService.findAll())
                .addObject(new Geslacht(0, ""));
    }
//toevoegen FORM
    @PostMapping
    public String toevoegen(@Valid Geslacht geslacht, Errors errors) {
        if(errors.hasErrors()) {
            return "geslachten";
        }
        geslachtService.create(geslacht);
        return "redirect:/geslachten";
    }

//verwijderen FORM
    @PostMapping("verwijderen")
    public String delete(Optional<Long[]> id) {
        id.ifPresent(ids -> geslachtService.delete(ids));
        return "redirect:/geslachten";
    }

}
