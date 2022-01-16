package easy.job;



import java.util.List;

import easy.job.model.Profissao;
import easy.job.repository.ProfissaoRepository;

public class EasyJobApplication {
	public static void main(String[] args) {
		saveProfissao();
		updateProfissao();
		deleteProfissao();
		buscarProfissao(); 
		listarProfissoes();
	}
	
	private static ProfissaoRepository repository = new ProfissaoRepository();
	private static void listarProfissoes() {
		List<Profissao> profissoes = repository.listAll();
		
		for(Profissao p: profissoes) {
			System.out.println(p.getNome() + "--"+ p.getId());
		}
	}
	private static void buscarProfissao() {
		Profissao profissao = repository.findByNome("PROGRAMADOR");
		if(profissao!=null) {
			System.out.println(profissao.getNome() + " " + profissao.getId());
		}else {
			System.out.println("Não foi localizado a profissao com o nome PROGRAMADOR");
		}
	}
	private static void deleteProfissao() {
		repository.delete(5);
	}
	private static void saveProfissao() {
		Profissao profissao = new Profissao();
		profissao.setNome("PROGRAMADOR");
		
		repository.save(profissao);
		
	}
	private static void updateProfissao() {
		Profissao profissao = repository.findById(1);
		if(profissao==null) {
			System.out.println("Desculpa não localizamos a profissao pelo id " + 1);
			return; // aqui seria uma exce��o de neg�cio
		}
		
		profissao.setNome("PROGRAMADOR JUNIOR");
		repository.update(profissao);
	}
}
