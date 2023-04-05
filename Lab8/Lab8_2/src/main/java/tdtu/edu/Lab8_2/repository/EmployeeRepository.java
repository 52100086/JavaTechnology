package tdtu.edu.Lab8_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.Lab8_2.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
