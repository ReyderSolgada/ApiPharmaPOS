package com.api.pharmaPOS.dao;

import java.util.List;

public interface GenericDAO<T, K> {

	public void insertar(T entidad);

	public void modificar(T entidad);

	public void eliminar(K id);

	public List<T> listarTodo();

	public T buscar(K id);

}
