package com.livescore.app.service;

import com.livescore.app.model.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {


    @Autowired
    ApiService apiService;


    public CountryResponse getCountry(Integer id){


        return apiService.getCountry(id).getData().get(0);
    }
}
