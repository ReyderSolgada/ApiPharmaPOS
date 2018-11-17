<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal bd-confirm-modal-sm" tabindex="-1" role="dialog" id="fm-modal-delete">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Confirmación</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <input type="hidden" name="" id="id-del-Codigo" >
      <div class="alert alert-danger dialog-content"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">cancelar</button>
        <button type="button" class="btn btn-danger" onclick="eliminarProveedor()">Eliminar</button>
      </div>
    </div>
  </div>
</div>