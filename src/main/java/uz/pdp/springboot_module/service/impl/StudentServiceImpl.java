package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.Group;
import uz.pdp.springboot_module.entity.Student;
import uz.pdp.springboot_module.payload.StudentCreator;
import uz.pdp.springboot_module.payload.StudentResponse;
import uz.pdp.springboot_module.repository.GroupRepository;
import uz.pdp.springboot_module.repository.StudentRepository;
import uz.pdp.springboot_module.service.StudentService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public StudentResponse create(StudentCreator creator) {

        Group group = groupRepository.findById(creator.groupId())
                .orElseThrow(() -> new RuntimeException("Group not found"));

        Student student = Student.builder()
                .group(group)
                .firstName(creator.firstName())
                .lastName(creator.lastName())
                .birthYear(creator.birthYear())
                .build();

        studentRepository.saveAndFlush(student);

        return new StudentResponse(
                student.getId(),
                student.getGroup(),
                student.getFirstName(),
                student.getLastName(),
                student.getBirthYear()
        );
    }

    @Override
    public List<StudentResponse> findAll() {
        List<Student> students = studentRepository.findAllWithGroup();
        return students.stream()
                .map(student -> new StudentResponse(
                        student.getId(),
                        student.getGroup(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getBirthYear()
                )).toList();
    }

    @Override
    public StudentResponse findById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return new StudentResponse(
                    student.getId(),
                    student.getGroup(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getBirthYear()
            );
        } else {
            return null;
        }
    }

    @Override
    public StudentResponse update(StudentCreator creator, Integer id) {
        Group group = groupRepository.findById(creator.groupId())
                .orElseThrow(() -> new RuntimeException("Group not found"));


        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setGroup(group);
        student.setFirstName(creator.firstName());
        student.setLastName(creator.lastName());
        student.setBirthYear(creator.birthYear());

        Student save = studentRepository.save(student);

        return new StudentResponse(
                save.getId(),
                save.getGroup(),
                save.getFirstName(),
                save.getLastName(),
                save.getBirthYear()
        );
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

}
