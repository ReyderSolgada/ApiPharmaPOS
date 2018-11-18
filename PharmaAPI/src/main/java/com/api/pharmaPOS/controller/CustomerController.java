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
import com.api.pharmaPOS.entity.Customer;
import com.api.pharmaPOS.service.CustomerService;
import com.api.pharmaPOS.util.Response;

@RestController
@RequestMapping("/api")

public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// GET (all)
	@RequestMapping(value = "/CustomerList", method = RequestMethod.GET, headers = "Accept=application/json") // path="/EmployeeList",consumes="application/json"
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> lista = new ArrayList<Customer>();
		lista = customerService.getAllCustomers();

		return new ResponseEntity<List<Customer>>(lista, HttpStatus.OK);
	}

	// GET (passing an id)
	@RequestMapping(value = "/Customer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable("id") int id) {
		Optional<Customer> emp = null;
		emp = customerService.getCustomer(id);

		return new ResponseEntity<Optional<Customer>>(emp, HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "/CustomerAdd", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Response> AddCustomer(@RequestBody Customer emp) {
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
				else if (emp.getSex() == null)
					error = "El campo sexo es requerido";
				else if (emp.getRuc().equals(""))
					error = "El campo RUS es requerido";
				else if (emp.getRuc().length() != 11)
					error = "RUC debe tener 11 digitos";
				else if (emp.getDni().equals(""))
					error = "El campo Dni es requerido";
				else if (emp.getDni().length() != 8)
					error = "El Dni debe tener 8 digitos";
				else if (emp.getAddress().equals(""))
					error = "El campo Dirección es requerido";
				else if (emp.getRegisterDate() == null)
					error = "El registo del día es requerido";
				else if (emp.getType() == null)
					error = "El campo tipo es requerido";

				else {
					customerService.addCustomer(emp);
					success = "Cliente insertado correctamente";
				}
			}

		} catch (Exception e) {
			error = e.getMessage();
			if (error.contains("DNI"))
				error = "El DNI ingresado ya existe para otro Cliente";
		}
		response.setSuccess(success);
		response.setError(error);
		System.out.println(success);
		System.out.println(error);

		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	// PUT
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/CustomerUpdate/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Response> update(@PathVariable("id") int id, @RequestBody Customer emp) {
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
				else if (emp.getSex() == null)
					error = "El campo sexo es requerido";
				else if (emp.getRuc().equals(""))
					error = "El campo RUS es requerido";
				else if (emp.getRuc().length() != 11)
					error = "RUC debe tener 11 digitos";
				else if (emp.getDni().equals(""))
					error = "El campo Dni es requerido";
				else if (emp.getDni().length() != 8)
					error = "El Dni debe tener 8 digitos";
				else if (emp.getAddress().equals(""))
					error = "El campo Dirección es requerido";
				else if (emp.getRegisterDate() == null)
					error = "El registo del día es requerido";
				else if (emp.getType() == null)
					error = "El campo tipo es requerido";
				else {
					customerService.updateCustomer(id, emp);
					success = "El cliente <strong>" + emp.getFirstName() + " " + emp.getMiddleName()
							+ "</strong> fue actualizado correctamente";
				}

			}
		} catch (Exception e) {
			error = e.getMessage();
			if (error.contains("DNI"))
				error = "El DNI ingresado ya existe para otro Cliente";

		}
		response.setSuccess(success);
		response.setError(error);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// DELETE

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/ClienteDelete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Response> delete(@PathVariable("id") int id) {
		Response response = new Response();
		try {
			customerService.deleteCustomer(id);
			response.setSuccess("El cliente fue eliminado correctamente");
		} catch (Exception e) {
			response.setError("No se pudo eliminar al cliente, detalle: " + e.getMessage());
		}

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// private Boolean isNumeric(String cadena) {
	// Boolean result;
	// try {
	// Integer.parseInt(cadena);
	// result = true;
	// } catch (NumberFormatException e) {
	// result = false;
	// }
	// return result;
	// }

}
