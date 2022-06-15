package com.livescore.app.elenaservices;

import com.livescore.app.elenamodel.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {


    @Autowired
    ApiService apiService;

    /**
     * This service calls on the api and generates a list of countries
     * @return list of countryResponses
     */
    public List<CountryResponse> getCountries(){

        List<CountryResponse> countryList = apiService.getCountries().getData();

        return countryList;
    }
}
