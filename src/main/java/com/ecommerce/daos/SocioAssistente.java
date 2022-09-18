package com.ecommerce.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SocioAssistente {
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		try {

			factory = Persistence.createEntityManagerFactory("ExemplosJPAPU");

			entityManager = factory.createEntityManager();

		} finally {
			factory.close();
		}
		return entityManager;
	}

	public SocioAssistente salvar(SocioAssistente socioAssistente) throws Exception {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			System.out.println("Salvando a pessoa.");
			if (socioAssistente.getEntityManager() == null) {
				entityManager.persist(socioAssistente);
			} else {
				socioAssistente = entityManager.merge(socioAssistente);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return socioAssistente;
	}

	public void excluir(Long id) {
		EntityManager entityManager = getEntityManager();
		try {

			SocioAssistente socioAssistente = consultarPorId(id);
			System.out.println("Excluindo a pessoa: " + socioAssistente.getEntityManager());
			entityManager.remove(socioAssistente);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	public SocioAssistente consultarPorId(Long id) {
		EntityManager entityManager = getEntityManager();
		SocioAssistente socioAssistente = null;
		try {
			socioAssistente= entityManager.find(SocioAssistente.class, id);
		} finally {
			entityManager.close();
		}
		return socioAssistente;
	}
	
	
}
