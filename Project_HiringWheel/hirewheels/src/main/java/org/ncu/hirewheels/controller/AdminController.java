package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entites.Vehicle;
import org.ncu.hirewheels.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/Vehicles")
public class AdminController {

    private AdminService adminService;

    @PostMapping()
    public ResponseEntity<Vehicle> saveTeacher(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<Vehicle>(adminService.addVehicle(vehicle), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Vehicle> updateTeacher(@PathVariable("id") long id, @RequestBody Vehicle vehicle) {
        return new ResponseEntity<Vehicle>(adminService.updateAvailabilityStatus(vehicle, id), HttpStatus.OK);
    }

}
