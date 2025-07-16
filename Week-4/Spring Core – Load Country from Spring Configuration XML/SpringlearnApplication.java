package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class SpringlearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringlearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringlearnApplication.class, args);
        displayCountries();
        LOGGER.info("END");
    }

    public static void displayCountries() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        CountryList countryList = context.getBean("countryList", CountryList.class);
        LOGGER.debug("Country List : {}", countryList.getCountryList());
    }

}
