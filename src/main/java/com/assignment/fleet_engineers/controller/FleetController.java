package com.assignment.fleet_engineers.controller;

import com.assignment.fleet_engineers.model.Scooter;
import com.assignment.fleet_engineers.services.FleetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FleetController {

    @Autowired
    FleetServiceImpl fleetServiceImpl;

    @GetMapping(value = "/fleetEngineers", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getNoOfFleetEngineer() {
        return 0;
    }

    @PostMapping(value = "/fleetEngineers")
    public int storeScooterData(@RequestBody Scooter scooter) {
        return fleetServiceImpl.getNumberOfFleetEngineers(scooter);
    }
}