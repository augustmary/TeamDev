package ua.dev.team.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HelperController {
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String viewAboutPage(Model model) {
        return "about";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String viewContactsPage(Model model) {
        return "contacts";
    }
}
