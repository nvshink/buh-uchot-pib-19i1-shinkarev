package com.example.headlibrary.repository;

import com.example.headlibrary.entity.Employee;
import com.example.headlibrary.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Integer> {

}
