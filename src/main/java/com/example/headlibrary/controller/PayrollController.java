package com.example.headlibrary.controller;

import com.example.headlibrary.entity.Employee;
import com.example.headlibrary.entity.Payroll;
import com.example.headlibrary.service.EmployeeService;
import com.example.headlibrary.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

//    @GetMapping("/{id}")
//    public String getEmployeePayroll(Model model, @ModelAttribute int id) {
//        List<Payroll> payrollList = payrollService.getEmployeePayroll(id);
//        model.addAttribute("payrollList", payrollList);
//        model.addAttribute("payrollSize", payrollList.size());
//        return "index";
//    }
    @RequestMapping("/showPopUp/{id}")
    public String showPopUpEmployee(Model model, @PathVariable int id) {
//        payrollService.getEmployeePayroll(id);
        List<Payroll> payrollList = payrollService.getEmployeePayroll(id);
        return "redirect:/{id}";
    }
    @RequestMapping("/deletePayroll/{id}")
    public String deletePayroll(@PathVariable int id) {
        payrollService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/addPayroll")
    public String addPayroll(@ModelAttribute Payroll payroll) {
        if (!payroll.getEndDate().after(new Date()) && !payroll.getStartDate().after(new Date()) && !payroll.getStartDate().after(payroll.getEndDate())) {
            payrollService.save(payroll);
        }
        return "redirect:/";
    }
}
