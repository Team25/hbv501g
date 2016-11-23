package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@SuppressWarnings("unchecked")
	Employee save(Employee employee);

    void delete(Employee employee);
    
    List<Employee> findAll();
    
    List<Employee> findByFullName(String fullName);
    
    List<Employee> findByLoginName(String name);
    
    List<Employee> findByLoginNameContainingIgnoreCaseOrFullNameContainingIgnoreCase(String loginName, String fullName);
    
    Employee findOne(Long id);
	
}
