package project.service.Implementation;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
    public EntryServiceImplementation(EmployeeRepository employeeRepository, EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
        this.employeeRepository = employeeRepository;
    }
	
	@Override
	public Entry save(Entry entry){
		return entryRepository.save(entry);
	}
	
	@Override
	public void delete(Entry entry){
		entryRepository.delete(entry);
	}
	
	@Override
	public Entry isEmployeeClockedIn(Long employeeId){
		List<Entry> entryList = entryRepository.findByEmployeeIdAndOutTimeIsNull(employeeId);
		if(entryList == null || entryList.isEmpty()){
			return null;
		}
		return entryList.get(0);
	}
	
	@Override
	public List<Entry> findByExample(Entry entry){
		
		Example<Entry> entryExample = Example.of(entry);
		
		return entryRepository.findAll(entryExample);
	}
	
	@Override
	public Entry findOne(Long id){
		return entryRepository.findOne(id);
	}
	
	@Override
	public List<Entry> findByEmployeeId(Long employeeId){
		return entryRepository.findById(new Long(1));
	}
	
	// TODO laga
	@Override
	public List<Entry> findByState(boolean isVerified){
		return entryRepository.findById(new Long(1));
	}
	
	// TODO laga
	@Override
	public List<Entry> findByStateAndDepartment(boolean isVerified, String department){
		return entryRepository.findById(new Long(1));
	}
	
	// TODO laga
	public Entry clock(Long employeeId, String department){
		Entry entry = isEmployeeClockedIn(employeeId);
		if(entry == null){
			return clockIn(employeeId, department);
		} 
		return clockOut(employeeId);
	}
	
	// cannot make private
	@Override
	public Entry clockIn(Long employeeId, String department){
		Entry entry = new Entry();
		entry.setDepartment(department);
		entry.setEmployeeId(employeeId);
		entry.setInTime(new Timestamp(System.currentTimeMillis()));
		entry.setIsVerified(false);
		return entryRepository.save(entry);		
	}
	
	// cannot make private
	// TODO laga
	@Override
	public Entry clockOut(Long employeeId){
		// should always return entry.
		Entry entry = isEmployeeClockedIn(employeeId);
		entry.setOutTime(new Timestamp(System.currentTimeMillis()));
		return entryRepository.save(entry);
	}
}
