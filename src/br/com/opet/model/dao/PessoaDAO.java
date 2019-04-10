package br.com.opet.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.opet.model.top.Pessoa;

public class PessoaDAO {
	public boolean salvar(Pessoa pTMP) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;

		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("insert into pessoa(cpf,nome,sexo,telefone,dt_nascimento) values (?,?,?,?,?)");
			stmt.setString(1, pTMP.getCpf());
			stmt.setString(2, pTMP.getNome());
			stmt.setString(3, pTMP.getSexo());
			stmt.setString(4, pTMP.getTelefone());
			stmt.setDate(5, new Date(pTMP.getDtNascimento().getTime()));

			int rowAf = stmt.executeUpdate();
			if (rowAf == 1) {
				con.commit();
				return true;
			} else {
				con.rollback();
				System.out.println("Falha ao inserir pessoa");
				return false;
			}
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("Falha ao inserir pessoa");
				return false;
			} catch (SQLException e1) {
				System.out.println("Falha ao inserir pessoa");
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

	public boolean atualizar(Pessoa pTMP) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		// recuperar(pTMP);
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("update pessoa set nome = ? where cpf = ?");
			stmt.setString(1, pTMP.getNome());
			stmt.setString(2, pTMP.getCpf());

		} catch (Exception e) {
			System.out.println("Nao foi possivel ATUALIZAR os dados da pessoa");
		}

		return false;
	}

	public boolean apagar(Pessoa pTMP) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("delete from pessoa where nome = ?");
			stmt.setString(1, pTMP.getNome());
			int rowAf = stmt.executeUpdate();
			if (rowAf == 1) {
				con.commit();
				return true;
			} else {
				con.rollback();
				System.out.println("Falha ao deletar pessoa");
				return false;
			}
		} catch (Exception e) {
			try {
				con.rollback();
				return false;
			} catch (SQLException e1) {
				System.out.println("Falha ao deletar pessoa");
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

	public Pessoa recuperar(Pessoa pTMP) {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pessoa peTMP = new Pessoa();

		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("select nome from pessoa where nome = ?");
			stmt.setString(1, pTMP.getNome());
			rs = stmt.executeQuery();
			while (rs.next()) {
				peTMP.setNome(rs.getString("nome"));
				peTMP.setCpf(rs.getString("cpf"));
				peTMP.setDtNascimento(rs.getDate("dt_nasc"));
				peTMP.setSexo(rs.getString("sexo"));
				peTMP.setTelefone(rs.getString("telefone"));
			}
		} catch (Exception e) {
			System.out.println("Nao foi possivel recuperar pessoa");
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Erro ao encerrar conexao com o banco!!!");
			}
		}
		return peTMP;
	}

	public ArrayList<Pessoa> listar() {
		ArrayList<Pessoa> alPessoa = new ArrayList<Pessoa>();

		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("select cpf,nome,sexo,telefone,dt_nascimento from pessoa");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Pessoa pTMP = new Pessoa();
				pTMP.setCpf(rs.getString("cpf"));
				pTMP.setNome(rs.getString("nome"));
				pTMP.setSexo(rs.getString("sexo"));
				pTMP.setTelefone(rs.getString("telefone"));
				pTMP.setDtNascimento(rs.getDate("dt_nascimento"));
				alPessoa.add(pTMP);
			}

		} catch (SQLException e) {
			System.out.println("Nao foi possivel recuperar lista de pessoas!!!");
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Erro ao encerrar conexao com o banco!!!");
			}
		}

		return alPessoa;
	}
}
