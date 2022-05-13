package com.livescore.app.service;

import com.livescore.app.elenamodel.PlayerDetailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerDetailService {

    @Autowired
    ApiService apiService;


    public PlayerDetailData getPlayerBySeasonId(Integer id, String expand){

        return apiService.getPlayerDetailBySeasonId(id,expand);
    }
}
