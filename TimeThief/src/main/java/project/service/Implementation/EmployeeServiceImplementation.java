package project.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Employee;
import project.persistence.repositories.EmployeeRepository;
import project.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	EmployeeRepository repository;
	
	@Autowired
    public EmployeeServiceImplementation(EmployeeRepository repository) {
        this.repository = repository;
    }
	
	@Override
	public Employee save(Employee employee){
		return repository.save(employee);
	}
	
	@Override
	public void delete(Employee employee){
        repository.delete(employee);
	}
	
	@Override
	public List<Employee> findAll(){
		return repository.findAll();
	}
	
	@Override
	public List<Employee> findByFullName(String fullName){
		return repository.findByFullName(fullName);
	}
	
	@Override
	public List<Employee> findByLoginName(String loginName){
		return repository.findByLoginName(loginName);
	}
	
	@Override
	public Employee findOne(Long id){
		return repository.findOne(id);
	}
	
	@Override
	public Employee verifyLogin(String user, String password){
		List<Employee> listWithEmployee = repository.findByLoginName(user);
		Employee thisEmployee = null;
		
		if(!listWithEmployee.isEmpty()){
			thisEmployee = listWithEmployee.get(0);
		}
		
		if(thisEmployee != null && password.equals(thisEmployee.getLoginPassword())){
			return thisEmployee;
		}
		return null;
	}
}
