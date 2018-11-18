package com.api.pharmaPOS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.pharmaPOS.entity.Supplier;
import com.api.pharmaPOS.service.SupplierService;
import com.api.pharmaPOS.util.Response;

@RestController
@RequestMapping("/api")
public class SupplierController {


	// Dependency injection

	@Autowired
	private SupplierService supplierService;

	// Method to get all suppliers

	@RequestMapping(value = "/SupplierList", headers = "Accept=application/json")
	public ResponseEntity<List<Supplier>> getAllSuppliers() {
		List<Supplier> list = new ArrayList<Supplier>();
		list = supplierService.getAllSuppliers();
		return new ResponseEntity<List<Supplier>>(list, HttpStatus.OK);
	}

	// Method to get suppliers by id

	@GetMapping(value = "/Supplier/{id}", headers = "Accept=application/json")
	public ResponseEntity<Optional<Supplier>> getSupplier(@PathVariable("id") int id) {
		Optional<Supplier> supplier = null;
		supplier = supplierService.getSupplier(id);
		return new ResponseEntity<Optional<Supplier>>(supplier, HttpStatus.OK);
	}

	// Method to add a supplier

	@PostMapping(value = "/SupplierAdd", headers = "Accept=application/json")
	public ResponseEntity<Response> addSupplier(@RequestBody Supplier supplier) {
		Response response = new Response();
		String success = "", error = "";
		try {

			if (supplier.getName().equals("")) {
				error = "El campo Nombre es requerido.";
			} else {
				if (supplier.getAddress().equals(""))
					error = "El campo Dirección es requerido.";
				else if (supplier.getEmail().equals(""))
					error = "El campo Email es requerido.";
				else if (supplier.getPhone().isEmpty())
					error = "El campo Teléfono es requerido.";
				else if (supplier.getPhone().length() < 7)
					error = "El campo Teléfono puede tener como mínimo 7 digitos.";
//				else if (!isNumeric(supplier.getPhone().substring(0, 5)) | !isNumeric(supplier.getPhone().substring(5)))
//					error = "El campo Teléfono solo debe contener números.";
				else if (supplier.getPhone().length() >= 9)
					error = "El campo Teléfono puede tener como máximo 9 caracteres.";
				else {
					supplierService.addSupplier(supplier);
					success = "Proveedor insertado correctamente.";
				}
			}
		} catch (Exception e) {
			error = e.getMessage();
			if (error.contains("Nombre"))
				error = "El Nombre ingresado ya existe.";
			else if (error.contains("Teléfono"))
				error = "El Teléfono ingresado ya existe.";
			else if (error.contains("Email")) {
				error = "El Email ingresado ya existe.";
			}
		}
		response.setSuccess(success);
		response.setError(error);
		System.out.println(success);
		System.out.println(error);

		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	// Method to update a supplier

	@CrossOrigin(origins = "http://localhost:8080")
	@PutMapping(value = "/SupplierUpdate/{id}")
	public ResponseEntity<Response> updateSupplier(@PathVariable("id") Long id, @RequestBody Supplier supplier) {
		Response response = new Response();
		String success = "", error = "";
		try {

			if (supplier.getName().equals("")) {
				error = "El campo Nombre es requerido.";
			} else {
				if (supplier.getAddress().equals(""))
					error = "El campo Dirección es requerido.";
				else if (supplier.getEmail().equals(""))
					error = "El campo Email es requerido.";
				else if (supplier.getPhone().isEmpty())
					error = "El campo Teléfono es requerido.";
				else if (supplier.getPhone().length() < 7)
					error = "El campo Teléfono puede tener como mínimo 7 digitos.";
//				else if (!isNumeric(supplier.getPhone().substring(0, 5)) | !isNumeric(supplier.getPhone().substring(5)))
//					error = "El campo Teléfono solo debe contener números.";
				else if (supplier.getPhone().length() >= 9)
					error = "El campo Teléfono puede tener como máximo 9 caracteres.";
				else {
					supplierService.updateSupplier(id, supplier);
					success = "El proveedor <strong>" + supplier.getName() + "</strong> fue actualizado correctamente";
				}
			}
		} catch (Exception e) {
			error = e.getMessage();
			if (error.contains("Nombre"))
				error = "El Nombre ingresado ya existe.";
			else if (error.contains("Teléfono"))
				error = "El Teléfono ingresado ya existe.";
			else if (error.contains("Email")) {
				error = "El Email ingresado ya existe.";
			}
		}
		response.setSuccess(success);
		response.setError(error);
		System.out.println(success);
		System.out.println(error);

		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	// Method to delete a supplier

	@CrossOrigin(origins = "http://localhost:8080")
	@DeleteMapping(value = "/SupplierDelete/{id}")
	public ResponseEntity<Response> deleteSupplier(@PathVariable("id") int id) {
		Response response = new Response();
		try {
			supplierService.deleteSupplier(id);
			response.setSuccess("El proveedor fue eliminado correctamente.");
		} catch (Exception e) {
			response.setError("No se pudo eliminar al proveedor - Error: " + e.getMessage());
		}

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}


}
