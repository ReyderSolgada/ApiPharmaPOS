/**
 * Methods Employess
 */
 //LISTAR EMPLEADO
$(document).ready(function(){
   llenarTablaEmpleados();
});

 llenarTablaEmpleados=function(){
	$.ajax({
		url: 'http://localhost:8090/api/EmployeeList',
		type: 'GET',
//		data: "EmployeeList",
		datatype: 'json',
		success: function(datos) {
			if(datos != ''){
				limpiarTabla();
				var tbody='';
				for(var i=0; i<datos.length; i++){
					var employeeId 	= datos[i].employeeId;
					var firstName 	= datos[i].firstName;
					var middleName	= datos[i].middleName;
					var lastName	= datos[i].lastName;
					var fecContr	= datos[i].hireDate;
					var dni			= datos[i].dni;
					var sex			= datos[i].sex;
					var fono		= datos[i].phone;
					var address		= datos[i].address;
					var nomDist		= datos[i].districtEmployee.name;
					var coddis 		= datos[i].districtEmployee.districtId;
					var salary		= datos[i].salary;
					var nomCargo	= datos[i].jobTitleEmployee.name;
					var codcargo 	= datos[i].jobTitleEmployee.jobTitleId;

					//param: alamacenará todos los campos de la entidad Employee separados por una coma, ya que estos son parámetros 
					//que se utilizará abajo en el botón editar.
					var param		=employeeId+"\',\'"+firstName+"\',\'"+middleName+"\',\'"+lastName+"\',\'"+
									 fecContr+"\',\'"+dni+"\',\'"+sex+"\',\'"+fono+"\',\'"+address+"\',\'"+salary+"\',\'"+coddis+"\',\'"+codcargo;
					
					tbody+='<tr>';
					tbody+='<td><span class="text-muted">'+employeeId+'</span></td>';
					tbody+='<td>'+firstName+' '+middleName+' '+lastName +'</td>';
					tbody+='<td>'+fecContr+'</td>';
					tbody+='<td>'+dni+'</td>';
					tbody+='<td>'+sex+'</td>';
					tbody+='<td>'+fono+'</td>';
					tbody+='<td>'+address+'</td>';
					tbody+='<td>'+salary+'</td>';
					tbody+='<td>'+nomDist+'</td>';
					tbody+='<td>'+nomCargo+'</td>';
/*boton editar*/	tbody+="<td><a href='#' class='btn btn-success' data-toggle='modal' data-target='#fm-modal-edit-emp' onclick=\"seleccionEmpleado(\'"+param+"\')\">Editar</a></td>";
/*boton eliminar*/	tbody+="<td><a href='#' class='btn btn-danger' data-toggle='modal' data-target='.bd-confirm-modal-sm' onclick=\"confirElimina(\'"+employeeId+"\',\'"+firstName+' '+middleName+"\')\">Eliminar</a></td>";
					tbody+='</tr>';
					//El btn editar hace la llamada desde el onclick a la función seleccionEmpleado(param) con los parámetros que se utilizarán para cargar los controles de editarEmpleado.jsp
					//El btn eliminar llama a la función confirmElimina(employeeId,firstName+middleName) se envia el id y el nombre, este último campo será para informar al usuario que el emnpleado va a ser borrado
					//este valor se cargará en eliminarEmpleado.jsp
				}
				//console.log(tbody);
				$('#tblempleados tbody').append(tbody);
			}
		},
				 error: function(result){
                    console.log('ERROR ' + result.status + ' ' + result.statusText);
                }
	}); 
	
	function limpiarTabla(){
		$('#tblempleados tbody tr').remove();
	}
};
//AGREGAR EMPLEADO
function agregarEmpleado(){
	//Almaceno en variables el contenido a guardar
	var nombres		=$('#id-add-nombres').val().trim();
	var apepater	=$('#id-add-appaterno').val().trim();
	var apemater	=$('#id-add-apmaterno').val().trim();
	var fechaIng	=$('#id-add-fechaing').val().trim();
	var dni			=$('#id-add-Dni').val().trim();
	var sexo 		=$('#id-add-cmbsexo').val();
	var correo 		=$('#id-add-email').val();
	var telef		=$('#id-add-telefono').val().trim();
	var direcc		=$('#id-add-direccion').val().trim();
	var salario		=$('#id-add-salario').val().trim();
	var codDistrito	=$('#id-add-cmbdistrito').val();
	var codCargo	=$('#id-add-cmbcargo').val();

	//Luego se almacenará en una variable tipo array los valores
	//(los nombres en la parte izquierda del array deben ser iguales a la entidad tanto en mayúsculas como en minúsculas)
	var Employee={
					firstName:nombres,
					middleName:apepater,
					lastName:apemater,
					hireDate:fechaIng,
					dni:dni,
					sex:sexo,
					phone:telef,
					email:correo,
					address:direcc,
					salary:salario,
					jobTitleEmployee:{					//Como el controller en la Api recibe un objeto para el JobTitle
								jobTitleId:codCargo		//se crea un nuevo array para enviar el campo que se quiere guardar
									},
					districtEmployee:{
								districtId:codDistrito
									}
				};

	console.log(JSON.stringify(Employee));				//Imprimir en consola el Array convertido a JSON (esto para Pruebas)
	
	$.ajax({
		url:'http://localhost:8090/api/EmployeeAdd',	//URL que recibirá la data
		type:'POST',									
		contentType:'application/json; charset=utf-8',	
		data:JSON.stringify(Employee),					//Enviar la data convertido a JSON variable Employee

		success:function(response){						//succes: función que devuelve la rspta enviada desde el método en la api.
			if(response.success!= ''){					//response puede ser cualquier nombre, pero .success debe ser el mismo nombre
				$.ambiance({							//que se envia desde la Api. En este caso la Api devuelve un objeto con dos atributos
			       message: response.success,			//success y error. Solo uno de ellos volverá con valor.
			       title: "Éxito! ",					//En el primer If se muestra un mensaje como respuesta en caso el mensaje tenga éxito.
			       type: "success"
			    });
			    llenarTablaEmpleados();					//volvemos a cargar la tabla
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

//EDITAR EMPLEADO
function editarEmpleado(){								//Esta función hace lo mismo que el agregarEmpleado	
		var id 			=$('#id-edit-codigo').val();
		var nombres		=$('#id-edit-nombres').val();
		var apepater	=$('#id-edit-appaterno').val();
		var apemater 	=$('#id-edit-apmaterno').val();
		var fechaIng	=$('#id-edit-fechaing').val();
		var dni 		=$('#id-edit-Dni').val();
		var sexo 		=$('#id-edit-cmbsexo').val();
		var telef 		=$('#id-edit-telefono').val();
		var direcc 		=$('#id-edit-direccion').val();
		var salario 	=$('#id-edit-salario').val();
		var codDistrito	=$('#id-edit-cmbdistrito').val();
		var codCargo	=$('#id-edit-cmbcargo').val();

		var Employee={
					firstName:nombres,
					middleName:apepater,
					lastName:apemater,
					hireDate:fechaIng,
					dni:dni,
					sex:sexo,
					phone:telef,
					address:direcc,
					salary:salario,
					jobTitleEmployee:{
								jobTitleId:codCargo
									},
					districtEmployee:{
								districtId:codDistrito
									}
				};
		console.log(JSON.stringify(Employee));

		$.ajax({
		url:'http://localhost:8090/api/EmployeeUpdate/'+id,			//URL: aquí se el agrega el parámetro id al final de la url
		type:'PUT',													
		contentType:'application/json; charset=utf-8',
		data:JSON.stringify(Employee),

		success:function(response){
			if(response.success!=''){
				$.ambiance({
			       message: response.success,
			       title: "Éxito! ",
			       type: "success"
			    });
			    llenarTablaEmpleados();
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
//ELIMINAR EMPLEADO
function eliminarEmpleado(){	
	//Esta función lee el <input type="hidden" name="" id="id-del-Codigo" > que está oculto para el usuario  en formulario eliminarEmpleado.jsp		
	var id 	= $('#id-del-Codigo').val();
	
	$.ajax({
		url:'http://localhost:8090/api/EmployeeDelete/'+id,		//Agregamos el id al final de la URl
		type:'DELETE',											//En este caso no enviamos ninguna data, con excepción del Id en la URL
		datatype:'json',										//Pero sí vamos a recibir un Json como rspt

		success:function(response){
			if(response.success!=''){
				$.ambiance({
			       message: response.success,
			       title: "Éxito! ",
			       type: "success"
			    });
			    llenarTablaEmpleados();
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
	$('#id-'+tipo+'-nombres').val('');				//los campos del agregar y editar por eso se pasa tipo como parámetro.
	$('#id-'+tipo+'-appaterno').val('');
	$('#id-'+tipo+'-apmaterno').val('');
	$('#id-'+tipo+'-fechaing').val('');
	$('#id-'+tipo+'-Dni').val('');
	$('#id-'+tipo+'-cmbsexo option[value="M"]').attr('selected', true);
	$('#id-'+tipo+'-telefono').val('');
	$('#id-'+tipo+'-direccion').val('');
	$('#id-'+tipo+'-salario').val('');
	$('#id-'+tipo+'-cmbdistrito option[value="1"]').attr('selected', true);
	$('#id-'+tipo+'-cmbcargo option[value="1"]').attr('selected', true);
	
}
//CONFIRMAR ELIMINACION
function confirElimina(id,nombreEmp){
	//Esta función recibe el id y el nombre del empleado a eliminar para luego mostrarselo al usuario.
	$('#id-del-Codigo').val(id);																	//se escribe el id en el  <input type="hidden" name="" id="id-del-Codigo" > del formulario eliminarEmpleado.jsp
	var mensaje='<button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
    			'<span aria-hidden="true">&times;</span></button>';									//esto no se usa
	$('.dialog-content').empty();																	//primero limpiamos el <div class="alert alert-danger dialog-content"></div>
	$('.dialog-content').html('<p>Está seguro de eliminar a <strong>'+nombreEmp+'</strong> permanentemente?.</p>'); //luego escribimos dentro el nombre del empleado a eliminar
}
//SELECCIONAR EMPLEADO
function seleccionEmpleado(id,nombre,apepater,apemater,fechaIng,dni,sexo,telf,direcc,salario,coddis,codcargo){
	//Esta funcion recibe todos los campos del empleado a editar y los escribe es los controles.
	cargarCombos('#id-edit-cmbdistrito','#id-edit-cmbcargo');

	$('#id-edit-codigo').val(id);
	$('#id-edit-nombres').val(nombre);
	$('#id-edit-appaterno').val(apepater);
	$('#id-edit-apmaterno').val(apemater);
	$('#id-edit-fechaing').val(fechaIng);
	$('#id-edit-Dni').val(dni);
	$('#id-edit-cmbsexo option[value="'+sexo+'"]').attr('selected', true);
	$('#id-edit-telefono').val(telf);
	$('#id-edit-direccion').val(direcc);
	$('#id-edit-salario').val(salario);
	$('#id-edit-cmbdistrito option[value="'+coddis+'"]').attr('selected', true);
	$('#id-edit-cmbcargo option[value="'+codcargo+'"]').attr('selected', true);
	
}
//CARGAR COMBOS
cargarCombos=function(cmbDist,cmbCargo){
	//Esta función carga los combos de districts y jobtitles
	//es lo mismo que llenarTablaEmpleados(), recibe dos parámetros porque se utiliza la misma función para editar y agregar
	$.ajax({
		url:'http://localhost:8090/api/districts',
		type:'GET',
		datatype:'json',
		success:function(response){
			if(response !=''){			
				$(cmbDist).empty();				//Primero limpiamos el control <select
				for(var i=0; i<=response.length;i ++){	
					$(cmbDist).append('<option value="'+response[i].districtId+'">'+response[i].name+'</option>'); 
					//con la función append escribimos fila por fila el contenido del select los <option
				}
			}
			
		}
		
	});
	
	$.ajax({
		url:'http://localhost:8090/api/jobtitles',
		type:'GET',
		datatype:'json',
		success:function(response2){
			if(response2 !=''){				
				$(cmbCargo).empty();
				for(var i=0; i<=response2.length;i ++){
					$(cmbCargo).append('<option value="'+response2[i].jobTitleId+'">'+response2[i].name+'</option>');
				}
			}
		}
		
	});

};

//$('.dp-fecha').datetimepicker({
//	language: "es",
//	todayBtn: 1,
//	autoclose: 1,
//	format: 'yyyy-mm-dd',
//	startView: 2,
//	minView: 2,
//	todayHighlight: true
//});

