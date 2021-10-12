package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExercicioAlterarTabela {
	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o codigo que deseja alterar: ");
		int codigo = entrada.nextInt();
		String sqlUpdate = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		String sql = "SELECT * FROM pessoas WHERE codigo = ?";
		Connection conexao = RealizarConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codigo);
		ResultSet resultado = stmt.executeQuery();
		if (resultado.next()) {
			Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));
			System.out.println(p.getNome());
			entrada.nextLine();
			System.out.println("Digite o novo nome: ");
			String novoNome = entrada.nextLine();
			stmt.close();
			stmt = conexao.prepareStatement(sqlUpdate);
			stmt.setString(1, novoNome);
			stmt.setInt(2, codigo);
			stmt.execute();
			System.out.println("pessoal alterada com sucesso!");
		} else {
			System.out.println("Pessoa não encontrada");
		}
		stmt.close();
		conexao.close();
		entrada.close();
	}
}