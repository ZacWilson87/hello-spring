package org.launchcode.hellospring.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
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
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
   // @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    //public String helloWithQueryParam(@RequestParam String name) {
       // return "Hello, " + name + "!";
    //}

    // Handles requests of the form /hello/LaunchCode
    //@GetMapping("{name}")
    //public String helloWithPathParam(@PathVariable String name) {
   //     return "Hello, " + name + "!";
    //}

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='language'>" +
                "<option>English</option>" +
                "<option>German</option>" +
                "<option>Spanish</option>" +
                "<option>Italian</option>" +
                "<option>French</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping
    public String createMessage(@RequestParam String name, @RequestParam String language){
        String greeting;
        if (language.equals("English")){
            greeting = "Hello, ";
        }else if(language.equals("German")){
            greeting = "Tag, ";
        }else if(language.equals("Spanish")){
            greeting = "Bueno, ";
        }else if(language.equals("Italian")){
            greeting = "Bonjourno, ";
        }else{
            greeting = "Bonjour, ";
        }
        return greeting + name +"!";
    }
}