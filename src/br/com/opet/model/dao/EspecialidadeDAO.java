package br.com.opet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.opet.model.Especialidade;

public class EspecialidadeDAO {

	private final String INSERT = "insert into especialidade" + "(id_esp,desc_esp)" + " values(seq_esp.nextval,?)";

	public boolean salvarEspecialidade(Especialidade eTMP) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement(INSERT);
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

	public boolean atualizarEspecialidade(int id, String descricao) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("update especialidade set desc_esp = ? where id_esp = ?");
			stmt.setString(1, descricao);
			stmt.setInt(2, id);
			int rowAf = stmt.executeUpdate();
			if (rowAf == 1) {
				con.commit();
				return true;
			} else {
				con.rollback();
				System.out.println("Falha ao atualizar especialidade");
				return false;
			}
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println("Falha ao atualizar especialidade");
				return false;
			} catch (SQLException e1) {
				System.out.println("Falha ao atualizar especialidade");
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

	public Especialidade recuperarEspecialidade(int id) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Especialidade esp = null;

		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("select id_esp,desc_esp from especialidade where id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				esp = new Especialidade(rs.getInt("id_esp"), rs.getString("desc_esp"));
			}
		} catch (Exception e) {
			System.out.println("Nao foi possivel recuperar especialidade");
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Erro ao encerrar conexao com o banco!!!");
			}
		}
		return esp;
	}
}
