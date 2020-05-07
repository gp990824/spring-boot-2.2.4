package com.gp.springboot.controller;

import com.gp.springboot.bean.Student;
import com.gp.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gp
 * @create 2020/2/16 22:10
 */
@RestController
public class StudentController {
    @Autowired
    StudentMapper studentMapper;


    @RequestMapping("/student/{id}")
    public Student queryStudentById(@PathVariable("id") Integer id){
        return studentMapper.queryStudentById(id);
    }
}
