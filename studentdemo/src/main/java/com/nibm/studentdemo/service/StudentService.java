package com.nibm.studentdemo.service;

import com.nibm.studentdemo.dto.StudentDTO;
import com.nibm.studentdemo.entity.Student;

import java.util.List;


public interface StudentService {

    //udana
    List<StudentDTO> getAllStudent();

    StudentDTO getStudetById(int id);

    boolean deleteStudent(int id);

    StudentDTO updateStudent(int id, StudentDTO studentDTO);

    StudentDTO addStudent(StudentDTO studentDTO);


}
