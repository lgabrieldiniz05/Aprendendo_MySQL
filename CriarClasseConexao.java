package jdbc;

import java.io.IOException;
//CRIAR UMA CLASSE PARA CONEXAO
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class RealizarConexao {

	public static Connection getConexao() {
		try {
			Properties prop = getproProperties();
			final String stringDeConexao = prop.getProperty("banco.url");
			final String usuario = prop.getProperty("banco.usuario");
			;
			final String senha = prop.getProperty("banco.senha");
			;

			return DriverManager.getConnection(stringDeConexao, usuario, senha);

		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}

	}

	private static Properties getproProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexao.properties";
		prop.load(RealizarConexao.class.getResourceAsStream(caminho));
		return prop;
	}
}