package de.lmis.vhv.thymeleafinjection.controller;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @PostMapping("/greeting")
    public String acceptGreeting(@RequestParam("name") String name, @RequestParam("duties") String duties, Model model) {
        var emphasizedDuties = this.emphasizeVhvText(duties);
        String safeDuties = Jsoup.clean(emphasizedDuties, Safelist.basic());
        model.addAttribute("name", name);
        model.addAttribute("duties", safeDuties);
        return "greeting";
    }

    private String emphasizeVhvText(String baseText) {
        return baseText.replace("VHV","<strong>VHV</strong>");
    }

}
