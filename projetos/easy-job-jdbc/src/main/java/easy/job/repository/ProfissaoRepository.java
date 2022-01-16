package easy.job.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easy.job.model.Profissao;
import easy.job.util.JDBCConnectionFactory;

public class ProfissaoRepository {

	// JDBC Connection
	private Connection connection = JDBCConnectionFactory.getConexao();
	
	public void save(Profissao profissao) {
		final String sql = "insert into tab_profissao(nome) values (?)";
		try {
			Profissao existente = findByNome(profissao.getNome());
			if(existente!=null) {
				System.out.println("Desculpa j� existe uma profiss�o com nome " + existente.getNome() + " id " + existente.getId());
				return;
			}
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, profissao.getNome());
			pst.execute();
			connection.commit();
			System.out.println("Registro salvo com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(Profissao profissao) {
		final String sql = "update tab_profissao set nome = ? WHERE id = ?";
		try {	
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, profissao.getNome());
			pst.setInt(2, profissao.getId());
			pst.execute();
			connection.commit();
			System.out.println("Registro alterado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(Integer id) {
		final String sql = "delete from tab_profissao WHERE id = ?";
		try {	
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			connection.commit();
			System.out.println("Registro deletado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public Profissao findById(Integer id) { //informe os parametros e tipo de retorno correspondente
		Profissao profissao = null;
		String sql = "SELECT nome FROM tab_profissao where id = ?";
		try {	
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet result = pst.executeQuery();
			while (result.next()){
				String nome = result.getString("nome");
			    
				profissao = new Profissao();
			    profissao.setId(id);
			    profissao.setNome(nome);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return profissao;
	}
	
	public Profissao findByNome(String nome) {
		
		Profissao profissao = null;
		String sql = "SELECT id, nome FROM tab_profissao where nome = ?";
		try {	
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, nome);
			ResultSet result = pst.executeQuery();
			while (result.next()){
				profissao = new Profissao();
			    profissao.setId(result.getInt("id"));
			    profissao.setNome(result.getString(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return profissao;
	
	}
	public List<Profissao> listAll() {
		
		List<Profissao> lista = new ArrayList<Profissao>();
		String sql = "SELECT id, nome FROM tab_profissao";
		try {	
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()){
				Profissao profissao = new Profissao();
			    profissao.setId(result.getInt(1));
			    
			    String nome = result.getString(2);
			    profissao.setNome(nome);
			    
			    lista.add(profissao);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	
	}
}
