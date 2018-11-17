<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="fm-modal-add-pro" tabindex="-1" role="dialog"
	aria-labelledby="fm-modal" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		
			<div class="modal-content">
				<div class="modal-header p-3 mb-2 bg-primary text-white">
					<h5 class="modal-title">Agregar Producto</h5>
					<button class="close" data-dismiss="modal" aria-label="Cerrar">
					</button>
				</div>
				<!--Modal Body-->
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-6">
							<label class="form-control-label" for="txtaddnombre">Nombre:</label>							
							<input type="text" class="form-control"	placeholder="Nombre" name="txtnombre" id="id-add-nombre">
													
							<label class="form-control-label" for="">Precio:</label>							
							<input type="text" class="form-control"	placeholder="Precio" name="txtprecio" id="id-add-precio">
							

							<label class="form-control-label" for="">Stock:</label>							
							<input type="text" class="form-control"	placeholder="Stock" name="txtstock" id="id-add-stock">

						</div>
						<div class="col-md-6">

							<label class="form-control-label" for="">Categoria:</label>							
							<select id="id-add-cmbcategoria" name="cmbcategoria" class="form-control">
							</select>		
					

							<label class="form-control-label" for="">Proveedor:</label>							
							<select id="id-add-cmbproveedor" name="cmbproveedor" class="form-control">
							</select>
							
							<label class="form-control-label" for="">Laboratorio:</label>							
							<select id="id-add-cmblaboratorio" name="cmblaboratorio" class="form-control">
							</select>						
					
						</div>
					</div>

					

				</div>
				<!--END Modal Body-->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<input type="submit" class="btn btn-primary"
						id="savepro" form="mfrmaddproducto" value="Guardar" onclick="agregarProducto()">
				</div>

			</div>		
	</div>

</div>