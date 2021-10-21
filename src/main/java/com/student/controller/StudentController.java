package com.student.controller;

import com.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }


    //A handler Method to handle list of student and return mode and view
    @GetMapping("/students")
    // @ResponseBody
    public ModelAndView listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("src/main/resources/templates/students.html");
        return modelAndView;
        // return "students";
    }
}
