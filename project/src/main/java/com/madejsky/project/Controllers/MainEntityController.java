package com.madejsky.project.Controllers;

import com.madejsky.project.Exceptions.RecordNotFoundException;
import com.madejsky.project.Models.Expense;
import com.madejsky.project.Services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
            model.addAttribute("expense", new Expense());
        return "App";
    }
    @RequestMapping(path="/about")
        public String aboutPage(Model model){
            return "About";
    }

    @RequestMapping(path = "/addExpense", method= RequestMethod.POST)
    public String addExpense(Expense expense){
        service.addExpense(expense);
        return "redirect:/app";
    }

    @RequestMapping(path = "/report")
    public String report(Model model) {
            List<Expense> reportList = service.getAll();

            model.addAttribute("expense", reportList);
            return "/report";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Expense expense) throws RecordNotFoundException {
        service.deleteExpenseById(id);
        return "redirect:/report";
    }

}
