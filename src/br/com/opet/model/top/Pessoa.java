package br.com.opet.model.top;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.opet.model.dao.PessoaDAO;

@ManagedBean
@SessionScoped
public class Pessoa extends PessoaDAO{

	protected int Tipo;
	protected String nome;
	protected Date dtNascimento;
	protected String cpf;
	protected String Sexo;
	protected String telefone;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public String toString() {
		String str = "";
		String dtNascimento = sdf.format(this.dtNascimento).toString();
		str = this.nome + " - " + dtNascimento + " - " + this.cpf + " - " + this.Sexo + " - " + this.telefone;

		return str;
	}
	
	public Pessoa() {
		
	}
	
	public ArrayList<Pessoa> listar(){
		return super.listar();
	}
	
	public boolean salvar() {
		System.err.println("Errado");
		return false;
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
	
	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return Tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		Tipo = tipo;
	}

}
