package com.coup.services;

import com.coup.model.ScooterRequest;
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
    private ScooterRequest scooterRequest;

    @Before
    public void setUp() {
        fleetServiceImpl = new FleetServiceImpl();
        scooterRequest = new ScooterRequest();
    }

    @Test
    public void shouldGetZeroWhenZeroScootersInDistrict() {
        scooterRequest.setMaintainedByEngineers(5);
        scooterRequest.setMaintainedByManagers(12);
        List<Integer> scooterInDistricts = Arrays.asList(0, 0);
        scooterRequest.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(0, fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersSampleData1() {
        scooterRequest.setMaintainedByManagers(12);
        scooterRequest.setMaintainedByEngineers(5);
        List<Integer> scooterInDistricts = Arrays.asList(15, 10);
        scooterRequest.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(3, fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersSampleData2() {
        scooterRequest.setMaintainedByManagers(9);
        scooterRequest.setMaintainedByEngineers(5);
        List<Integer> scooterInDistricts = Arrays.asList(11, 15, 13);
        scooterRequest.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(7, fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersWithSmallerInputs() {
        scooterRequest.setMaintainedByManagers(11);
        scooterRequest.setMaintainedByEngineers(7);
        List<Integer> scooterInDistricts = Arrays.asList(23, 17, 9, 35, 72);
        scooterRequest.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(23, fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersWhenManagerMaintainedScootersAreEqualToScootersInCity() {
        scooterRequest.setMaintainedByManagers(100);
        scooterRequest.setMaintainedByEngineers(3);
        List<Integer> scooterInDistricts = Collections.singletonList(100);
        scooterRequest.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(0, fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersWhenManagerCapacityIsHigherThanSomeAvailableScootersInAnyCity() {
        scooterRequest.setMaintainedByManagers(75);
        scooterRequest.setMaintainedByEngineers(7);
        List<Integer> scooterInDistricts = Arrays.asList(76, 23, 17, 9, 35, 72);
        scooterRequest.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(25, fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersWhenManagerCapacityIsHigherThanAllAvailableScootersInAnyCity() {
        scooterRequest.setMaintainedByManagers(75);
        scooterRequest.setMaintainedByEngineers(7);
        List<Integer> scooterInDistricts = Arrays.asList(76, 77, 78, 79, 80, 83);
        scooterRequest.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(59, fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest));
    }

    @Test
    public void shouldGetNumberOfFleetEngineersWhenCapacityAndNumberOfScootersArePrimes() {
        scooterRequest.setMaintainedByManagers(17);
        scooterRequest.setMaintainedByEngineers(11);
        List<Integer> scooterInDistricts = Arrays.asList(3, 139, 37, 73, 7, 109);
        scooterRequest.setScootersInDistrict(scooterInDistricts);

        Assert.assertEquals(34, fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest));
    }
}