package EmployeeCRUDTaskReg.controller;

import EmployeeCRUDTaskReg.dto.EmployeeDto;
import EmployeeCRUDTaskReg.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    private EmployeeService es;
      //add the new employees
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){

        EmployeeDto savedEmployee=es.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

 //Get the employeedataByid
  @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
      EmployeeDto employeeDto= es.getEmployeeById(employeeId);
       return ResponseEntity.ok(employeeDto);
    }

    //Get All data
    @GetMapping
     public  ResponseEntity<List<EmployeeDto>> getAllEmployes(Long employeeId){
        List<EmployeeDto> em= es.getAllEmployessdata();
        return ResponseEntity.ok(em);
     }

     //Update the EmployeeData
    @PutMapping("{id}")
    public ResponseEntity <EmployeeDto> updateEmployee(@PathVariable("id")Long employeeId, @RequestBody EmployeeDto updatedEmployee){

       EmployeeDto employeeDto= es.UpdateEmployee(employeeId,updatedEmployee);
       return  ResponseEntity.ok(employeeDto);
    }

    //delete Employee

    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id") Long employeeId){

        es.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee delete successfully!");
    }
}
