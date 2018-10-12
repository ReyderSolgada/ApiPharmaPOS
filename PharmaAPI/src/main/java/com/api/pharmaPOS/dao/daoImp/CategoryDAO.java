package com.api.pharmaPOS.dao.daoImp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.pharmaPOS.dao.GenericDAO;
import com.api.pharmaPOS.entity.Category;

public class CategoryDAO implements GenericDAO<Category, Integer> {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public void insertar(Category entidad) {
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
	public void modificar(Category entidad) {
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
			Category cat = em.find(Category.class, id);
			em.getTransaction().begin();
			em.remove(cat);
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
	public List<Category> listarTodo() {
		EntityManager em = factory.createEntityManager();
		List<Category> listCategory = null;
		String query = "SELECT c FROM Category c";
		try {
			TypedQuery<Category> q = em.createQuery(query, Category.class);
			listCategory = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return listCategory;
	}

	@Override
	public Category buscar(Integer id) {
		EntityManager em = factory.createEntityManager();
		Category cat = null;
		try {
			cat = em.find(Category.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return cat;
	}

}
