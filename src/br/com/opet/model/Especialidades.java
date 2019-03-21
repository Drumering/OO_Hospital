package br.com.opet.model;

public class Especialidades {
	int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	private String Especialidade;

	public Especialidades(int id, String Especialidade) {
		this.id = id;
		this.Especialidade = Especialidade;
	}

	/**
	 * @return the especialidade
	 */
	public String getEspecialidade() {
		return Especialidade;
	}

	/**
	 * @param especialidade
	 *            the especialidade to set
	 */
	public void setEspecialidade(String especialidade) {
		Especialidade = especialidade;
	}
}
