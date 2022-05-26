package com.example.headlibrary.controller;

import com.example.headlibrary.entity.Employee;
import com.example.headlibrary.entity.Payroll;
import com.example.headlibrary.service.EmployeeService;
import com.example.headlibrary.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PayrollService payrollService;

    @GetMapping("/")
    public String getAll(Model model) {
        List<Employee> employeeList = employeeService.getAll();
        List<Payroll> payrollList = payrollService.getAllPayroll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeSize", employeeList.size());
        model.addAttribute("payrollList", payrollList);
        model.addAttribute("payrollSize", payrollList.size());
        return "index";

    }
    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        List<Employee> employeeList = employeeService.getAll();
        List<Payroll> payrollList = payrollService.getEmployeePayroll(id);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeSize", employeeList.size());
        model.addAttribute("payrollList", payrollList);
        model.addAttribute("payrollSize", payrollList.size());
        return "index";

    }
    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        if (!employee.getDateEmployment().after(new Date())) {
            employeeService.save(employee);
        }
        return "redirect:/";
    }

}
