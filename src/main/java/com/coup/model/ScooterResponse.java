package com.coup.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScooterResponse {

    @JsonProperty("fleet_engineers")
    int fleetEngineer;

    public int getFleetEngineer() {
        return fleetEngineer;
    }

    public void setFleetEngineer(int fleetEngineer) {
        this.fleetEngineer = fleetEngineer;
    }
}
