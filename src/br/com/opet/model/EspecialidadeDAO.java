package br.com.opet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.opet.model.dao.Conexao;

public class EspecialidadeDAO {
	public boolean salvarEspecialidade(Especialidade eTMP) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("insert into especialidade(id_esp,desc_esp) values(seq_esp.nextval,?)");
			stmt.setString(1, eTMP.getDescricao());
			int rowAf = stmt.executeUpdate();
			if (rowAf == 1) {
				con.commit();
				return true;
			} else {
				con.rollback();
				System.out.println("Falha ao inserir especialidade");
				return false;
			}
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println("Falha ao inserir especialidade");
				return false;
			} catch (SQLException e1) {
				System.out.println("Falha ao inserir especialidade");
				return false;
			}
		} finally {
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Erro ao encerrar conexao com o banco!!!");
				return false;
			}
		}
	}

	public boolean atualizarEspecialidade() {
		return false;
	}

	public boolean apagarEspecialidade() {
		return false;
	}

	public ArrayList<Especialidade> listarEspecialidade() {
		ArrayList<Especialidade> lEsp = new ArrayList<Especialidade>();
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("select id_esp,desc_esp from especialidade");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id_esp");
				String descricao = rs.getString("desc_esp");
				Especialidade eTMP = new Especialidade(id, descricao);
				lEsp.add(eTMP);
			}
		} catch (SQLException e) {
			System.out.println("Nao foi possivel obter lista de Especialidades!");
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Erro de conexao com o banco");
			}
		}

		return lEsp;
	}
}
