package sg.iss.day13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import sg.iss.day13.model.Contact;
import sg.iss.day13.service.Contacts;

@Controller
@RequestMapping(path="/")
public class ContactController {
    @Autowired
    Contacts service;

    @Value("${data.dir}")
    private String dataDir;
    
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @PostMapping(consumes="application/x-www-form-urlencoded", path="/contact")
    public String saveForm(@Valid Contact contact, BindingResult binding, Model model) {
        if(binding.hasErrors()) {
            return "form";
        }
        service.save(contact, model, dataDir);
        model.addAttribute("successMessage", "Contact saved successfully, with status code: " + HttpStatus.CREATED);
        return "showContact";
    }

}
