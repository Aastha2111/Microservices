package org.ncu.hirewheels.repository;


import org.ncu.hirewheels.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where r.role_id = ?1")
    public Role getRoleById(Integer role_id);
}
