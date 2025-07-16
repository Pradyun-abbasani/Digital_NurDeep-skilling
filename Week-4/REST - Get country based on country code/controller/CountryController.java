package com.cognizant.springlearn1.controller;
 

import com.cognizant.springlearn1.model.Country;
import com.cognizant.springlearn1.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (List<Country>) context.getBean("countryList");
        Country india = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase("IN"))
                .findFirst()
                .orElse(null);
        LOGGER.info("END - getCountryIndia()");
        return india;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START - getCountry(): {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END - getCountry()");
        return country;
    }
}
