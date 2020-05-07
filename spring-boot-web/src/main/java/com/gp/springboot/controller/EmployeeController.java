package com.gp.springboot.controller;

import com.gp.springboot.dao.EmployeeDao;
import com.gp.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;

/**
 * @author gp
 * @create 2020/2/14 19:08
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String showEmps(Map<String, Object> map) {
        Collection<Employee> emps = employeeDao.getAll();
        map.put("emps", emps);
        return "list";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String addEmp() {
        return "addEmp";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String returnEmps() {
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String toEditEmp(@PathVariable("id") Integer id) {
        return "editEmp";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String finishEditEmp() {
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String finistDeleteEmp(@PathVariable("id") Integer id) {
        return "redirect:/emps";
    }
}
