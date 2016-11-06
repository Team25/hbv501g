package project.service.Implementation;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.stereotype.Service;
// import org.springframework.data.domain.ExampleMatcher;
// https://github.com/spring-projects/spring-data-commons/blob/master/src/main/java/org/springframework/data/domain/ExampleMatcher.java
// skoða link fyrir ofan... finn ekki example matcher til að importa.

import project.persistence.entities.Entry;
import project.persistence.repositories.EmployeeRepository;
import project.persistence.repositories.EntryRepository;
import project.service.EntryService;


// Finish implementing
@Service
public class EntryServiceImplementation implements EntryService {
	
	EmployeeRepository employeeRepository;
	EntryRepository entryRepository;
	
	
	public Entry save(Entry entry){
		return entryRepository.save(entry);
	}
	
	public void delete(Entry entry){
		entryRepository.delete(entry);
	}
	
	public List<Entry> findByExample(Entry entry){

		ExampleMatcher matcher = ExampleMatcher.matching()
				  .withMatcher("firstname", endsWith())
				  .withMatcher("lastname", startsWith().ignoreCase());
		entryRepository.findByExample(Example.of(entry, matcher));
	}
	
	public Entry findOne(Long id){
		
	}
	
	public List<Entry> findByEmployeeId(Long employeeId){
		
	}
	
	public List<Entry> findByState(boolean isVerified){
		
	}
	
	public List<Entry> findByStateAndDepartment(boolean isVerified, String department){
		
	}
	
	public Entry clock(Long employeeId){
		
	}
	
	// cannot make private
	public Entry clockIn(Long employeeId){
		
	}
	
	// cannot make private
	public Entry clockOut(Long employeeId){
		
	}
}