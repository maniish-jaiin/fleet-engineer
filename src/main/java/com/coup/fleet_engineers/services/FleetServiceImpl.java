package com.coup.fleet_engineers.services;

import com.coup.fleet_engineers.model.ScooterRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FleetServiceImpl implements FleetService {

    private int maintainedByEngineers;
    private int maintainedByManagers;

    public FleetServiceImpl() {
    }

    @Override
    public int getNumberOfFleetEngineers(ScooterRequest scooterRequest) {
        int targetDistrictForFM;
        int minimumNoOfFE = 0;
        maintainedByManagers = scooterRequest.getMaintainedByManagers();
        maintainedByEngineers = scooterRequest.getMaintainedByEngineers();
        List<Integer> scootersInDistrict = new ArrayList<>(scooterRequest.getScootersInDistrict());

        targetDistrictForFM = findDistrictForFM(scootersInDistrict);
        int remainingScootersWithFMInDistrict = scootersInDistrict.get(targetDistrictForFM) - maintainedByManagers;
        scootersInDistrict.set(targetDistrictForFM, remainingScootersWithFMInDistrict);

        for (Integer scooters : scootersInDistrict) {
            minimumNoOfFE += numberOfFEPerDistrict(scooters);
        }

        return minimumNoOfFE;
    }

    private int findDistrictForFM(List<Integer> scootersInDistrict) {
        int max = Integer.MIN_VALUE;
        int targetDistrictForFM = 0;
        int diff;

        for (int i = 0; i < scootersInDistrict.size(); i++) {
            Integer scooters = scootersInDistrict.get(i);
            int noOfFEWithFM = numberOfFEPerDistrict((scooters - maintainedByManagers));
            int noOfFEWithoutFM = numberOfFEPerDistrict(scooters);
            diff = noOfFEWithoutFM
                    - noOfFEWithFM;
            if (max < diff) {
                max = diff;
                targetDistrictForFM = i;
            }
        }
        return targetDistrictForFM;
    }

    private int numberOfFEPerDistrict(int scooters) {
        if (scooters > 0) {
            if (scooters % maintainedByEngineers == 0) {
                return scooters / maintainedByEngineers;
            } else {
                return (scooters / maintainedByEngineers) + 1;
            }
        } else {
            return 0;
        }
    }
}
