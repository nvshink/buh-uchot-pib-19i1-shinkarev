package com.example.headlibrary.service;

import com.example.headlibrary.entity.Employee;
import com.example.headlibrary.entity.Payroll;
import com.example.headlibrary.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
