package com.ecommerce.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SocioOperacional {
	
	private EntityManager getEntityManager() {
	    EntityManagerFactory factory = null;
	    EntityManager entityManager = null;
	    try {
	      //Obtém o factory a partir da unidade de persistência.
	      factory = Persistence.createEntityManagerFactory
	        ("ExemplosJPAPU");
	      //Cria um entity manager.
	      entityManager = factory.createEntityManager();
	      //Fecha o factory para liberar os recursos utilizado.
	    } finally {
	      factory.close();
	    }
	    return entityManager;
	  }

	  /**
	   * Método utilizado para salvar ou atualizar as 
	   * informações de uma pessoa.
	   * @param pessoa
	   * @return
	   * @throws java.lang.Exception
	   */
	  public Pessoa salvar(Pessoa pessoa) throws Exception {
	    EntityManager entityManager = getEntityManager();
	    try {
	      // Inicia uma transação com o banco de dados.
	      entityManager.getTransaction().begin();
	      System.out.println("Salvando a pessoa.");
	      /* Verifica se a pessoa ainda não está salva 
	        no banco de dados. */
	      if(pessoa.getId() == null) {
	        entityManager.persist(pessoa);
	      } else {
	        pessoa = entityManager.merge(pessoa);
	      }
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	    return pessoa;
	  }

	  /**
	   * Método que apaga a pessoa do banco de dados.
	   * @param id
	   */
	  public void excluir(Long id) {
	    EntityManager entityManager = getEntityManager();
	    try {
	      // Inicia uma transação com o banco de dados.
	      entityManager.getTransaction().begin();
	      /* Consulta a pessoa na base de dados através 
	        do seu ID. */
	      Pessoa pessoa = consultarPorId(id);
	      System.out.println("Excluindo a pessoa: " 
	        + pessoa.getNome());

	      // Remove a pessoa da base de dados.
	      entityManager.remove(pessoa);
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	  }

	  /**
	   * Consulta o pessoa pelo ID.
	   * @param id
	   * @return o objeto Pessoa.
	   */
	  public Pessoa consultarPorId(Long id) {
	    EntityManager entityManager = getEntityManager();
	    Pessoa pessoa = null;
	    try {
	      pessoa = entityManager.find(Pessoa.class, id);
	    } finally {
	      entityManager.close();
	    }
	    return pessoa;
	  }

}
