package ru.kpfu.itis.tradecentercrm.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.tradecentercrm.entity.Employee;
import ru.kpfu.itis.tradecentercrm.entity.User;
import ru.kpfu.itis.tradecentercrm.repository.EmployeeRepository;
import ru.kpfu.itis.tradecentercrm.service.EmployeeService;
import ru.kpfu.itis.tradecentercrm.service.UserInfoService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Bulat Murtazin on 09.06.2018 -> 1:23
 * KPFU ITIS 11-601
 **/

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private UserInfoService userInfoService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserInfoService userInfoService) {
        this.employeeRepository = employeeRepository;
        this.userInfoService = userInfoService;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public void addEmployee(String fullName, String review, int salary) {
        String[] nameParts = fullName.split(" ");
        User user = userInfoService.findUserByFullName(nameParts[0], nameParts[1]);
        Employee employee = Employee.builder().user(user).review(review).salary(salary).build();
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void editEmployee(long id, String review, int salary) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setReview(review);
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }
}
