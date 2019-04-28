package com.liuhll.hl.auth.controller;

import com.liuhll.hl.auth.domain.entity.Employee;
import com.liuhll.hl.auth.service.impl.EmployeeService;
import com.liuhll.hl.auth.vo.EmployeeInput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/user")
public class UserController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public String addEmployee(@RequestBody @Validated EmployeeInput input){
        Employee employee = new Employee();
        BeanUtils.copyProperties(input,employee);
        employeeService.saveEmployee(employee);
        return "新增员工成功";
    }

    @DeleteMapping
    public String deleteEmployee(@RequestParam Long employeeId){
        employeeService.delete(employeeId);
        return "删除用户成功";
    }

    @GetMapping("list")
    public List<Employee> getAllEmployee(){
        return employeeService.selectAll();
    }
}
