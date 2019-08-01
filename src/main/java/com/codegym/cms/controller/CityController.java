package com.codegym.cms.controller;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Country;
import com.codegym.cms.service.CityService;
import com.codegym.cms.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    @ModelAttribute("countries")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }
    @GetMapping("/cities")
    public ModelAndView ListCity(){
        Iterable<City> cities = cityService.findALl();
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities",cities);
        return modelAndView;
    }
    @GetMapping("/create-city")
    public ModelAndView formCreate(){
        ModelAndView  modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }
    @PostMapping("/create-city")
    public ModelAndView createCity(@ModelAttribute("city")City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }
    @GetMapping("/edit-city/{id}")
    public ModelAndView formEdit(@PathVariable Long id){
        City city = cityService.findById(id);
      if(city!=null){
          ModelAndView modelAndView = new ModelAndView("/city/edit");
          modelAndView.addObject("city",city);
          return modelAndView;
      }
      else {
          ModelAndView modelAndView = new ModelAndView("/error");
          return modelAndView;
      }
    }
    @PostMapping("edit-city{id}")
    public ModelAndView Upgrades(@ModelAttribute("city")City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city",city);
        return modelAndView;
    }
    @GetMapping("delete-city/{id}")
    public ModelAndView formDelete(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city!=null){
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city",city);
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }
    @PostMapping("delete-city")
    public String Delete(@ModelAttribute("city")City city){
        cityService.remove(city.getId());
        return "redirect:cities";
    }
    @GetMapping("/view-city/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        if (city == null) {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/city/view");
            modelAndView.addObject("city", city);
            return modelAndView;
        }





    }
}
