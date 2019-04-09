package br.com.opet.model;

import java.util.Date;

import br.com.opet.model.top.Pessoa;

public class AuxiliarAdministrativo extends Pessoa {
	private double Salario;
	
	public AuxiliarAdministrativo (int tipo,String nome, Date dtNascimento, String cpf, String sexo, String telefone, double Salario) {
		this.Tipo = tipo;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.Sexo = sexo;
		this.telefone = telefone;
		this.Salario = Salario;
	}

	public String toString() {
		String str = "";
		str = super.toString() + " - " + "R$" + this.Salario;

		return str;
	}

	/**
	 * @return the salario
	 */
	public double getSalario() {
		return Salario;
	}

	/**
	 * @param salario
	 *            the salario to set
	 */
	public void setSalario(double salario) {
		Salario = salario;
	}
}
