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
        maintainedByEngineers = scooterSpec.getMaintainedByEngineers();
        int maintainedByManagers = scooterSpec.getMaintainedByManagers();
        List<Integer> scootersInDistrict = new ArrayList<>(scooterSpec.getScootersInDistrict());
        int number = 0;
        for (int i = 0; i < scootersInDistrict.size(); i++) {
            int diff;
            Integer scooters = scootersInDistrict.get(i);
            number += numberOfFEPerDistrict(scooters);
            diff = numberOfFEPerDistrict(scooters)
                    - numberOfFEPerDistrict((scooters - maintainedByManagers));
            if (max < diff) {
                max = diff;
                districtIndexForFM = i;
            }
        }

        Integer scooters = scooterSpec.getScootersInDistrict().get(districtIndexForFM);
        return number - numberOfFEPerDistrict(scooters) +
                numberOfFEPerDistrict(scooters - maintainedByManagers);

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
