package com.coup.controller;

import com.coup.model.ScooterRequest;
import com.coup.services.FleetServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FleetController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FleetServiceImpl fleetServiceImpl;

    @PostMapping(value = "/fleetEngineers")
    public int getMinimumNoOfFE(@RequestBody ScooterRequest scooterRequest) {
        logger.info("Post request received: ", scooterRequest.toString());
        return fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest);
    }
}