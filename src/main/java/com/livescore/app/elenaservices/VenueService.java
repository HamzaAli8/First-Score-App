package com.livescore.app.elenaservices;

import com.livescore.app.elenamodel.VenueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {

    @Autowired
    ApiService apiService;

    /**
     *This method returns the venue in which the fixture is being played
     * @param id unique id of venue
     * @return VenueResponse
     */
    public VenueResponse getVenueById(Integer id){

        return apiService.getVenueById(id).getData().get(0);
    }


}
