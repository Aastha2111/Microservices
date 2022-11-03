package org.ncu.hirewheels.service.impl;

import java.util.List;


import org.ncu.hirewheels.entites.Vehicle;
import org.ncu.hirewheels.repository.VehicleRespository;
import org.ncu.hirewheels.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRespository vehicleRespository;

    public VehicleServiceImpl(VehicleRespository vehicleRespository) {
        this.vehicleRespository = vehicleRespository;
    }

    @Override
    public List<Vehicle> getAllVechicles() {
        return vehicleRespository.findAll();
    }

    @Override
    public List<Vehicle> getAllAvailableVehicles() {
        return vehicleRespository.getAllAvailableVehicles();
    }

}
