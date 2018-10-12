package com.api.pharmaPOS.dao.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.api.pharmaPOS.dao.GenericDAO;
import com.api.pharmaPOS.entity.SalesOrder;

public class SalesOrderDAO implements GenericDAO<SalesOrder, Integer> {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public void insertar(SalesOrder entidad) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entidad);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
	}

	@Override
	public void modificar(SalesOrder entidad) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entidad);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SalesOrder> listarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalesOrder buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
