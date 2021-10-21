package com.student.controller;

import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.yaml.snakeyaml.events.Event;

import javax.annotation.PostConstruct;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }


    //A handler Method to handle list of student and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){

        //Create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String  saveStudent(@ModelAttribute("student") Student student) {
            studentService.saveStudent(student);
            return "redirect:/students";
    }

    @GetMapping("/students/edit/{ID}")
    public String editStudentForm(@PathVariable Long ID, Model model) {
            model.addAttribute("student", studentService.getStudentById(ID));
            return "edit_student";
    }

    @PostMapping("/students/{ID}")
    public String updateStudent(@PathVariable  Long ID, @ModelAttribute("student") Student student , Model model) {
        //Get the student from the database
        Student existingStudent = studentService.getStudentById(ID);
        existingStudent.setID(ID);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //Save update student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    //The handler method to handle the delete request
    @GetMapping("/students/{ID}")
    public String deleteStudent(@PathVariable Long ID ) {
            studentService.deleteStudentById(ID);
            return "redirect:/students";
    }
}





