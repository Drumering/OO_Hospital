package br.com.opet.view;

import com.opet.util.Reader;

public class TelaMenu {
	
	public int showMenuPrincipal() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Pessoa");
		System.out.println("2 - Especialidade");
		System.out.println("0 - Voltar");

		int opc = Reader.readInt();

		return opc;
	}
}
