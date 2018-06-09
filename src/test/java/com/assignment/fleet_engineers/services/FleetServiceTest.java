package com.assignment.fleet_engineers.services;

import com.assignment.fleet_engineers.model.Scooter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class FleetServiceTest {

    private FleetServiceImpl fleetServiceImpl;
    private Scooter scooter;

    @Before
    public void setUp() {
        fleetServiceImpl = new FleetServiceImpl();
        scooter = new Scooter();
    }

    @Test
    public void shouldGetZeroWhenZeroScootersInDistrict() {
        scooter.setMaintainedByEngineers(5);
        scooter.setMaintainedByManagers(12);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(0);
        scooterInDistricts.add(0);
        scooter.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(0, fleetServiceImpl.getNumberOfFleetEngineers(scooter));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWithoutManagers() {
        scooter.setMaintainedByManagers(12);
        scooter.setMaintainedByEngineers(5);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(15);
        scooterInDistricts.add(10);
        scooter.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(3, fleetServiceImpl.getNumberOfFleetEngineers(scooter));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWithoutManagersIn() {
        scooter.setMaintainedByManagers(9);
        scooter.setMaintainedByEngineers(5);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(11);
        scooterInDistricts.add(15);
        scooterInDistricts.add(13);
        scooter.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(7, fleetServiceImpl.getNumberOfFleetEngineers(scooter));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWithCustomInput() {
        scooter.setMaintainedByManagers(11);
        scooter.setMaintainedByEngineers(7);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(23);
        scooterInDistricts.add(17);
        scooterInDistricts.add(9);
        scooterInDistricts.add(35);
        scooterInDistricts.add(72);
        scooter.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(23, fleetServiceImpl.getNumberOfFleetEngineers(scooter));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWhenManagerMaintainedScootersAreEqualToScootersInCity() {
        scooter.setMaintainedByManagers(100);
        scooter.setMaintainedByEngineers(3);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(100);
        scooter.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(0, fleetServiceImpl.getNumberOfFleetEngineers(scooter));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWhenManagerCapacityIsHigherThenSomeAvailableScootersInAnyCity() {
        scooter.setMaintainedByManagers(75);
        scooter.setMaintainedByEngineers(7);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(76); // 11
        scooterInDistricts.add(23); // 4
        scooterInDistricts.add(17); // 3
        scooterInDistricts.add(9); // 2
        scooterInDistricts.add(35);  // 5
        scooterInDistricts.add(72); // // 0
        scooter.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(25, fleetServiceImpl.getNumberOfFleetEngineers(scooter));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWhenManagerCapacityIsHigherThenAllAvailableScootersInAnyCity() {
        scooter.setMaintainedByManagers(75);
        scooter.setMaintainedByEngineers(7);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(77);
        scooterInDistricts.add(76);
        scooterInDistricts.add(78);
        scooterInDistricts.add(79);
        scooterInDistricts.add(80);
        scooterInDistricts.add(83);
        scooter.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(59, fleetServiceImpl.getNumberOfFleetEngineers(scooter));
    }

    @Test
    public void shouldgetNumberOfFleetEngineersWhenCapacityAndNumberOfScootersArePrimes() {
        scooter.setMaintainedByManagers(17);
        scooter.setMaintainedByEngineers(11);
        ArrayList<Integer> scooterInDistricts = new ArrayList<>();
        scooterInDistricts.add(3); // 1
        scooterInDistricts.add(139); // 13
        scooterInDistricts.add(37); // // 2
        scooterInDistricts.add(73); // 7
        scooterInDistricts.add(7); // 1
        scooterInDistricts.add(109); // 10
        scooter.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(34, fleetServiceImpl.getNumberOfFleetEngineers(scooter));
    }


}