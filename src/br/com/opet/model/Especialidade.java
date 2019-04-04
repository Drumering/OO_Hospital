package br.com.opet.model;

public class Especialidade {
	private int id;
	private String descricao;

	public Especialidade(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Especialidade(String descricao) {
		this.descricao = descricao;
	}

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

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
