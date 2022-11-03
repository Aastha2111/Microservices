package org.ncu.hirewheels.service;

import org.ncu.hirewheels.entites.Vehicle;

public interface AdminService {

    public Vehicle addVehicle(Vehicle vehicle);

    public Vehicle updateAvailabilityStatus(Vehicle vehicle, long id);
}