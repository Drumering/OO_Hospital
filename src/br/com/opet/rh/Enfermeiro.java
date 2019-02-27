package br.com.opet.rh;

import br.com.opet.modelo.Pessoa;

public class Enfermeiro extends Pessoa {
	private int cargaHoraria;

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
