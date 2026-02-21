package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.springboot_module.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s join fetch s.group")
    List<Student> findAllWithGroup();
}
