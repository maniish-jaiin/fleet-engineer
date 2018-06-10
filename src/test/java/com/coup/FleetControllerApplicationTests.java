package com.coup;

import com.coup.controller.FleetController;
import com.coup.model.ScooterRequest;
import com.coup.services.FleetServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FleetControllerApplicationTests {

    @InjectMocks
    private FleetController fleetController;

    @Mock
    private FleetServiceImpl fleetServiceImpl;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnMinimumNoOfFE() {
        ScooterRequest scooterRequest = new ScooterRequest();
        scooterRequest.setMaintainedByManagers(9);
        scooterRequest.setMaintainedByEngineers(5);
        List<Integer> scooterInDistricts = Arrays.asList(11, 15, 13);
        scooterRequest.setScootersInDistrict(scooterInDistricts);

        when(fleetServiceImpl.getNumberOfFleetEngineers(scooterRequest)).thenReturn(7);

        int minimumNoOfFE = fleetController.getMinimumNoOfFE(scooterRequest);

        Assert.assertEquals(7, minimumNoOfFE);
    }

}
