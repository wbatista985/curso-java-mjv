package easy.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import easy.job.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
	
	Profissional findByNome(String nome);
	
	//SELECT p FROM Profissional p WHERE nome = :nome;
	
	//SELECT * from tab_profissional where nome = ?;
	
	//estude sobre Query Methods e Query Override
	
}
