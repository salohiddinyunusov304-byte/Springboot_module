package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.payload.StudentCreator;
import uz.pdp.springboot_module.payload.StudentResponse;
import uz.pdp.springboot_module.service.StudentService;
import uz.pdp.springboot_module.utils.Constants;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(StudentController.BASE_URL)
public class StudentController {
    public static final String BASE_URL = Constants.BASE_URL + "/students";
    private final StudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse create(@RequestBody StudentCreator creator) {
        return studentService.create(creator);
    }

    @GetMapping("/findAll")
    public List<StudentResponse> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/findById/{id}")
    public StudentResponse findById(@PathVariable Integer id) {
        return studentService.findById(id);
    }

    @PutMapping("/update")
    public StudentResponse update(
            @RequestBody StudentCreator creator
    ) {
        return studentService.update(creator);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
    }
}
