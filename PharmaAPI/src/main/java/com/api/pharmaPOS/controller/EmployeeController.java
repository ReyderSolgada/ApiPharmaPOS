package com.api.pharmaPOS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
		String success = "", error = "";
		try {

			if (emp.getFirstName().equals("")) {
				error = "El campo Nombre es requerido";
			} else {
				if (emp.getMiddleName().equals(""))
					error = "El campo Ape.Paterno es requerido";
				else if (emp.getLastName().equals(""))
					error = "El campo Ape. Materno es requerido";
				else if (emp.getHireDate() == null)
					error = "La fecha de Ingreso es requerido";
				else if (emp.getDni().equals(""))
					error = "El campo Dni es requerido";
				else if (emp.getDni().length() != 8)
					error = "El Dni debe tener 8 digitos";
				else if (!isNumeric(emp.getDni()))
					error = "El campo dni solo debe contener Números";
				else if (emp.getPhone().isEmpty())
					error = "El Campo Teléfono es requerido";
				else if (emp.getPhone().length() < 7)
					error = "El teléfono puede tener como mínimo 7 digitos";
				else if (!isNumeric(emp.getPhone().substring(0, 5)) | !isNumeric(emp.getPhone().substring(5)))
					error = "El campo Teléfono solo debe contener números";
				else if (emp.getPhone().length() > 9)
					error = "El teléfono puede tener como máximo 9 caracteres";
				else if (emp.getAddress().equals(""))
					error = "El campo Dirección es requerido";
				else if (emp.getSalary() == 0)
					error = "El campo Salario es requerido";
				else {
					employeeService.addEmployee(emp);
					success = "Empleado insertado correctamente";
				}

			}

		} catch (Exception e) {
			error = e.getMessage();
			if (error.contains("DNI"))
				error = "El DNI ingresado ya existe para otro Empleado";
			else if (error.contains("Phone"))
				error = "El Teléfono ingresado ya existe para otro empleado";
		}
		response.setSuccess(success);
		response.setError(error);
		System.out.println(success);
		System.out.println(error);

		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	// PUT
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/EmployeeUpdate/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Response> update(@PathVariable("id") int id, @RequestBody Employee emp) {
		Response response = new Response();
		String success = "", error = "";
		try {
			emp.setEmployeeId(id);
			if (emp.getFirstName().equals("")) {
				error = "El campo Nombre es requerido";
			} else {
				if (emp.getMiddleName().equals(""))
					error = "El campo Ape.Paterno es requerido";
				else if (emp.getLastName().equals(""))
					error = "El campo Ape. Materno es requerido";
				else if (emp.getHireDate() == null)
					error = "La fecha de Ingreso es requerido";
				else if (emp.getDni().equals(""))
					error = "El campo Dni es requerido";
				else if (emp.getDni().length() != 8)
					error = "El Dni debe tener 8 digitos";
				else if (!isNumeric(emp.getDni()))
					error = "El campo dni solo debe contener Números";
				else if (emp.getPhone().isEmpty())
					error = "El Campo Teléfono es requerido";
				else if (emp.getPhone().length() < 7)
					error = "El teléfono puede tener como mínimo 7 digitos";
				else if (!isNumeric(emp.getPhone().substring(0, 5)) | !isNumeric(emp.getPhone().substring(5)))
					error = "El campo Teléfono solo debe contener números";
				else if (emp.getPhone().length() > 9)
					error = "El teléfono puede tener como máximo 9 digitos";
				else if (emp.getAddress().equals(""))
					error = "El campo Dirección es requerido";
				else if (emp.getSalary() == 0)
					error = "El campo Salario es requerido";
				else {
					employeeService.updateEmployee(id, emp);
					success = "El empleado <strong>" + emp.getFirstName() + " " + emp.getMiddleName()
							+ "</strong> fue actualizado correctamente";
				}

			}
		} catch (Exception e) {
			error = e.getMessage();
			if (error.contains("DNI"))
				error = "El DNI ingresado ya existe para otro Empleado";
			else if (error.contains("Phone"))
				error = "El Teléfono ingresado ya existe para otro empleado";
		}
		response.setSuccess(success);
		response.setError(error);
		System.out.println("Teléfono " + emp.getPhone());
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// DELETE
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/EmployeeDelete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Response> delete(@PathVariable("id") int id) {
		Response response = new Response();
		try {
			employeeService.deleteEmployee(id);
			response.setSuccess("El empleado fue eliminado correctamente");
		} catch (Exception e) {
			response.setError("No se pudo eliminar al empleado, detalle: " + e.getMessage());
		}

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	private Boolean isNumeric(String cadena) {
		Boolean result;
		try {
			Integer.parseInt(cadena);
			result = true;
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}

	@RequestMapping(value = "/EmployeeLogin/{email}&{password}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Optional<Employee>> getEmployeeByEmailandPasswordUser(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		Optional<Employee> user = null;
		user = employeeService.getEmployeeByEmailandPasswordUser(email, password);

		return new ResponseEntity<Optional<Employee>>(user, HttpStatus.OK);
	}

}
