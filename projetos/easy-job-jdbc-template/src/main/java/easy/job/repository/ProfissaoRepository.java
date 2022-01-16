package easy.job.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import easy.job.model.Profissao;
import easy.job.util.JDBCTemplateFactory;

public class ProfissaoRepository {

	// JDBC Template Connection
	private JdbcTemplate connection = JDBCTemplateFactory.getConexao();
	
	public void save(Profissao profissao) {
		final String sql = "insert into tab_profissao(nome) values (?)";
		try {
			Profissao existente = findByNome(profissao.getNome());
			if(existente!=null) {
				System.out.println("Desculpa j� existe uma profiss�o com nome " + existente.getNome() + " id " + existente.getId());
				return;
			}
			connection.update(sql, profissao.getNome());
			System.out.println("Registro salvo com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(Profissao profissao) {
		final String sql = "update tab_profissao set nome = ? WHERE id = ?";
		try {	
			connection.update(sql, profissao.getNome(), profissao.getId());
			System.out.println("Registro alterado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(Integer id) {
		
		final String sql = "delete from tab_profissao WHERE id = ?";
		try {	
			connection.update(sql, id);
			System.out.println("Registro deletado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public Profissao findById(Integer id) {
		Profissao profissao = null;
		String sql = "SELECT * FROM tab_profissao where id = ?";
		try {	
			profissao = (Profissao) connection.queryForObject(
					sql, 
					new Object[]{id}, 
					new BeanPropertyRowMapper(Profissao.class));
		}catch (EmptyResultDataAccessException e) {
			System.out.println("sem registro com nome na base - continua");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return profissao;
	}
	
	public Profissao findByNome(String nome) {
		
		Profissao profissao = null;
		String sql = "SELECT id, nome FROM tab_profissao where nome = ?";
		try {	
			profissao = connection.queryForObject(sql, new Object[]{nome}, new ProfissaoRowMapper());
		}catch (EmptyResultDataAccessException e) {
			System.out.println("sem registro com nome na base - continua");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return profissao;
	
	}
	
	public List<Profissao> listAll() {
		
		List<Profissao> lista = null;
		String sql = "SELECT id, nome FROM tab_profissao";
		try {	
			lista = connection.query(sql,new ProfissaoRowMapper());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	
	}
}

//classe no mesmo arquivo, não é aconselhável
//é mais para mostrar que é possível
//porém só uma classe deve ser public, a de mesmo nome do arquivo.java
class ProfissaoRowMapper implements RowMapper<Profissao> {

    @Override
    public Profissao mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Profissao mapper = new Profissao();
        mapper.setId(rs.getInt("id"));
        mapper.setNome(rs.getString("nome"));
        return mapper;
    }
}
