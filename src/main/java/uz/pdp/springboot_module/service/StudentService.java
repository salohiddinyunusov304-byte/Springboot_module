package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.payload.StudentCreator;
import uz.pdp.springboot_module.payload.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse create(StudentCreator creator);

    List<StudentResponse> findAll();

    StudentResponse findById(Integer id);

    void deleteStudentById(Integer id);

    StudentResponse update(StudentCreator creator, Integer id);
}
