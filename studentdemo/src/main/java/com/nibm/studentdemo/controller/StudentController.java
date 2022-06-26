package com.nibm.studentdemo.controller;

import com.nibm.studentdemo.dto.ResponseDTO;
import com.nibm.studentdemo.dto.StudentDTO;
import com.nibm.studentdemo.service.StudentService;
import com.nibm.studentdemo.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    //  StudentService studentService = new StudentServiceImpl(); simple
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseDTO getAllStudents() {

        List<StudentDTO> allStudent = studentService.getAllStudent();

        return new ResponseDTO(200, "Success", allStudent);

    }

    @PostMapping
    public ResponseDTO saveStudent(@RequestBody StudentDTO studentDTO) {

        StudentDTO studentDTO1 = studentService.addStudent(studentDTO);
        return new ResponseDTO(200, "Success", studentDTO1);

    }

    @PutMapping("/{id}")
    public ResponseDTO updateStudent(@PathVariable("id") int id, @RequestBody StudentDTO studentDTO) {

        StudentDTO studentDTO1 = studentService.updateStudent(id, studentDTO);
        return new ResponseDTO(200, "Success", studentDTO1);

    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteStudent(@PathVariable("id") int id) {


        if (studentService.deleteStudent(id)) {
            return new ResponseDTO(200, "Success", "");
        } else {
            return new ResponseDTO(200, "Failed", "");
        }


    }

    @GetMapping("/{id}")

    public ResponseDTO findUserById(@PathVariable("id") int id) {

        StudentDTO studetById = studentService.getStudetById(id);
        if (studetById!=null) {
            return new ResponseDTO(200, "Success", studetById);
        } else {
            return new ResponseDTO(200, "No User", "");
        }
    }
}
