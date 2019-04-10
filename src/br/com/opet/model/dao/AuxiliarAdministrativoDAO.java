package br.com.opet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.opet.model.AuxiliarAdministrativo;

public class AuxiliarAdministrativoDAO {
	public boolean salvarAuxiliarAdministrativo(AuxiliarAdministrativo aTMP) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("insert into auxAdm (cpf,salario) values (?,?)");
			stmt.setString(1, aTMP.getCpf());
			stmt.setDouble(2, aTMP.getSalario());

			int rowAf = stmt.executeUpdate();
			if (rowAf == 1) {
				con.commit();
				return true;
			} else {
				con.rollback();
				System.out.println("Falha ao inserir Auxiliar Administrativo");
				return false;
			}
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("Falha ao inserir Auxiliar Administrativo");
				return false;
			} catch (SQLException e1) {
				System.out.println("Falha ao inserir Auxiliar Administrativo");
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
