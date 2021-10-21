package com.student;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student("Collins", "Morgan", "Collinsboniface1000@gmail.com");
        studentRepository.save(student);

        Student student1 = new Student("Ian", "Johnson", "Ianjohnson@gmail.com");
        studentRepository.save(student1);

        Student student2 = new Student("Johnny", "Papa", "Johnny@lepapa.com");
        studentRepository.save(student2);

    }
}
