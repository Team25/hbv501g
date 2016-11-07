package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.Entry;

public interface EntryRepository  extends JpaRepository<Entry, Long>{
	
	@SuppressWarnings("unchecked")
	Entry save(Entry entry);

    void delete(Entry entry);
    
    Entry findOne(Long id);

    List<Entry> findByEmployeeIdAndOutTimeIsNull(Long employeeId);
    
    List<Entry> findByState(boolean isVerified);
    
    List<Entry> findByStateAndDepartment(boolean isVerified, String department);
        
    List<Entry> findById(Long id);
    

}
