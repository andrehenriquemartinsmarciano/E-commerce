package com.ecommerce.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SocioOperacional {

	EntityManager getEntityManager() {
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

	public SocioOperacional salvar(SocioOperacional socioOperacional) throws Exception {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			System.out.println("Salvando a pessoa.");
			if (socioOperacional.getEntityManager() == null) {
				entityManager.persist(socioOperacional);
			} else {
				socioOperacional= entityManager.merge(socioOperacional);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return socioOperacional;
	}

	public void excluir(Long id) {
		EntityManager entityManager = getEntityManager();
		try {

			SocioOperacional socioOperacional = consultarPorId(id);
			System.out.println("Excluindo a pessoa: " + socioOperacional.getEntityManager());
			entityManager.remove(socioOperacional);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	public SocioOperacional consultarPorId(Long id) {
		EntityManager entityManager = getEntityManager();
		SocioOperacional socioOperacional = null;
		try {
			socioOperacional= entityManager.find(SocioOperacional.class, id);
		} finally {
			entityManager.close();
		}
		return socioOperacional;
	}
}
