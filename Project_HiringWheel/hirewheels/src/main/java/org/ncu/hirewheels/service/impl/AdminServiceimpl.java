package org.ncu.hirewheels.service.impl;

import org.ncu.hirewheels.entites.Vehicle;
import org.ncu.hirewheels.repository.VehicleRespository;
import org.ncu.hirewheels.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceimpl implements AdminService {

    private VehicleRespository vehicleRespository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        Vehicle savedVehicle = vehicleRespository.save(vehicle);
        return savedVehicle;
    }

    @Override
    public Vehicle updateAvailabilityStatus(Vehicle vehicle, long vehicleID) {
        Vehicle ezistingvehicle = vehicleRespository.findById(vehicleID)
                .orElseThrow(() -> new RuntimeException("Vehicle not found "));
        ezistingvehicle.setAvailabilityStatus(vehicle.getAvailabilityStatus());
        vehicleRespository.save(ezistingvehicle);
        return ezistingvehicle;
    }

}
