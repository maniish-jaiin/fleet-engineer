package com.coup.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ScooterRequest {

    @JsonProperty("P")
    private int maintainedByEngineers;

    @JsonProperty("C")
    private int maintainedByManagers;

    @JsonProperty("scooters")
    private List<Integer> scootersInDistrict = new ArrayList<>();

    public int getMaintainedByEngineers() {
        return maintainedByEngineers;
    }

    public void setMaintainedByEngineers(int maintainedByEngineers) {
        this.maintainedByEngineers = maintainedByEngineers;
    }

    public int getMaintainedByManagers() {
        return maintainedByManagers;
    }

    public void setMaintainedByManagers(int maintainedByManagers) {
        this.maintainedByManagers = maintainedByManagers;
    }

    public List<Integer> getScootersInDistrict() {
        return scootersInDistrict;
    }

    public void setScootersInDistrict(List<Integer> scootersInDistrict) {
        this.scootersInDistrict = scootersInDistrict;
    }

    @Override
    public String toString() {
        return "ScooterRequest{" +
                "maintainedByEngineers=" + maintainedByEngineers +
                ", maintainedByManagers=" + maintainedByManagers +
                ", scootersInDistrict=" + scootersInDistrict +
                '}';
    }
}
