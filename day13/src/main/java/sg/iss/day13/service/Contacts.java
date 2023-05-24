package sg.iss.day13.service;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void getAllContactInURI(Model model, String dataDir) {
        Set<String> dataFiles = listFiles(dataDir);
        Set<String> modFiles = new HashSet<>();
        for(String file : dataFiles){
            String modFile = file.replace(".txt","");
            modFiles.add(modFile);
        }
        model.addAttribute("contacts", modFiles.toArray(new String[dataFiles.size()]));
    }

    private Set<String> listFiles(String dataDir) {
        return Stream.of(new File(dataDir).listFiles())
            .filter(file -> !file.isDirectory())
            .map(File :: getName)
            .collect(Collectors.toSet());
     }
}