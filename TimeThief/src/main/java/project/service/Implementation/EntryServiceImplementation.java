package project.service.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
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
		
		Example<Entry> entryExample = Example.of(entry);
		
		return entryRepository.findAll(entryExample);
	}
	
	public Entry findOne(Long id){
		return entryRepository.findOne(id);
	}
	
	public List<Entry> findByEmployeeId(Long employeeId){
		return entryRepository.findById(new Long(1));
	}
	
	// TODO laga
	public List<Entry> findByState(boolean isVerified){
		return entryRepository.findById(new Long(1));
	}
	
	// TODO laga
	public List<Entry> findByStateAndDepartment(boolean isVerified, String department){
		return entryRepository.findById(new Long(1));
	}
	
	// TODO laga
	public Entry clock(Long employeeId){
		return entryRepository.findOne(employeeId);
	}
	
	// cannot make private
	// TODO laga
	public Entry clockIn(Long employeeId){
		return entryRepository.findOne(employeeId);
	}
	
	// cannot make private
	// TODO laga
	public Entry clockOut(Long employeeId){
		return entryRepository.findOne(employeeId);
	}
}
