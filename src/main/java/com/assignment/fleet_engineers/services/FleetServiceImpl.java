package com.assignment.fleet_engineers.services;

import com.assignment.fleet_engineers.model.ScooterSpec;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FleetServiceImpl implements FleetService {

    private int maintainedByEngineers;

    public FleetServiceImpl() {
    }

    @Override
    public int getNumberOfFleetEngineers(ScooterSpec scooterSpec) {
        int max = Integer.MIN_VALUE;
        int districtIndexForFM = 0;
        int totalFE = 0;
        int diff;
        int maintainedByManagers = scooterSpec.getMaintainedByManagers();
        maintainedByEngineers = scooterSpec.getMaintainedByEngineers();
        List<Integer> scootersInDistrict = new ArrayList<>(scooterSpec.getScootersInDistrict());

        for (int i = 0; i < scootersInDistrict.size(); i++) {
            Integer scooters = scootersInDistrict.get(i);
            totalFE += numberOfFEPerDistrict(scooters);
            diff = numberOfFEPerDistrict(scooters)
                    - numberOfFEPerDistrict((scooters - maintainedByManagers));
            if (max < diff) {
                max = diff;
                districtIndexForFM = i;
            }
        }

        return totalFE - numberOfFEPerDistrict(scootersInDistrict.get(districtIndexForFM))
                + numberOfFEPerDistrict(scootersInDistrict.get(districtIndexForFM)
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
