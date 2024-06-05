package com.madejsky.project.Controllers;

import com.madejsky.project.Services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainEntityController {

    @Autowired
    EntityService service;

    @RequestMapping(path="/")
        public String homePage(Model model){
        return "Home";
    }
    @RequestMapping(path="/app")
        public String appPage(Model model){
            return "App";
    }
    @RequestMapping(path="/about")
        public String aboutPage(Model model){
            return "About";
    }

}
