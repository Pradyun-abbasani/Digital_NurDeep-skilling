package com.cognizant.springlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountryList {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryList.class);

    private List<Country> countryList;

    public List<Country> getCountryList() {
        LOGGER.debug("Inside getCountryList");
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        LOGGER.debug("Inside setCountryList");
        this.countryList = countryList;
    }
}
