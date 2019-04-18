package br.com.opet.view;

import com.opet.util.Reader;

import br.com.opet.model.Especialidade;

public class TelaEspecialidade {

	public int showSubMenuPrincipal() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("0 - Sair");

		int opc = Reader.readInt();

		return opc;
	}

	public Especialidade showCadastrar() throws Exception {
		System.out.println("Informe o nome da nova ESPECIALIDADE: ");
		String nomeEspecialidade = Reader.readString();
		return new Especialidade(nomeEspecialidade);
	}

	public int showMenuRecuperar() {
		int opc = -1;
		System.out.println("Informe o ID da especialidade:");
		try {
			opc = Reader.readInt();
		} catch (Exception e) {
			System.out.println("O numero informado deve ser um numero inteiro");
		}
		return opc;
	}

	public void showEspecialidade(Especialidade e) {
		System.out.println(e.getId() + " - " + e.getDescricao());
	}
}
