/**
 * Methods Suppliers
 */

 //LISTAR PROVEEDORES
 $(document).ready(function(){
   llenarTablaProveedores();
});
 
 llenarTablaProveedores=function(){
	$.ajax({
		url: 'http://localhost:8090/api/suppliers',
		type: 'GET',
		datatype: 'json',
		success: function(datos) {
			if(datos != ''){
				limpiarTabla();
				var tbody='';
				for(var i=0; i<datos.length; i++){
					var supplierId 	= datos[i].supplierId;
					var nombre 		= datos[i].name;
					var direccion	= datos[i].address;
					var email		= datos[i].email;
					var telefono	= datos[i].phone;


					//param: alamacenará todos los campos de la entidad Employee separados por una coma, ya que estos son parámetros 
					//que se utilizará abajo en el botón editar.
					var param		= supplierId+"\',\'"+nombre+"\',\'"+direccion+"\',\'"+email+"\',\'"+
									 telefono;
					
					tbody+='<tr>';
					tbody+='<td><span class="text-muted">'+supplierId+'</span></td>';
					tbody+='<td>'+nombre+'</td>';
					tbody+='<td>'+direccion+'</td>';
					tbody+='<td>'+email+'</td>';
					tbody+='<td>'+telefono+'</td>';
/*boton editar*/	tbody+="<td><a href='#' class='btn btn-success' data-toggle='modal' data-target='#fm-modal-edit-sup' onclick=\"seleccionProveedor(\'"+param+"\')\">Editar</a></td>";
/*boton eliminar*/	tbody+="<td><a href='#' class='btn btn-danger' data-toggle='modal' data-target='.bd-confirm-modal-sm' onclick=\"confirElimina(\'"+supplierId+"\',\'"+nombre+"\')\">Eliminar</a></td>";
					tbody+='</tr>';
					//El btn editar hace la llamada desde el onclick a la función seleccionEmpleado(param) con los parámetros que se utilizarán para cargar los controles de editarEmpleado.jsp
					//El btn eliminar llama a la función confirmElimina(employeeId,firstName+middleName) se envia el id y el nombre, este último campo será para informar al usuario que el emnpleado va a ser borrado
					//este valor se cargará en eliminarEmpleado.jsp
				}
				//console.log(tbody);
				$('#tblproveedores tbody').append(tbody);
			}
		},
				 error: function(result){
                    console.log('ERROR ' + result.status + ' ' + result.statusText);
                }
	}); 
	
	function limpiarTabla(){
		$('#tblproveedores tbody tr').remove();
	}
};

function agregarProveedor(){
	//Almaceno en variables el contenido a guardar
	var nombre		=$('#id-add-nombre').val().trim();
	var direccion	=$('#id-add-direccion').val().trim();
	var email		=$('#id-add-email').val().trim();
	var telefono	=$('#id-add-telefono').val().trim();

	//Luego se almacenará en una variable tipo array los valores
	//(los nombres en la parte izquierda del array deben ser iguales a la entidad tanto en mayúsculas como en minúsculas)
	var Supplier={
					name:nombre,
					address:direccion,
					email:email,
					phone:telefono		
				};

	console.log(JSON.stringify(Supplier));				//Imprimir en consola el Array convertido a JSON (esto para Pruebas)
	
	$.ajax({
		url:'http://localhost:8090/api/suppliers',	//URL que recibirá la data
		type:'POST',									
		contentType:'application/json; charset=utf-8',	
		data:JSON.stringify(Supplier),					//Enviar la data convertido a JSON variable Employee

		success:function(response){						//succes: función que devuelve la rspta enviada desde el método en la api.
			if(response.success!= ''){					//response puede ser cualquier nombre, pero .success debe ser el mismo nombre
				$.ambiance({							//que se envia desde la Api. En este caso la Api devuelve un objeto con dos atributos
			       message: response.success,			//success y error. Solo uno de ellos volverá con valor.
			       title: "Éxito! ",					//En el primer If se muestra un mensaje como respuesta en caso el mensaje tenga éxito.
			       type: "success"
			    });
			    llenarTablaProveedores();					//volvemos a cargar la tabla
			    limpiarCampos('add');					//limpiamos los  controles
			}
			else if (response.error!= '') {				//Si error viene con valor significa que hubo un problema en la inserción
				$.ambiance({							//y se muestra el error al usuario.
			       message: response.error,
			       title: "ERROR! ",
			       type: "error"
			    });
			}
		},
		error:function(result){							//este error es propio del método Ajax, en caso el servicio no responda o se encuentre inactivo.
			console.log('ERROR ' + result.status + ' ' + result.statusText); //esto también deberia mostrarse como mensaje al usuario.
		}
		
	});

};	

//EDITAR PROVEEDOR
function editarProveedor(){								//Esta función hace lo mismo que el agregarEmpleado	
		var id 			=$('#id-edit-codigo').val();
		var nombre 		=$('#id-edit-nombre').val();
		var direccion	=$('#id-edit-direccion').val();
		var email 		=$('#id-edit-email').val();
		var telefono 	=$('#id-edit-telefono').val();

		var Supplier={
					name:nombre,
					address:direccion,
					email:email,
					phone:telefono		
				};

		console.log(JSON.stringify(Supplier));

		$.ajax({
		url:'http://localhost:8090/api/suppliers/'+id,			//URL: aquí se el agrega el parámetro id al final de la url
		type:'PUT',													
		contentType:'application/json; charset=utf-8',
		data:JSON.stringify(Supplier),

		success:function(response){
			if(response.success!=''){
				$.ambiance({
			       message: response.success,
			       title: "Éxito! ",
			       type: "success"
			    });
			    llenarTablaProveedores();
			    limpiarCampos('edit');
				//alert(response.success);
			}
			else if (response.error!='') {
				$.ambiance({
			       message: response.error,
			       title: "ERROR! ",
			       type: "error"
			    });
				//alert(response.error);
			}
		},
		error:function(result){
			console.log('ERROR ' + result.status + ' ' + result.statusText);
		}
		
	});
}
//ELIMINAR PROVEEDOR
function eliminarProveedor(){	
	//Esta función lee el <input type="hidden" name="" id="id-del-Codigo" > que está oculto para el usuario  en formulario eliminarEmpleado.jsp		
	var id 	= $('#id-del-Codigo').val();
	
	$.ajax({
		url:'http://localhost:8090/api/suppliers/'+id,		//Agregamos el id al final de la URl
		type:'DELETE',											//En este caso no enviamos ninguna data, con excepción del Id en la URL
		datatype:'json',										//Pero sí vamos a recibir un Json como rspt

		success:function(response){
			if(response.success!=''){
				$.ambiance({
			       message: response.success,
			       title: "Éxito! ",
			       type: "success"
			    });
			    llenarTablaProveedores();
			    $('#fm-modal-delete').modal('hide');
			}
			else if (response.error!='') {
				$.ambiance({
			       message: response.error,
			       title: "ERROR! ",
			       type: "error"
			    });
			    $('#fm-modal-delete').modal('hide');
			}
		},
		error:function(result){
			console.log('ERROR ' + result.status + ' ' + result.statusText);
		}
		
	});
}
//LIMPIAR CAMPOS
function limpiarCampos(tipo){						//limpia el contenido de los controles, en este caso se usó la misma función para limpiar
	$('#id-'+tipo+'-nombre').val('');				//los campos del agregar y editar por eso se pasa tipo como parámetro.
	$('#id-'+tipo+'-direccion').val('');
	$('#id-'+tipo+'-email').val('');
	$('#id-'+tipo+'-telefono').val('');
}

//CONFIRMAR ELIMINACION
function confirElimina(id,nombreProv){
	//Esta función recibe el id y el nombre del empleado a eliminar para luego mostrarselo al usuario.
	$('#id-del-Codigo').val(id);																	//se escribe el id en el  <input type="hidden" name="" id="id-del-Codigo" > del formulario eliminarEmpleado.jsp
	var mensaje='<button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
    			'<span aria-hidden="true">&times;</span></button>';									//esto no se usa
	$('.dialog-content').empty();																	//primero limpiamos el <div class="alert alert-danger dialog-content"></div>
	$('.dialog-content').html('<p>Está seguro de eliminar a <strong>'+nombreProv+'</strong> permanentemente?.</p>'); //luego escribimos dentro el nombre del empleado a eliminar
}
//SELECCIONAR EMPLEADO
function seleccionProveedor(id,nombre,direccion,email,telefono){
	//Esta funcion recibe todos los campos del empleado a editar y los escribe es los controles.

	$('#id-edit-codigo').val(id);
	$('#id-edit-nombre').val(nombre);
	$('#id-edit-direccion').val(direccion);
	$('#id-edit-email').val(email);
	$('#id-edit-telefono').val(telefono);
	
}

