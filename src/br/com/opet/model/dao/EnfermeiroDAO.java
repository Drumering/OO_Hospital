package br.com.opet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.opet.model.Enfermeiro;

public class EnfermeiroDAO {
	public boolean salvarEnfermeiro(Enfermeiro eTMP) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("insert into enfermeiro (cpf,carga_horaria) values (?,?)");
			stmt.setString(1, eTMP.getCpf());
			stmt.setInt(2, eTMP.getCargaHoraria());

			int rowAf = stmt.executeUpdate();
			if (rowAf == 1) {
				con.commit();
				return true;
			} else {
				con.rollback();
				System.out.println("Falha ao inserir Enfermeiro");
				return false;
			}
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("Falha ao inserir Medico");
				return false;
			} catch (SQLException e1) {
				System.out.println("Falha ao inserir Medico");
				return false;
			}
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Erro ao encerrar conexao com o banco!!!");
				return false;
			}
		}
	}
}
