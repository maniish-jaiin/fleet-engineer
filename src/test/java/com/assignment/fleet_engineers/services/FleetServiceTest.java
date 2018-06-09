package com.assignment.fleet_engineers.services;

import com.assignment.fleet_engineers.model.ScooterSpec;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Integer> scooterInDistricts = Arrays.asList(0, 0);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(0, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersSampleData1() {
        scooterSpec.setMaintainedByManagers(12);
        scooterSpec.setMaintainedByEngineers(5);
        List<Integer> scooterInDistricts = Arrays.asList(15, 10);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(3, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersSampleData2() {
        scooterSpec.setMaintainedByManagers(9);
        scooterSpec.setMaintainedByEngineers(5);
        List<Integer> scooterInDistricts = Arrays.asList(11, 15, 13);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(7, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersWithSmallerInputs() {
        scooterSpec.setMaintainedByManagers(11);
        scooterSpec.setMaintainedByEngineers(7);
        List<Integer> scooterInDistricts = Arrays.asList(23, 17, 9, 35, 72);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(23, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersWhenManagerMaintainedScootersAreEqualToScootersInCity() {
        scooterSpec.setMaintainedByManagers(100);
        scooterSpec.setMaintainedByEngineers(3);
        List<Integer> scooterInDistricts = Collections.singletonList(100);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(0, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersWhenManagerCapacityIsHigherThanSomeAvailableScootersInAnyCity() {
        scooterSpec.setMaintainedByManagers(75);
        scooterSpec.setMaintainedByEngineers(7);
        List<Integer> scooterInDistricts = Arrays.asList(76, 23, 17, 9, 35, 72);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(25, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersWhenManagerCapacityIsHigherThanAllAvailableScootersInAnyCity() {
        scooterSpec.setMaintainedByManagers(75);
        scooterSpec.setMaintainedByEngineers(7);
        List<Integer> scooterInDistricts = Arrays.asList(76, 77, 78, 79, 80, 83);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(59, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersWhenCapacityAndNumberOfScootersArePrimes() {
        scooterSpec.setMaintainedByManagers(17);
        scooterSpec.setMaintainedByEngineers(11);
        List<Integer> scooterInDistricts = Arrays.asList(3, 139, 37, 73, 7, 109);
        scooterSpec.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(34, fleetServiceImpl.getNumberOfFleetEngineers(scooterSpec));
    }
}