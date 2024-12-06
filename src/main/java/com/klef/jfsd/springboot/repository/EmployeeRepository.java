package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klef.jfsd.springboot.model.Employee;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("select e from Employee e where e.email=?1 and e.password=?2")
	public Employee checkEmployeeLogin(String eemail, String epwd);
	
	@Query("update Employee e set e.status=?1 where e.id=?2")
	@Modifying // DML
	@Transactional // to enable auto commit
	public int updateEmpStatus(String status, int eid);
	
	// reference
	// no need to write queries explicitly
	public List<Employee> findByDepartment(String department);
	public List<Employee> findByGenderAndDepartment(String gender, String department);
	public List<Employee> findByGender(String gender);
}
