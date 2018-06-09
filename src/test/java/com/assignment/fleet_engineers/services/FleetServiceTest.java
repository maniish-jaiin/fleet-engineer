package com.assignment.fleet_engineers.services;

import com.assignment.fleet_engineers.model.ScooterSpec;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class FleetServiceTest {

    private FleetServiceImpl fleetServiceImpl;
    private ScooterSpec scooterSpec;

    @Before
    public void setUp() {
        fleetServiceImpl = new FleetServiceImpl();
        scooterSpec = new ScooterSpec();
    }

    @Test
    public void shouldGetZeroWhenZeroScootersInDistrict() {
        scooterSpec.setMaintainedByEngineers(5);
        scooterSpec.setMaintainedByManagers(12);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(0);
        scooterInDistricts.add(0);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(0, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWithoutManagers() {
        scooterSpec.setMaintainedByManagers(12);
        scooterSpec.setMaintainedByEngineers(5);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(15);
        scooterInDistricts.add(10);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(3, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWithoutManagersIn() {
        scooterSpec.setMaintainedByManagers(9);
        scooterSpec.setMaintainedByEngineers(5);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(11);
        scooterInDistricts.add(15);
        scooterInDistricts.add(13);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(7, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWithCustomInput() {
        scooterSpec.setMaintainedByManagers(11);
        scooterSpec.setMaintainedByEngineers(7);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(23);
        scooterInDistricts.add(17);
        scooterInDistricts.add(9);
        scooterInDistricts.add(35);
        scooterInDistricts.add(72);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(23, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWhenManagerMaintainedScootersAreEqualToScootersInCity() {
        scooterSpec.setMaintainedByManagers(100);
        scooterSpec.setMaintainedByEngineers(3);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(100);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(0, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWhenManagerCapacityIsHigherThenSomeAvailableScootersInAnyCity() {
        scooterSpec.setMaintainedByManagers(75);
        scooterSpec.setMaintainedByEngineers(7);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(76); // 11 //// 1
        scooterInDistricts.add(23); // 4 // 4
        scooterInDistricts.add(17); // 3 // 3
        scooterInDistricts.add(9); // 2 // 2
        scooterInDistricts.add(35);  // 5 // 5
        scooterInDistricts.add(72); // // 0 // 11
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(25, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWhenManagerCapacityIsHigherThenAllAvailableScootersInAnyCity() {
        scooterSpec.setMaintainedByManagers(75);
        scooterSpec.setMaintainedByEngineers(7);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(77); // // 1  // 11 // 11
        scooterInDistricts.add(76); // 11  // 11 // 12
        scooterInDistricts.add(78); // 12  // 12 // 12
        scooterInDistricts.add(79); // 12  // 12 // 12
        scooterInDistricts.add(80); // 12  // 12 // // 1
        scooterInDistricts.add(83); // 12 // // 2 // 12
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(59, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWhenCapacityAndNumberOfScootersArePrimes() {
        scooterSpec.setMaintainedByManagers(17);
        scooterSpec.setMaintainedByEngineers(11);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(3); // 1
        scooterInDistricts.add(139); // 13
        scooterInDistricts.add(37); // // 2
        scooterInDistricts.add(73); // 7
        scooterInDistricts.add(7); // 1
        scooterInDistricts.add(109); // 10
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(34, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }
}