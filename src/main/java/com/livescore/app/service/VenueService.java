package com.livescore.app.service;

import com.livescore.app.elenamodel.VenueData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {

    @Autowired
    ApiService apiService;


    public VenueData getVenueById(Integer id, String expand){


        return apiService.getVenueById(id, expand);

    }


}
