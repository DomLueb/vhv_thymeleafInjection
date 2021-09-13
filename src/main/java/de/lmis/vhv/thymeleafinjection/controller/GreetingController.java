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
    public String acceptGreeting(@RequestParam("name") String name, Model model) {
        String safe = Jsoup.clean(name, Safelist.basic());
        model.addAttribute("name", safe);
        return "greeting";
    }

    @GetMapping("/greeting")
    public String getGreeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
