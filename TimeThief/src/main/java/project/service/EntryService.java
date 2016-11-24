package project.service;

import java.util.List;

import project.persistence.entities.Entry;

// TODO finish implementing this.
public interface EntryService {
	
	Entry save(Entry entry);
	
	void delete(Entry entry);
	
	List<Entry> findByExample(Entry entry);
	
	Entry findOne(Long id);
	
	List<Entry> findAll();
	
	List<Entry> findByEmployeeId(Long employeeId);
	
	Entry isEmployeeClockedIn(Long employeeId);
	
	List<Entry> findByState(boolean isVerified);
	
	List<Entry> findByStateAndDepartment(boolean isVerified, String department);
	
	Entry clock(Long employeeId, String department);
	
	Entry clockIn(Long employeeId, String department);
	
	Entry clockOut(Long employeeId);
}
