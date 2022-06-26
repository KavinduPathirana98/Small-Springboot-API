package com.nibm.studentdemo.service.impl;

import com.nibm.studentdemo.dto.StudentDTO;
import com.nibm.studentdemo.entity.Student;
import com.nibm.studentdemo.repository.StudentRepository;
import com.nibm.studentdemo.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudent() {

        List<StudentDTO> studentDTOList = new ArrayList<>();

        List<Student> all = studentRepository.findAll();

        all.forEach(student -> {
            studentDTOList.add(new StudentDTO(student.getsId(),
                    student.getsName(),
                    student.getsAddress(),
                    student.getsAge(), student.getsTel()));
        });
        return studentDTOList;
    }

    @Override
    public StudentDTO getStudetById(int id) {

        Student student = studentRepository.findById(id).get();

        StudentDTO studentDTO1 = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO1);

        return studentDTO1;
    }

    @Override
    public boolean deleteStudent(int id) {

        try {
            studentRepository.delete(studentRepository.findById(id).get());

            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    @Override
    public StudentDTO updateStudent(int id, StudentDTO studentDTO) {

        Student student = studentRepository.findById(id).get();

        if (student != null) {
            studentDTO.setsId(id);
            return addStudent(studentDTO);
        } else {
            return null;
        }

    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {

        Student student = new Student();
        StudentDTO studentDTO1 = new StudentDTO();
        BeanUtils.copyProperties(studentDTO, student);
        Student save = studentRepository.save(student);
        BeanUtils.copyProperties(save, studentDTO1);

        return studentDTO1;
    }


}
