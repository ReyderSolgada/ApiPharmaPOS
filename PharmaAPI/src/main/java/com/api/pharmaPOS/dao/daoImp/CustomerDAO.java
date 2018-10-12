package com.api.pharmaPOS.dao.daoImp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.pharmaPOS.dao.GenericDAO;
import com.api.pharmaPOS.entity.Customer;

public class CustomerDAO implements GenericDAO<Customer, Integer> {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public void insertar(Customer entidad) {
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
	public void modificar(Customer entidad) {
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
			Customer cus = em.find(Customer.class, id);
			em.getTransaction().begin();
			em.remove(cus);
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
	public List<Customer> listarTodo() {
		EntityManager em = factory.createEntityManager();
		List<Customer> listCustomer = null;
		String query = "SELECT c FROM Customer c";
		try {
			TypedQuery<Customer> q = em.createQuery(query, Customer.class);
			listCustomer = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return listCustomer;
	}

	@Override
	public Customer buscar(Integer id) {
		EntityManager em = factory.createEntityManager();
		Customer cus = null;
		try {
			cus = em.find(Customer.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return cus;
	}

}
