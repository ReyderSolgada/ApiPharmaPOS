<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="fm-modal-add-emp" tabindex="-1" role="dialog"
	aria-labelledby="fm-modal" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		
			<div class="modal-content">
				<div class="modal-header p-3 mb-2 bg-primary text-white">
					<h5 class="modal-title">Agregar Empleado</h5>
					<button class="close" data-dismiss="modal" aria-label="Cerrar">
					</button>
				</div>
				<!--Modal Body-->
				<div class="modal-body">

						<div class="form-group row align-items-center">
							<label class="form-control-label col-lg-2 text-lg-right" for="txtaddnombres">Nombres:</label>
							<div class="col-lg-12">
								<input type="text" class="form-control" placeholder="Nombres" name="txtnombres" id="id-add-nombres">
							</div>
						</div>
					
					<div class="row">
						<div class="col-lg-6">						
							<label class="form-control-label" for="">Ap. Paterno:</label>							
							<input type="text" class="form-control"	placeholder="Ap. Paterno" name="txtaddappaterno" id="id-add-appaterno">
							

							<label class="form-control-label"	for="">Ap. Materno:</label>							
							<input type="text" class="form-control"	placeholder="Ap. Materno" name="txtaddapmaterno"	id="id-add-apmaterno">
					

							<label class="form-control-label" for="">Fecha de Ing.:</label>							
							<input type="text" class="form-control dp-fecha" placeholder="yyyy-mm-dd" name="txtaddfechaing" id="id-add-fechaing">

							<label class="form-control-label"	for="">Dni:</label>							
							<input type="text" class="form-control"	placeholder="Dni" name="txtDni"	id="id-add-Dni">
					

							<label class="form-control-label" for="">Sexo:</label>							
							<select id="id-add-cmbsexo" name="cmbasexo" class="form-control">
								<option value="M">Masculino</option>
								<option value="F">Femenino</option>

							</select>
							
							<label class="form-control-label"	for="">Email:</label>							
							<input type="text" class="form-control"	placeholder="email" name="txtEmail"	id="id-add-email">
							
						</div>
						<div class="col-md-6">
							<label class="form-control-label" for="">Teléfono:</label>							
							<input type="text" class="form-control"	placeholder="Teléfono" name="txttelefono" id="id-add-telefono">
							

							<label class="form-control-label"	for="">Dirección:</label>							
							<input type="text" class="form-control"	placeholder="Dirección" name="txtdireccion"	id="id-add-direccion">
					

							<label class="form-control-label" for="">Salario:</label>							
							<input type="text" class="form-control" placeholder="Salario" name="txtsalario" id="id-add-salario">

							<label class="form-control-label"	for="">Distrito:</label>							
							<select id="id-add-cmbdistrito" name="cmbdistrito" class="form-control">
								<option value="">Chorrillos</option>
								<option value="">Miraflores</option>
							</select>		
					

							<label class="form-control-label" for="">Cargo:</label>							
							<select id="id-add-cmbcargo" name="cmbcargo" class="form-control">
								<option value="">Administrador</option>
								<option value="">Cajero</option>
							</select>					
					
						</div>
					</div>

					

				</div>
				<!--END Modal Body-->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<input type="submit" class="btn btn-primary"
						id="saveemp" form="mfrmaddempleado" value="Guardar" onclick="agregarEmpleado()">
				</div>

			</div>		
	</div>

</div>