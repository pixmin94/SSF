package sg.iss.day13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import sg.iss.day13.model.Contact;

@Controller
@RequestMapping(path="/")
public class ContactController {
    
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }
}
