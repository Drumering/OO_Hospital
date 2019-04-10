package br.com.opet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.opet.model.Medico;

public class MedicoDAO {
	public boolean salvarMedico(Medico mTMP) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;

		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("insert into medico(cpf,especialidade) values (?,?)");
			stmt.setString(1, mTMP.getCpf());
			stmt.setInt(2, mTMP.getEspecialidade());
			
			int rowAf = stmt.executeUpdate();
			if (rowAf == 1) {
				con.commit();
				return true;
			} else {
				con.rollback();
				System.out.println("Falha ao inserir Medico");
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
