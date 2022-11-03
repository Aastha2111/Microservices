package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entites.Vehicle;
import org.ncu.hirewheels.service.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Vehicles")
public class VechicleController {

    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAllVechiles() {
        return vehicleService.getAllVechicles();
    }

    @GetMapping
    public List<Vehicle> getAllAvailableVehicles() {
        return vehicleService.getAllAvailableVehicles();
    }

}
