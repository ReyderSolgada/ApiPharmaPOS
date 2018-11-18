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

import com.api.pharmaPOS.entity.Product;
import com.api.pharmaPOS.service.ProductService;
import com.api.pharmaPOS.util.Response;

@RestController
@RequestMapping("/api")
public class ProductController {
 
	@Autowired
	private ProductService productService;

	// GET (all)
		@RequestMapping(value = "/ProductList", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<List<Product>> getAllProducts() {
			List<Product> lista = new ArrayList<Product>();
			lista = productService.getAllProducts();

			return new ResponseEntity<List<Product>>(lista, HttpStatus.OK);
		}

		// GET (passing an id)
		@RequestMapping(value = "/Product/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<Optional<Product>> getProduct(@PathVariable("id") int id) {
			Optional<Product> pro = null;
			pro = productService.getProduct(id);

			return new ResponseEntity<Optional<Product>>(pro, HttpStatus.OK);
		}

		// POST
		@RequestMapping(value = "/ProductAdd", method = RequestMethod.POST, headers = "Accept=application/json")
		public ResponseEntity<Response> AddProduct(@RequestBody Product pro) {
			Response response = new Response();
			String success="",error="";
			try {
				
				if(pro.getDescription().equals("")) {
					error = "El campo Descripcion es requerido";
				}else {
					if(pro.getCategoryProduct() == null) {
						error = "El campo Categoria es requerido";
					}else {
						if(pro.getPrice() < 0) {
							error = "El campo Precio no puede ser un valor Negativo";
						}else {
							if(pro.getStock() < 0) {
								error = "El campo Stock no puede ser menor a 0";
							}else {
								productService.addProduct(pro);
								success = "El producto se ha registrado con exito";
							}
						}
					}
				}
				
			} catch (Exception e) {
				error=e.getMessage();
			}
			response.setSuccess(success);
			response.setError(error);
			System.out.println(success);
			System.out.println(error);

			return new ResponseEntity<Response>(response, HttpStatus.CREATED);
		}

		// PUT
		@CrossOrigin(origins="http://localhost:8080")
		@RequestMapping(value = "/ProductUpdate/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
		public ResponseEntity<Response> update(@PathVariable("id") int id, @RequestBody Product pro) {
			Response response = new Response();
			String success="",error="";
			try {
				pro.setProductId(id);
				
				if(pro.getDescription().equals("")) {
					error = "El campo Descripcion es requerido";
				}else {
					if(pro.getCategoryProduct() == null) {
						error = "El campo Categoria es requerido";
					}else {
						if(pro.getPrice() < 0) {
							error = "El campo Precio no puede ser un valor Negativo";
						}else {
							if(pro.getStock() < 0) {
								error = "El campo Stock no puede ser menor a 0";
							}else {
								productService.updateProduct(id, pro);
								success="El producto <strong>"+pro.getDescription()+"</strong> fue actualizado correctamente";
							}
						}
					}
				}
			} catch (Exception e) {
				error=e.getMessage();	
			}
			response.setSuccess(success);
			response.setError(error);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}

		// DELETE
		@CrossOrigin(origins="http://localhost:8080")
		@RequestMapping(value = "/ProductDelete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
		public ResponseEntity<Response> delete(@PathVariable("id") int id) {
			Response response = new Response();
			try {
				productService.deleteProduct(id);
				response.setSuccess("El producto fue eliminado correctamente");
			} catch (Exception e) {
				response.setError("No se pudo eliminar el producto, detalle: "+e.getMessage());
			}		

			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/ProductSearch/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<List<Product>> getProductByDescription(@PathVariable("name") String name) {
			List<Product> lista = new ArrayList<Product>();
			lista = productService.getProductByDescription(name);

			return new ResponseEntity<List<Product>>(lista, HttpStatus.OK);
		}

}
