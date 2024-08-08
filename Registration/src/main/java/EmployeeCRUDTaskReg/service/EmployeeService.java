package EmployeeCRUDTaskReg.service;

import EmployeeCRUDTaskReg.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);


    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployessdata();

    EmployeeDto UpdateEmployee(Long employeeId,EmployeeDto UpdateEmployee);

    void deleteEmployee(Long employeeId);
}
