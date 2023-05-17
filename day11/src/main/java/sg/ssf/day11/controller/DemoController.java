package sg.ssf.day11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class DemoController {

    // @GetMapping("/home")
    // public HelloWorld getHome(){
    //     return new HelloWorld("Hello World");
    // }

    @GetMapping("/home/{name}")
    public HelloWorld getHome2(@PathVariable String name){
        return new HelloWorld(name);
    }

    @GetMapping("/home")
    public HelloWorld getHome3(@RequestParam String name){
        return new HelloWorld(name);
    }

}
