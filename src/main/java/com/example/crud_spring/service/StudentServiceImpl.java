package com.example.crud_spring.service;

import com.example.crud_spring.models.Role;
import com.example.crud_spring.models.Student;
import com.example.crud_spring.models.User;
import com.example.crud_spring.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void addStudent(@Valid Student student) {
        studentRepository.add(student);
    }

    @Override
    public void updateStudent(@Valid Student student) {
        studentRepository.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    public User getCurrentUser() {
        // Імітуємо авторизованого користувача
        return new User(1L, "Admin", Set.of(new Role(1L, "Admin")));
    }
}
