package net.ncu.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ncu.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
