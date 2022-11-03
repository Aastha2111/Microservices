package org.ncu.hirewheels.repository;

import java.util.List;

import org.ncu.hirewheels.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository

//@Respository   //already internal provided by Spring data JPA ()
//Simple JPA repository provide @Repository  & @Tansactional(readOnly =True) to make JPA_Repository methods Transactional

public interface UserRespository extends JpaRepository<User, Long> {

  
    
    @Query(value = "SELECT * FROM Users u WHERE LOWER(u.firstName) = LOWER(:firstName)", nativeQuery = true)
    public List<User> findByFirstName(@Param("firstName") String firstName);
    
    @Query(value = "SELECT * FROM Users u WHERE  LOWER(u.firstName) = LOWER(:firstName) OR LOWER(u.lastName) = LOWER(:lastName)", nativeQuery = true)
    public List<User> findByAnyName(@Param("firstName") String firstName, @Param("lastName") String lastName);
    
    // @Query(value = "SELECT * FROM Users u WHERE  LOWER(u.email) = LOWER(:email)", nativeQuery = true)
    @Query(value = "SELECT * FROM Users u WHERE  u.email = ?1", nativeQuery = true)
    public User findByEmail(@Param("email") String email);
    
    @Query(value = "SELECT * FROM Users u WHERE  u.mob = :mob", nativeQuery = true)
    public List<User> findByMobNo(@Param("mob") String mob);

}
