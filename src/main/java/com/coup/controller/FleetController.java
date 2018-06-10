package com.coup.controller;

import com.coup.model.ScooterRequest;
import com.coup.model.ScooterResponse;
import com.coup.services.FleetServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FleetController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FleetServiceImpl fleetServiceImpl;

    @PostMapping(value = "/fleetEngineers")
    public ResponseEntity getMinimumNoOfFE(@RequestBody ScooterRequest scooterRequest) {
        logger.info("Post request received: ", scooterRequest.toString());
        ScooterResponse scooterResponse = new ScooterResponse();
        scooterResponse.setFleetEngineer(fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest));
        return new ResponseEntity(scooterResponse, HttpStatus.OK);
    }
}