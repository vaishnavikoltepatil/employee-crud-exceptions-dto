package EmployeeCRUDTaskReg.repository;

import EmployeeCRUDTaskReg.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employee,Long> {
}
