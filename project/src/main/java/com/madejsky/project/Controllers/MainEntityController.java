package com.madejsky.project.Controllers;

import com.madejsky.project.Services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainEntityController {

    @Autowired
    EntityService service;



}
