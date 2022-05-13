package com.livescore.app.service;

import com.livescore.app.elenamodel.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {


    @Autowired
    ApiService apiService;


    public List<CountryResponse> getCountries(){

        List<CountryResponse> countryList = apiService.getCountries().getData();

        return countryList;
    }
}
