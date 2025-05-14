package pl.dmcs.zva.springbootjsp_iwa2025.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.dmcs.zva.springbootjsp_iwa2025.model.Student;
import pl.dmcs.zva.springbootjsp_iwa2025.repository.StudentRepository;

@Controller
public class StudentController {

    @RequestMapping("/student")
    public String student(Model model) {
        model.addAttribute("message","Simple String from StudentController.");
        Student newStudent = new Student();
        model.addAttribute("student",newStudent);
        return "student";
    }

    @RequestMapping(value = "/addStudent.html", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student) {

        System.out.println(student.getFirstName() + " " + student.getLastName() +
                " " + student.getEmail() + " " + student.getTelephone());

        return "redirect:student";
    }

}

