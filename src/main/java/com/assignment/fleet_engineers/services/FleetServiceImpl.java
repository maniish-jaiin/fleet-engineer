package com.assignment.fleet_engineers.services;

import com.assignment.fleet_engineers.model.Scooter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FleetServiceImpl implements FleetService {
    public FleetServiceImpl() {
    }


    private int getTotalNumberOfFE(int maintainedByEngineers, List<Integer> numberInDistrict) {
        int numberOfFE;
        int totalNumberOfFE = 0;
        for (Integer scootersInDistrict : numberInDistrict) {
            if (scootersInDistrict % maintainedByEngineers == 0) {
                numberOfFE = scootersInDistrict / maintainedByEngineers;
            } else {
                numberOfFE = (scootersInDistrict / maintainedByEngineers) + 1;
            }
            totalNumberOfFE += numberOfFE;
        }
        return totalNumberOfFE;
    }

    public int getNumberOfFleetEngineers(Scooter scooter) {
        int totalNumberOfFE;
        int min = 9999;
        int maintainedByEngineers = scooter.getMaintainedByEngineers();
        int maintainedByManager = scooter.getMaintainedByManagers();

        for (int i = 0; i < scooter.getScootersInDistrict().size(); i++) {
            List<Integer> numberInDistrict = new ArrayList<>(scooter.getScootersInDistrict());
            int element = numberInDistrict.get(i) - maintainedByManager;
            if (element < 0)
                numberInDistrict.set(i, 0);
            else
                numberInDistrict.set(i, element);
            totalNumberOfFE = getTotalNumberOfFE(maintainedByEngineers, numberInDistrict);
            if (min > totalNumberOfFE) {
                min = totalNumberOfFE;
            }
        }
        return min;
    }
}
