package EmployeeCRUDTaskReg.service;

import EmployeeCRUDTaskReg.dto.EmployeeDto;
import EmployeeCRUDTaskReg.entity.Employee;
import EmployeeCRUDTaskReg.exception.ResultNotFoundException;
import EmployeeCRUDTaskReg.mapper.EmployeeMapper;
import EmployeeCRUDTaskReg.repository.EmployeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

@Autowired
  private EmployeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
         Employee employee = employeeRepository.findById(employeeId)
                 .orElseThrow(() -> new ResultNotFoundException("Employee id not found in data: "+employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployessdata() {
      List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee )-> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto UpdateEmployee(Long employeeId, EmployeeDto UpdateEmployee) {

       Employee employee= employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResultNotFoundException("Employee is not exist: "+employeeId)
        );

       employee.setFirstname(UpdateEmployee.getFirstname());
       employee.setLastname(UpdateEmployee.getLastname());
       employee.setEmail(UpdateEmployee.getEmail());

       Employee updatedemp= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedemp);
    }

    @Override
    public void deleteEmployee(Long employeeId) {


        Employee employee= employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResultNotFoundException("Employee is not exist in data: "+employeeId)
        );
        employeeRepository.deleteById(employeeId);
    }
}
