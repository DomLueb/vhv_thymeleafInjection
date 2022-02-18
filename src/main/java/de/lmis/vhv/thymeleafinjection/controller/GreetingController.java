package de.lmis.vhv.thymeleafinjection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @PostMapping("/greeting")
    public String acceptGreeting(@RequestParam("name") String name, @RequestParam("duties") String duties, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
