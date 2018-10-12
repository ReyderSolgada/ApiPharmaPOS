package com.api.pharmaPOS.dao.daoImp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.pharmaPOS.dao.GenericDAO;
import com.api.pharmaPOS.entity.Laboratory;

public class LaboratoryDAO implements GenericDAO<Laboratory, Integer> {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public void insertar(Laboratory entidad) {
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
	public void modificar(Laboratory entidad) {
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
		EntityManager em = factory.createEntityManager();
		try {
			Laboratory lab = em.find(Laboratory.class, id);
			em.getTransaction().begin();
			em.remove(lab);
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
	public List<Laboratory> listarTodo() {
		EntityManager em = factory.createEntityManager();
		List<Laboratory> listLaboratory = null;
		String query = "SELECT l FROM Laboratory l";
		try {
			TypedQuery<Laboratory> q = em.createQuery(query, Laboratory.class);
			listLaboratory = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return listLaboratory;
	}

	@Override
	public Laboratory buscar(Integer id) {
		EntityManager em = factory.createEntityManager();
		Laboratory lab = null;
		try {
			lab = em.find(Laboratory.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return lab;
	}

}
