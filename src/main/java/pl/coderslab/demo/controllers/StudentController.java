package pl.coderslab.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.demo.entities.Publisher;
import pl.coderslab.demo.entities.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "Python", "C#", "C++", "JavaScript");
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("soccer", "technologies", "calistenisc", "health", "diet");
    }


    @GetMapping("/form")
    public String saveStudent(Model model) {
        model.addAttribute(new Student());
        return "student/formToCreate";
    }
    @PostMapping("/form")
    @ResponseBody
    public String saveStudent(Student student){
        return student.toString();
    }
}
