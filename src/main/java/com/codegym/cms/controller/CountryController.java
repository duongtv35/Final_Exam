package com.codegym.cms.controller;

import com.codegym.cms.model.Country;
import com.codegym.cms.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping("/countries")
    public ModelAndView ListCoutries(){
        Iterable<Country> countries = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/country/list");
        modelAndView.addObject("countries",countries);
        return modelAndView;
    }
}
