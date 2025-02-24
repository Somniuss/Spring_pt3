package org.srebnaje.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("data", "Hello from MyService!");
        return "home"; // Имя HTML-файла (home.html) без пути и расширения
    }
}
