package br.com.opet.model;

import java.util.Date;

import br.com.opet.model.top.Pessoa;

public class Enfermeiro extends Pessoa {
	private int cargaHoraria;

	public Enfermeiro(int tipo,String nome, Date dtNascimento, String cpf, String sexo, String telefone, int cargaHoraria) {
		this.Tipo = tipo;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.Sexo = sexo;
		this.telefone = telefone;
		this.cargaHoraria = cargaHoraria;
	}

	public String toString() {
		String str = "";
		str = super.toString() + " - " + "| " + this.cargaHoraria + " Horas";

		return str;
	}

	/**
	 * @return the cargaHoraria
	 */
	public int getCargaHoraria() {
		return cargaHoraria;
	}

	/**
	 * @param cargaHoraria
	 *            the cargaHoraria to set
	 */
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
