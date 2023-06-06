package sg.iss.day13.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sg.iss.day13.model.Contact;
import sg.iss.day13.repository.ContactsRedis;




@Controller
@RequestMapping(path = "/")
public class RedisController {
   
    @Autowired
    ContactsRedis repository;
   
    //request method to load landing page
    @GetMapping
    public String showAddressBook(Model model){
        model.addAttribute("contact", new Contact());
        return "form";
    }

    ///to save the contact information
    @PostMapping( consumes ="application/x-www-form-urlencoded", path=  "/contact")
    public String saveAddressBook(@ModelAttribute @Valid Contact contact, BindingResult bindingResult,Model model){ 
        if(bindingResult.hasErrors()){
        return "form";  
        }
            repository.saveContact(contact, model);
            model.addAttribute("successMessage", "Contact saved successfully, with status code: " +HttpStatus.CREATED +".");
        return "showContact";
    }

   @GetMapping("/contact/{contactId}")
    public String getContactById(Model model, @PathVariable String contactId) {
       Contact contact =  new Contact();
       contact = repository.getContactById(contactId);
        if (contact == null) {
            model.addAttribute("errorMessage", "Contact not found");
            return "error";
        }
        model.addAttribute("contact", contact);
        return "showContact";
    }

    @GetMapping(path = "/list")
    public String getAllContacts(Model model) {
       List<Contact> contacts = repository.getAllContacts();
       model.addAttribute("contacts", contacts);
       return "contacts";
    }
   
}