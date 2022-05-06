package com.livescore.app.service;

import com.livescore.app.model.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {


    @Autowired
    ApiService apiService;


    public List<CountryResponse> getCountries(){

        List<CountryResponse> countryList = apiService.getCountries().getData();

        return countryList;
    }
}
