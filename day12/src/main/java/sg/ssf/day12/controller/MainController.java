package sg.ssf.day12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;
import sg.ssf.day12.model.Image;
import sg.ssf.day12.service.RandomNumberService;

@Controller
public class MainController {

    @Autowired
    RandomNumberService service;

    @GetMapping("/home")
    public String landingPage(){
        return "home";
    }

    @GetMapping("/get")
    public String generateRandomNumbers(Model model, HttpServletRequest request) {
        int number = Integer.parseInt(request.getParameter("number"));
        
        System.out.println("Input no is: " + number);

        if (number < 1 || number > 30){
            String errorMessage = "Invalid number";
            model.addAttribute("errorMessage", errorMessage);
            return "home";
        }

        List<Integer> randomNumbers = service.generateRandomNumbers(number);

        List<Image> imageList = new ArrayList<Image>();

        for (int randomNumber : randomNumbers) {
            imageList.add(new Image(Integer.toString(randomNumber), "/images/"+Integer.toString(randomNumber)+".png"));
        }
        System.out.println("image list :" + imageList);

        model.addAttribute(imageList);

        return "display";
    }
    
}