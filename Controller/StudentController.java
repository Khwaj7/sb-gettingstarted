package fr.khj.gettingstarted.Controller;

import fr.khj.gettingstarted.Errors.StudentNotFoundException;
import fr.khj.gettingstarted.model.StudentEntity;
import fr.khj.gettingstarted.repository.StudentRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    List<StudentEntity> all() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    StudentEntity findById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/students/{id}")
    StudentEntity update(@PathVariable Long id, @RequestBody StudentEntity studentToSave) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentToSave.getName());
                    student.setRole(studentToSave.getRole());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> studentRepository.save(studentToSave));
    }

    @PostMapping("/students")
    StudentEntity save(@RequestBody StudentEntity studentToSave) {
        return studentRepository.save(studentToSave);
    }

    @DeleteMapping("/students/{id}")
    void delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
