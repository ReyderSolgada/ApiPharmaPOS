<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="modal fade" id="fm-modal-edit-sup" tabindex="-1" role="dialog"
	aria-labelledby="fm-modal" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		
			<div class="modal-content">
				<div class="modal-header p-3 mb-2 bg-primary text-white">
					<h5 class="modal-title" id="idtitulo">Editar Proveedor</h5>
					<button class="close" data-dismiss="modal" aria-label="Cerrar">
					</button>
				</div>
				<!--Modal Body-->
				<div class="modal-body">
					<div class="row" >
						<div class="col-lg-2"> <label class="form-control-label">Código:</label> </div>
						<div class="col-lg-4"> <input type="text" name="" id="id-edit-codigo" class="form-control" readonly="readonly"> </div>
						<br>
					</div>
					
					<div class="row">
						<div class="col-lg-12">
							<label class="form-control-label" for="txtaddnombre">Nombre:</label>							
							<input type="text" class="form-control"	placeholder="Nombre" name="txtnombre" id="id-edit-nombre">
													
							<label class="form-control-label" for="">Dirección:</label>							
							<input type="text" class="form-control"	placeholder="Dirección" name="txtdireccion" id="id-edit-direccion">
							
							<label class="form-control-label" for="">Email:</label>							
							<input type="text" class="form-control"	placeholder="Email:" name="txtemail" id="id-edit-email">

							<label class="form-control-label" for="">Teléfono:</label>							
							<input type="text" class="form-control"	placeholder="Teléfono" name="txt_telefono" id="id-edit-telefono">
							
							
					
						</div>
				
					</div>
					

				</div>
				<!--END Modal Body-->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<input type="submit" class="btn btn-primary"
						id="savepro" form="mfrmaddproveedor" value="Guardar" onclick="editarProveedor()">
				</div>

			</div>		
	</div>

</div>