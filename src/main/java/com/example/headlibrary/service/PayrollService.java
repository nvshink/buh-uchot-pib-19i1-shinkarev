package com.example.headlibrary.service;

import com.example.headlibrary.entity.Employee;
import com.example.headlibrary.entity.Payroll;
import com.example.headlibrary.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    public List<Payroll> getAllPayroll() {
        return payrollRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public List<Payroll> getEmployeePayroll(int employeeId) {
        List payrollList = new ArrayList();
        for (int i = 0; i < payrollRepository.findAll().size(); i++) {
            if (employeeId == payrollRepository.findAll().get(i).getEmployeeId()) {
                payrollList.add(payrollRepository.findAll().get(i));
            }
        }
        return payrollList;
    }
    public Payroll save(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    public void delete(int id) {
        payrollRepository.deleteById(id);
    }
}
