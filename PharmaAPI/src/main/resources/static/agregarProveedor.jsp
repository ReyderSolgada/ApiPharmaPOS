<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="fm-modal-add-sup" tabindex="-1" role="dialog"
	aria-labelledby="fm-modal" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		
			<div class="modal-content">
				<div class="modal-header p-3 mb-2 bg-primary text-white">
					<h5 class="modal-title">Agregar Proveedor</h5>
					<button class="close" data-dismiss="modal" aria-label="Cerrar">
					</button>
				</div>
				<!--Modal Body-->
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<label class="form-control-label" for="txtaddnombre">Nombre:</label>							
							<input type="text" class="form-control"	placeholder="Nombre" name="txtnombre" id="id-add-nombre">
													
							<label class="form-control-label" for="">Dirección:</label>							
							<input type="text" class="form-control"	placeholder="Dirección" name="txtdireccion" id="id-add-direccion">
							
							<label class="form-control-label" for="">Email:</label>							
							<input type="text" class="form-control"	placeholder="Email:" name="txtemail" id="id-add-email">

							<label class="form-control-label" for="">Teléfono:</label>							
							<input type="text" class="form-control"	placeholder="Teléfono" name="txt_telefono" id="id-add-telefono">
							
							
					
						</div>
					</div>
				</div>
				<!--END Modal Body-->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<input type="submit" class="btn btn-primary"
						id="savepro" form="mfrmaddproducto" value="Guardar" onclick="agregarProveedor()">
				</div>

			</div>		
	</div>

</div>