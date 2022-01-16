package easy.job.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import easy.job.model.Profissao;
import easy.job.util.EntityManagerFactory;

public class ProfissaoRepository {

	// JPA Connection
	private EntityManager connection = EntityManagerFactory.getConexao();

	public void save(Profissao profissao) {
		connection.getTransaction().begin();
		connection.persist(profissao);
		connection.getTransaction().commit();

	}

	public void update(Profissao profissao) {
		connection.getTransaction().begin();
		connection.merge(profissao);
		connection.getTransaction().commit();
	}

	public void delete(Integer id) {
		Profissao profissao = findById(id);
		if (profissao != null)
			connection.remove(profissao);
	}

	public Profissao findById(Integer id) {
		Profissao profissao = connection.find(Profissao.class, id);
		return profissao;
	}

	public Profissao findByNome(String nome) {
		Profissao profissao = null;
		// JPQL
		String sql = "SELECT p FROM Profissao p WHERE nome = :nome";
		try {
			Query query = connection.createQuery(sql);
			query.setParameter("nome", nome);

			profissao = (Profissao) query.getSingleResult();
		} catch (NoResultException nre) {
			System.out.println("Nao achei alguém com esse nome");
		}

		return profissao;

	}

	public List<Profissao> listAll() {
		// JPQL
		String sql = "SELECT p FROM Profissao p";
		Query query = connection.createQuery(sql);
		
		List<Profissao> profissoes = query.getResultList();

		return profissoes;

	}
}
