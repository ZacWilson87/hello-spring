package org.launchcode.hellospring.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller

@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name, Model model) {
//        String theGreeting = "Hello, " + name + "!";
//        model.addAttribute("greeting", theGreeting);
//       return "hello";
//    }

    // Handles requests of the form /hello/LaunchCode
    //@GetMapping("{name}")
    //public String helloWithPathParam(@PathVariable String name) {
   //     return "Hello, " + name + "!";
    //}

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @RequestMapping
    public String createMessage(@RequestParam String name, @RequestParam String language, Model model){
        String greeting;

        if (language.equals("English")){
            model.addAttribute(greeting = "Hello, "+ name +"!");
        }else if(language.equals("German")){
            model.addAttribute(greeting = "Tag, "+ name +"!");
        }else if(language.equals("Spanish")){
            model.addAttribute(greeting = "Bueno, "+ name +"!");
        }else if(language.equals("Italian")){
            model.addAttribute(greeting = "Bonjourno, "+ name +"!");
        }else{
            model.addAttribute(greeting = "Bonjour, "+ name +"!");
        }
        model.addAttribute(greeting);
        model.addAttribute(name);
        model.addAttribute(language);
        return "form";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
            names.add("Zac");
            names.add("Katie");
            names.add("Aubri");
            names.add("Luna");
    model.addAttribute("names", names);
        return "hello-list";
    }
}