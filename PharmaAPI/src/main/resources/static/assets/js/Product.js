/**
 * Methods Employess
 */
 //LISTAR EMPLEADO
 $(document).ready(function(){
   llenarTablaProductos();
});
 
 llenarTablaProductos=function(){
	$.ajax({
		url: 'http://localhost:8090/api/ProductList',
		type: 'GET',
		datatype: 'json',
		success: function(datos) {
			if(datos != ''){
				limpiarTabla();
				var tbody='';
				for(var i=0; i<datos.length; i++){
					var productId 	= datos[i].productId;
					var productName = datos[i].description;
					var price		= datos[i].price;
					var stock		= datos[i].stock;
					var codtippro	= datos[i].categoryProduct.categoryId;
					var nomtippro	= datos[i].categoryProduct.name;
					var codprov		= datos[i].supplierProduct.supplierId;
					var nomprov 	= datos[i].supplierProduct.name;
					var codlab		= datos[i].laboratoryProduct.laboratoryId;
					var nomlab		= datos[i].laboratoryProduct.name;

					var param		=productId+"\',\'"+
									 productName+"\',\'"+
									 price+"\',\'"+
									 stock+"\',\'"+
									 codtippro+"\',\'"+
									 codprov+"\',\'"+
									 codlab;
					
					tbody+='<tr>';
					tbody+='<td><span class="text-muted">'+productId+'</span></td>';
					tbody+='<td>'+productName+'</td>';
					tbody+='<td>'+price+'</td>';
					tbody+='<td>'+stock+'</td>';
					tbody+='<td>'+nomtippro+'</td>';
					tbody+='<td>'+nomprov+'</td>';
					tbody+='<td>'+nomlab+'</td>';
					tbody+="<td><a href='#' class='btn btn-success' data-toggle='modal' data-target='#fm-modal-edit-prod' onclick=\"seleccionProducto(\'"+param+"\')\">Editar</a></td>";
					tbody+="<td><a href='#' class='btn btn-danger' data-toggle='modal' data-target='.bd-confirm-modal-sm' onclick=\"confirElimina(\'"+productId+"\',\'"+productName+"\')\">Eliminar</a></td>";
					tbody+='</tr>';

				}
				$('#tblproductos tbody').append(tbody);
			}
		},
				 error: function(result){
                    console.log('ERROR ' + result.status + ' ' + result.statusText);
                }
	}); 
	
	function limpiarTabla(){
		$('#tblproductos tbody tr').remove();
	}
};

//AGREGAR PRODUCTO
function agregarProducto(){
	var nombre		=$('#id-add-nombre').val().trim();
	var precio		=$('#id-add-precio').val().trim();
	var stk			=$('#id-add-stock').val().trim();
	var codCat		=$('#id-add-cmbcategoria').val();
	var codProv		=$('#id-add-cmbproveedor').val();
	var codLab		=$('#id-add-cmblaboratorio').val();


	var Product={
					description:nombre,
					price:precio,
					stock:stk,
					categoryProduct:{
						categoryId:codCat
					},
					supplierProduct:{
						supplierId:codProv
					},
					laboratoryProduct:{
						laboratoryId:codLab
					}
				};

	console.log(JSON.stringify(Product));				
	
	$.ajax({
		url:'http://localhost:8090/api/ProductAdd',	
		type:'POST',									
		contentType:'application/json; charset=utf-8',	
		data:JSON.stringify(Product),					

		success:function(response){						
			if(response.success!= ''){					
				$.ambiance({							
			       message: response.success,			
			       title: "Éxito! ",					
			       type: "success"
			    });
			    llenarTablaProductos();					
			    limpiarCampos('add');					
			}
			else if (response.error!= '') {				
				$.ambiance({							
			       message: response.error,
			       title: "ERROR! ",
			       type: "error"
			    });
			}
		},
		error:function(result){							
			console.log('ERROR ' + result.status + ' ' + result.statusText); 
		}
		
	});

};	

//EDITAR PRODUCTO
function editarProducto(){								
		var id 			=$('#id-edit-codigo').val();
		var nombre		=$('#id-edit-nombre').val();
		var precio		=$('#id-edit-precio').val();
		var stk			=$('#id-edit-stock').val();
		var codCat		=$('#id-edit-cmbcategoria').val();
		var codProv		=$('#id-edit-cmbproveedor').val();
		var codLab		=$('#id-edit-cmblaboratorio').val();
		
		var Product={
						description:nombre,
						price:precio,
						stock:stk,
						categoryProduct:{
							categoryId:codCat
						},
						supplierProduct:{
							supplierId:codProv
						},
						laboratoryProduct:{
							laboratoryId:codLab
						}
					};
	
		console.log(JSON.stringify(Product));

		$.ajax({
		url:'http://localhost:8090/api/ProductUpdate/'+id,		
		type:'PUT',													
		contentType:'application/json; charset=utf-8',
		data:JSON.stringify(Product),

		success:function(response){
			if(response.success!=''){
				$.ambiance({
			       message: response.success,
			       title: "Éxito! ",
			       type: "success"
			    });
			    llenarTablaProductos();
			    limpiarCampos('edit');
			}
			else if (response.error!='') {
				$.ambiance({
			       message: response.error,
			       title: "ERROR! ",
			       type: "error"
			    });
			}
		},
		error:function(result){
			console.log('ERROR ' + result.status + ' ' + result.statusText);
		}
		
	});
}
//ELIMINAR PRODUCTO
function eliminarProducto(){	
	var id 	= $('#id-del-Codigo').val();
	
	$.ajax({
		url:'http://localhost:8090/api/ProductDelete/'+id,		
		type:'DELETE',											
		datatype:'json',										

		success:function(response){
			if(response.success!=''){
				$.ambiance({
			       message: response.success,
			       title: "Éxito! ",
			       type: "success"
			    });
			    llenarTablaProductos();
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
function limpiarCampos(tipo){						
	$('#id-'+tipo+'-nombre').val('');				
	$('#id-'+tipo+'-precio').val('');
	$('#id-'+tipo+'-stock').val('');
	$('#id-'+tipo+'-cmbcategoria option[value="1"]').attr('selected', true);
	$('#id-'+tipo+'-cmbproveedor option[value="1"]').attr('selected', true);
	$('#id-'+tipo+'-cmblaboratorio option[value="1"]').attr('selected', true);
	
}
//CONFIRMAR ELIMINACION
function confirElimina(id,nombre){
	$('#id-del-Codigo').val(id);																	
	var mensaje='<button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
    			'<span aria-hidden="true">&times;</span></button>';									
	$('.dialog-content').empty();																	
	$('.dialog-content').html('<p>Está seguro de eliminar a <strong>'+nombre+'</strong> permanentemente?.</p>'); 
}
//SELECCIONAR PRODUCTO
function seleccionProducto(id,nombre,precio,stock,codcat,codprov,codlab){
	cargarCombosX('#id-edit-cmbcategoria','#id-edit-cmbproveedor','#id-edit-cmblaboratorio');

	$('#id-edit-codigo').val(id);
	$('#id-edit-nombre').val(nombre);
	$('#id-edit-precio').val(precio);
	$('#id-edit-stock').val(stock);
	$('#id-edit-cmbcategoria option[value="'+codcat+'"]').attr('selected', true);
	$('#id-edit-cmbproveedor option[value="'+codprov+'"]').attr('selected', true);
	$('#id-edit-cmblaboratorio option[value="'+codlab+'"]').attr('selected', true);
	
}
//CARGAR COMBOS
cargarCombosX=function(cmbCategoria,cmbProveedor,cmbLaboratorio){
	$.ajax({
		url:'http://localhost:8090/api/categories',
		type:'GET',
		datatype:'json',
		success:function(response1){
			if(response1 !=''){			
				$(cmbCategoria).empty();				
				for(var i=0; i<=response1.length;i ++){	
					$(cmbCategoria).append('<option value="'+response1[i].categoryId+'">'+response1[i].name+'</option>'); 
					console.log(response1);
				}
			}
			
		}
		
	});
	
	$.ajax({
		url:'http://localhost:8090/api/suppliers',
		type:'GET',
		datatype:'json',
		success:function(response2){
			if(response2 !=''){			
				$(cmbProveedor).empty();				
				for(var i=0; i<=response2.length;i ++){	
					$(cmbProveedor).append('<option value="'+response2[i].supplierId+'">'+response2[i].name+'</option>'); 
				}
			}
			
		}
		
	});
	
	$.ajax({
		url:'http://localhost:8090/api/laboratories',
		type:'GET',
		datatype:'json',
		success:function(response3){
			if(response3 !=''){			
				$(cmbLaboratorio).empty();			
				for(var i=0; i<=response3.length;i ++){	
					$(cmbLaboratorio).append('<option value="'+response3[i].laboratoryId+'">'+response3[i].name+'</option>'); 
				}
			}
			
		}
		
	});

};

