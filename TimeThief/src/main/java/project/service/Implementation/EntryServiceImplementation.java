package project.service.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import project.persistence.entities.Entry;
import project.service.EntryService;


// Finish implementing
@Service
public class EntryServiceImplementation implements EntryService {
	
	
	
	public Entry save(Entry entry){
		return new Entry();
	}
	
	public void delete(Entry entry){
		
	}
	
	public List<Entry> findByExample(Entry entry){
		
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
