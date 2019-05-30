package br.com.opet.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import br.com.opet.model.dao.MedicoDAO;

@ManagedBean
public class Medico extends MedicoDAO {
	private Especialidade especialidade;

	public Medico(int Tipo, String nome, Date dtNascimento, String cpf, String sexo, String telefone,
			Especialidade especialidade) {
		this.Tipo = Tipo;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.Sexo = sexo;
		this.telefone = telefone;
		this.especialidade = especialidade;
	}

	public Medico() {
		this.especialidade = new Especialidade();
	}

	public boolean salvar() {
		return super.salvar(this);
	}

	public String toString() {
		String str = "";
		str = super.toString() + " - " + "| " + this.especialidade + " |";

		return str;
	}

	/**
	 * @return the especialidade
	 */
	public Especialidade getEspecialidade() {
		return especialidade;
	}

	/**
	 * @param especialidade
	 *            the especialidade to set
	 */
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
}
