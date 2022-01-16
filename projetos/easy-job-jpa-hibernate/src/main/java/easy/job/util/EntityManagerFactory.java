package easy.job.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {
	private static EntityManager conexao; //em ou entityManager

	//simulando o conceito de container como Java EE e Spring
	static {
		conectar();
	}
	
	//padrao singleton
	private static void conectar() {
		try {
			conexao = Persistence.createEntityManagerFactory("EASY_JOB_PU").createEntityManager();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
		
	}
	
	public static EntityManager getConexao() {
		return conexao;
	}
}
