package com.gp.springboot;

import com.gp.springboot.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringBootMybatisApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    StudentMapper studentMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(studentMapper.getClass());
//        System.out.println(dataSource.getClass());
//        System.out.println(studentMapper.queryStudentById(20));
//        System.out.println(studentMapper.getClass());
//        System.out.println(dataSource.getConnection());
    }

}
