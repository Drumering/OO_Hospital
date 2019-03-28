package br.com.opet.model;

import java.util.Date;

import br.com.opet.model.top.Pessoa;

public class Medico extends Pessoa {
	private int especialidade;
	
	public Medico(String nome, Date dtNascimento, String cpf, String sexo, String telefone, int especialidade) {
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.Sexo = sexo;
		this.telefone = telefone;
		this.especialidade = especialidade;
	}

	public String toString() {
		String str = "";
		str = super.toString() + " - " + "| " + this.especialidade + " |";

		return str;
	}

	/**
	 * @return the especialidade
	 */
	public int getEspecialidade() {
		return especialidade;
	}

	/**
	 * @param especialidade the especialidade to set
	 */
	public void setEspecialidade(int especialidade) {
		this.especialidade = especialidade;
	}
}
