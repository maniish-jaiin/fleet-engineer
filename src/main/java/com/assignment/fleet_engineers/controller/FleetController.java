package com.assignment.fleet_engineers.controller;

import com.assignment.fleet_engineers.model.ScooterSpec;
import com.assignment.fleet_engineers.services.FleetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class FleetController {

    Logger logger = Logger.getLogger("FleetController");
    @Autowired
    FleetServiceImpl fleetServiceImpl;
    private ScooterSpec scooterSpec;

    @GetMapping(value = "/fleetEngineers", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getNoOfFleetEngineer() {
        return fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec);
    }

    @PostMapping(value = "/fleetEngineers")
    public String storeScooterData(@RequestBody ScooterSpec scooterSpec) {
        this.scooterSpec = scooterSpec;
        logger.info("Request received: " + scooterSpec.toString());
        return "Data Stored";
    }
}