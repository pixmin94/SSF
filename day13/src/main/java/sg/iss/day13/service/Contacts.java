package sg.iss.day13.service;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sg.iss.day13.model.Contact;

@Service
public class Contacts {
    public void save(Contact contact, Model model, String dataDir) {
        String fileName = contact.getId();
        PrintWriter printWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(dataDir+"/"+fileName+".txt");
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(contact.getName());
            printWriter.println(contact.getEmail());
            model.addAttribute("contact", new Contact(contact.getId(), contact.getName(), contact.getEmail()));
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}