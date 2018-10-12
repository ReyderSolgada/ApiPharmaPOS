package com.api.pharmaPOS.dao.daoImp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.pharmaPOS.dao.GenericDAO;
import com.api.pharmaPOS.entity.Product;

public class ProductDAO implements GenericDAO<Product, Integer> {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public void insertar(Product entidad) {
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
	public void modificar(Product entidad) {
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
			Product pro = em.find(Product.class, id);
			em.getTransaction().begin();
			em.remove(pro);
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
	public List<Product> listarTodo() {
		EntityManager em = factory.createEntityManager();
		List<Product> listProduct = null;
		String query = "SELECT p FROM Product p";
		try {
			TypedQuery<Product> q = em.createQuery(query, Product.class);
			listProduct = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return listProduct;
	}

	@Override
	public Product buscar(Integer id) {
		EntityManager em = factory.createEntityManager();
		Product pro = null;
		try {
			pro = em.find(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return pro;
	}

}
