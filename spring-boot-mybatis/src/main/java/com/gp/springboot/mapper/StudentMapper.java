package com.gp.springboot.mapper;

import com.gp.springboot.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gp
 * @create 2020/2/16 21:13
 */
@Mapper
public interface StudentMapper {
    List<Student> queryAllStudent();

    Student queryStudentById(Integer id);
}
