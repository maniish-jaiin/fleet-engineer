package com.assignment.fleet_engineers.controller;

import com.assignment.fleet_engineers.model.ScooterSpec;
import com.assignment.fleet_engineers.services.FleetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class FleetController {

    private Logger logger = Logger.getLogger("FleetController");

    @Autowired
    FleetServiceImpl fleetServiceImpl;

    @PostMapping(value = "/fleetEngineers")
    public int storeScooterData(@RequestBody ScooterSpec scooterSpec) {
        logger.info("Post request received: " + scooterSpec.toString());
        return fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec);
    }
}