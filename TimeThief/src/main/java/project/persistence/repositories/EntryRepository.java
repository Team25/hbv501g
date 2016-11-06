package project.persistence.repositories;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.Employee;
import project.persistence.entities.Entry;

public interface EntryRepository  extends JpaRepository<Entry, Long>{
	
	@SuppressWarnings("unchecked")
	Entry save(Entry entry);

    void delete(Entry entry);
    
    Entry findOne(Long id);

    
    List<Entry> findByState(boolean isVerified);
    
    List<Entry> findByStateAndDepartment(boolean isVerified, String department);
    
    List<Entry> findByExample(Example example);
    

}