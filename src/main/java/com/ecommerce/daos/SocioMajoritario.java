package com.ecommerce.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SocioMajoritario {

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

	public SocioMajoritario salvar(SocioMajoritario sociomajoritario) throws Exception {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			System.out.println("Salvando a pessoa.");
			if (sociomajoritario.getEntityManager() == null) {
				entityManager.persist(sociomajoritario);
			} else {
				sociomajoritario = entityManager.merge(sociomajoritario);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return sociomajoritario;
	}

	public void excluir(Long id) {
		EntityManager entityManager = getEntityManager();
		try {

			SocioMajoritario socioMajoritario = consultarPorId(id);
			System.out.println("Excluindo a pessoa: " + socioMajoritario.getEntityManager());
			entityManager.remove(socioMajoritario);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	public SocioMajoritario consultarPorId(Long id) {
		EntityManager entityManager = getEntityManager();
		SocioMajoritario socioMajoritario = null;
		try {
			socioMajoritario = entityManager.find(SocioMajoritario.class, id);
		} finally {
			entityManager.close();
		}
		return socioMajoritario;
	}
}
