package com.titans.atlas.controller;

import com.titans.atlas.model.Student;
import com.titans.atlas.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="atlas/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
	public List<Student> getStudentList(){
        return studentService.studentList();
	}

	@PostMapping(path="/add")
    public void registerStudent(@RequestBody Student student){
       studentService.addNewStudent(student);
    }

    @DeleteMapping(path="delete{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }


    @PutMapping(path="put{studentId}")
    public void updateStudent(
            @PathVariable("studentId")Long studentID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){

        studentService.updateStudent(studentID, name, email);
    }
}
