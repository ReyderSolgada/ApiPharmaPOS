package com.api.pharmaPOS.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.api.pharmaPOS.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	String query = "select e.* from user u inner join employee e " + "on u.EmployeeId=e.EmployeeId "
			+ "where  e.Email=?1 and u.Password=?2";
	
	String query2="select * from employee where FirstName like ?1%";

	@Query(value = query, nativeQuery = true)
	Optional<Employee> getEmployeeByEmailandPasswordUser(String email, String password);
	
	@Query(value = query2, nativeQuery = true)
	 Collection<Employee> getEmployeeByFirstName(String name);

}
