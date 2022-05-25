package com.livescore.app.service;

import com.livescore.app.elenamodel.VenueData;
import com.livescore.app.elenamodel.VenueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {

    @Autowired
    ApiService apiService;


    public VenueResponse getVenueById(Integer id){


        return apiService.getVenueById(id).getData().get(0);
    }


}
