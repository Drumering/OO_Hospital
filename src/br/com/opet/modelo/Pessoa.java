package br.com.opet.modelo;

import java.util.Date;

public class Pessoa {

	protected String nome;
	protected Date dtNascimento;
	protected String cpf;
	protected String Sexo;
	protected String telefone;

	public String toString() {
		String str = "";
		str = this.nome + " - " + this.dtNascimento + " - " + this.cpf + " - " + this.Sexo + " - " + this.telefone;

		return str;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the dtNascimento
	 */
	public Date getDtNascimento() {
		return dtNascimento;
	}

	/**
	 * @param dtNascimento
	 *            the dtNascimento to set
	 */
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return Sexo;
	}

	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
