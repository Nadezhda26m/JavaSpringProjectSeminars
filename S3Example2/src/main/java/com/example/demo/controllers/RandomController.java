package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RandomController {

    // 1. http://localhost:8080/random
    @GetMapping("/random")
    public String getRandomNumber(Model model) {
        Random random = new Random();
        model.addAttribute("number", random.nextInt(1, 101));
        return "random";
    }

    // 2. http://localhost:8080/random/20/28
    @GetMapping("/random/{min}/{max}")
    public String getRandomNumberFromPath(@PathVariable("min") int min,
                                          @PathVariable("max") int max,
                                          Model model) {
        Random random = new Random();
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", random.nextInt(min, max + 1));
        return "randomPath";
    }

    // 3. http://localhost:8080/new-random?min=1&max=45
    @GetMapping("/new-random")
    public String getRandom(@RequestParam("min") Integer min,
                            @RequestParam("max") Integer max,
                            Model model) {
        Random random = new Random();
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", random.nextInt(min, max + 1));
        return "randomPath";
    }

    // 4. http://localhost:8080/new-random/15/12345
    /**
     * Параметр из файла application.properties, если его нет, то по умолчанию 25.
     */
    @Value("${data.random.param.min:25}")
    private Integer minDefault;

    @Value("${data.random.param.max:100}")
    private Integer maxDefault;

    @GetMapping("/new-random/{min}/{max}")
    public String getRandomNumberValue(@PathVariable("min") int min,
                                       @PathVariable("max") int max,
                                       Model model) {
        Random random = new Random();
        model.addAttribute("min", min);
        model.addAttribute("max", max);

        model.addAttribute("min_default", minDefault);
        model.addAttribute("max_default", maxDefault);

        model.addAttribute("number", random.nextInt(min, max + 1));
        return "randomDefault";
    }

}
