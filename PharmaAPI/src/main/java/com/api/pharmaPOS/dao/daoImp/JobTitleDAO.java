package com.api.pharmaPOS.dao.daoImp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.pharmaPOS.dao.GenericDAO;
import com.api.pharmaPOS.entity.JobTitle;

public class JobTitleDAO implements GenericDAO<JobTitle, Integer> {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public void insertar(JobTitle entidad) {
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
	public void modificar(JobTitle entidad) {
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
			JobTitle job = em.find(JobTitle.class, id);
			em.getTransaction().begin();
			em.remove(job);
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
	public List<JobTitle> listarTodo() {
		EntityManager em = factory.createEntityManager();
		List<JobTitle> listJobTitle = null;
		String query = "SELECT j FROM JobTitle j";
		try {
			TypedQuery<JobTitle> q = em.createQuery(query, JobTitle.class);
			listJobTitle = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return listJobTitle;
	}

	@Override
	public JobTitle buscar(Integer id) {
		EntityManager em = factory.createEntityManager();
		JobTitle job = null;
		try {
			job = em.find(JobTitle.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return job;
	}

}
