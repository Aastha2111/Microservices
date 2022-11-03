package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entites.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;



@Repository
public interface VehicleRespository extends JpaRepository<Vehicle, Long> {
    
    @Query("select p from Vehicle p where p.vehicleAvailability = 1")
    public List<Vehicle> getAllAvailableVehicles();
    
}
