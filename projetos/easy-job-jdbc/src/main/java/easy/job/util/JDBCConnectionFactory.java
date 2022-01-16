package easy.job.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionFactory {
	private static String servidor = "C:/estudo/database/h2db";    			//caminho do servidor do BD
	private static String bancoDados = "easy-job-db";       //nome do seu banco de dados
	private static String porta = "";        				//porta do seu banco de dados
	private static String usuario = "sa";        			//nome de um usuário de seu BD      
	private static String senha = "";      					//sua senha de acesso
	private static Connection conexao = null;
	
	//vc poderia criar uma factory de url
	private static String url = "jdbc:h2:file:" + servidor + porta+  "/" + bancoDados;
	
	//simulando o conceito de container como Java EE e Spring
	static {
		conectar();
	}
	
	//padrao singleton
	private static void conectar() {
		try {

			if(conexao == null) {
				Class.forName("org.h2.Driver");
				conexao = (Connection) DriverManager.getConnection(url, usuario, senha);			
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
		
	}

	public static Connection getConexao() {
		return conexao;
	}
	public static void fecharConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
