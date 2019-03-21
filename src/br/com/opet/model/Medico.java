package br.com.opet.model;

import java.util.Date;

public class Medico extends Pessoa {

	private int especialidade;

	/**
	 * @return the especialidade
	 */
	public int getEspecialidade() {
		return especialidade;
	}

	/**
	 * @param especialidade
	 *            the especialidade to set
	 */
	public void setEspecialidade(int especialidade) {
		this.especialidade = especialidade;
	}

	public Medico(String nome, Date dtNascimento, String cpf, String sexo, String telefone,	int especialidade) {
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.Sexo = sexo;
		this.telefone = telefone;
		this.especialidade = especialidade;
	}
}
