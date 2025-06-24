package com.scheduler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/schedule-demo")
    public String showSchedulerForm(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "schedule-demo";
    }
}

