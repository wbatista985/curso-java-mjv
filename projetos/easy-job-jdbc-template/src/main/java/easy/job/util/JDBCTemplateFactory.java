package easy.job.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class JDBCTemplateFactory {
	private static String servidor = "C:/estudo/database/h2db";    	//caminho do servidor do BD
	private static String bancoDados = "easy-job-db";       		//nome do seu banco de dados
	private static String porta = "";        						//porta do seu banco de dados
	private static String usuario = "sa";        					//nome de um usu�rio de seu BD      
	private static String senha = "";      							//sua senha de acesso
	
	private static JdbcTemplate conexao = null;
	
	//vc poderia criar uma factory de url
	private static String url = "jdbc:h2:file:" + servidor + porta+  "/" + bancoDados;
	
	//simulando o conceito de container como Java EE e Spring
	static {
		conectar();
	}
	
	//padrao singleton
	private static void conectar() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        try {           
        	
            dataSource.setDriver(new org.h2.Driver());
            dataSource.setUrl(url);
            dataSource.setUsername(usuario);
            dataSource.setPassword(senha);
            
            conexao = new JdbcTemplate(dataSource);
        } catch(Exception exception) {
            exception.printStackTrace();
        }
	}

	public static JdbcTemplate getConexao() {
		return conexao;
	}
	
}
