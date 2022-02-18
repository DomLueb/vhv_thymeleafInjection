package de.lmis.vhv.thymeleafinjection.controller;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
    @PostMapping("/greeting")
    public String acceptGreeting(@RequestParam("name") String name, @RequestParam("duties") String duties, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
