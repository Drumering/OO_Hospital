package br.com.opet.model;

import br.com.opet.model.top.Pessoa;

public class Medico extends Pessoa {
	private String especialidade;

	public String toString() {
		String str = "";
		str = super.toString() + " - " + "| " + this.especialidade + " |";

		return str;
	}

	/**
	 * @return the especialidade
	 */
	public String getEspecialidade() {
		return especialidade;
	}

	/**
	 * @param especialidade the especialidade to set
	 */
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
