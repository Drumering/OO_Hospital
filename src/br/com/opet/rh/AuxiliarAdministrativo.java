package br.com.opet.rh;

import br.com.opet.modelo.Pessoa;

public class AuxiliarAdministrativo extends Pessoa {
	private double Salario;

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
