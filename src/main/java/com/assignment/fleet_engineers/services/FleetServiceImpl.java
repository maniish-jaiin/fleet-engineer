package com.assignment.fleet_engineers.services;

import com.assignment.fleet_engineers.model.ScooterSpec;
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
    public int getNumberOfFleetEngineers(ScooterSpec scooterSpec) {
        int max = Integer.MIN_VALUE;
        int targetDistrictForFM = 0;
        int totalFE = 0;
        int diff;
        maintainedByManagers = scooterSpec.getMaintainedByManagers();
        maintainedByEngineers = scooterSpec.getMaintainedByEngineers();
        List<Integer> scootersInDistrict = new ArrayList<>(scooterSpec.getScootersInDistrict());

        for (int i = 0; i < scootersInDistrict.size(); i++) {
            Integer scooters = scootersInDistrict.get(i);
            totalFE += numberOfFEPerDistrict(scooters);
            diff = numberOfFEPerDistrict(scooters)
                    - numberOfFEPerDistrict((scooters - maintainedByManagers));
            if (max < diff) {
                max = diff;
                targetDistrictForFM = i;
            }
        }

        return totalFE - numberOfFEPerDistrict(scootersInDistrict.get(targetDistrictForFM))
                + numberOfFEPerDistrict(scootersInDistrict.get(targetDistrictForFM)
                - maintainedByManagers);
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
