package br.com.opet.view;

import com.opet.util.Reader;

import br.com.opet.model.Especialidade;

public class TelaEspecialidade {

	public int showSubMenuPrincipal() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar");
		System.out.println("0 - Sair");

		int opc = Reader.readInt();

		return opc;
	}

	public Especialidade showCadastrar() throws Exception {
		System.out.println("Informe o nome da nova ESPECIALIDADE: ");
		String nomeEspecialidade = Reader.readString();
		return new Especialidade(nomeEspecialidade);
	}

	public void showEspecialidade(Especialidade e) {
		System.out.println(e.getId() + " - " + e.getDescricao());
	}
}
