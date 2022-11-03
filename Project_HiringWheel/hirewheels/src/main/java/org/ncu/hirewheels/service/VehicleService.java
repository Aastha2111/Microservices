package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entites.Vehicle;

public interface VehicleService {

    List<Vehicle> getAllVechicles();

    List<Vehicle> getAllAvailableVehicles();

}
