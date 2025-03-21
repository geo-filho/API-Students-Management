package me.dio.service.impl;

import me.dio.domain.model.Student;
import me.dio.domain.repository.StudentRepository;
import me.dio.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudante não encontrado com ID: " + id));
    }

    @Override
    public Student create(Student studentToCreate) {
        if (studentRepository.existsBySchoolInfoRegistrationNumber(studentToCreate.getSchoolInfo().getRegistrationNumber())) {
            throw new IllegalArgumentException("Este número de matrícula já existe.");
        }
        return studentRepository.save(studentToCreate);
    }
}
