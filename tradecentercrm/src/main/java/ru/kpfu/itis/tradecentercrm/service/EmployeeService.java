package ru.kpfu.itis.tradecentercrm.service;

import ru.kpfu.itis.tradecentercrm.entity.Employee;

import java.util.List;

/**
 * Created by Bulat Murtazin on 09.06.2018 -> 1:14
 * KPFU ITIS 11-601
 **/


public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(long id);
    void addEmployee(String fullName, String review, int salary);
    void deleteById(long id);
    void editEmployee(long id,String review, int salary);
}
