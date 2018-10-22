package com.api.pharmaPOS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.pharmaPOS.entity.Employee;
import com.api.pharmaPOS.service.EmployeeService;
import com.api.pharmaPOS.util.Response;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = {"http://localhost:8090"})
//@JsonRootName(value="Employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// GET (all)
	@RequestMapping(value = "/EmployeeList", method = RequestMethod.GET, headers = "Accept=application/json") // path="/EmployeeList",consumes="application/json"
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> lista = new ArrayList<Employee>();
		lista = employeeService.getAllEmployees();

		return new ResponseEntity<List<Employee>>(lista, HttpStatus.OK);
	}

	// GET (passing an id)
	@RequestMapping(value = "/Employee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable("id") int id) {
		Optional<Employee> emp = null;
		emp = employeeService.getEmployee(id);

		return new ResponseEntity<Optional<Employee>>(emp, HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "/EmployeeAdd", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Response> AddEmployee(@RequestBody Employee emp) {
		Response response = new Response();
		try {
			employeeService.addEmployee(emp);
			response.setSuccess("Empleado insertardo correctamente");
		} catch (Exception e) {
			response.setError("ERROR en la Inserción  detalle: " + e.getMessage());
		}

//		HttpHeaders headers= new HttpHeaders();

		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	// PUT
	@CrossOrigin(origins="http://localhost:8080")
	@RequestMapping(value = "/EmployeeUpdate/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Response> update(@PathVariable("id") int id, @RequestBody Employee emp) {
		Response response = new Response();
		try {
			emp.setEmployeeId(id);
			employeeService.updateEmployee(id, emp);
			response.setSuccess("El empleado <strong>"+emp.getFirstName()+" "+emp.getMiddleName()+"</strong> fue actualizado correctamente");
		} catch (Exception e) {
			response.setError("No se pudo actualizar los datos del empleado,  detalle: "+e.getMessage());
		}

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// DELETE
	@CrossOrigin(origins="http://localhost:8080")
	@RequestMapping(value = "/EmployeeDelete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Response> delete(@PathVariable("id") int id) {
		Response response = new Response();
		try {
			employeeService.deleteEmployee(id);
			response.setSuccess("El empleado fue eliminado correctamente");
		} catch (Exception e) {
			response.setError("No se pudo eliminar al empleado, detalle: "+e.getMessage());
		}		

		return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
	}

}
