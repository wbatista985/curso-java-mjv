package com.mjv.fichacadastral;

import com.mjv.fichacadastral.dao.ProfissaoDao;
import com.mjv.fichacadastral.model.Profissao;

public class FichaCadastralApplication {
	public static void main(String[] args) {
		exemploAlterarPorId();
	}
	static void exemploSalvar() {
		Profissao p = new Profissao();
		p.setNome("ANALISTA DE DADOS");
		
		ProfissaoDao dao = new ProfissaoDao();
		dao.save(p);
	}
	static void exemploAlterarPorId() {
		ProfissaoDao dao = new ProfissaoDao();
		
		Profissao p = dao.findById(2);
		
		p.setNome("WEB DESIGNER");
		
		dao.update(p);
	}
	static void exemploAlterar() {
		Profissao p = new Profissao();
		p.setId(1);
		p.setNome("PROGRAMADOR JAVA JR");
		
		ProfissaoDao dao = new ProfissaoDao();
		dao.update(p);
	}
}
