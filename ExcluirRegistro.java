package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o código que deseja excluir: ");
		int codigo = entrada.nextInt();
		Connection conexao = RealizarConexao.getConexao();
		String ExcluirSQL = "DELETE FROM pessoas WHERE codigo = ?";
		PreparedStatement stmt = conexao.prepareStatement(ExcluirSQL);
		stmt.setInt(1, codigo);
		if (stmt.executeUpdate() > 0) {
			System.out.println("Pessoas excluida com sucesso");
		} else {
			System.out.println("Não foi possível realizar a operação");
		}

		stmt.close();
		entrada.close();

	}

}