package br.com.opet.view;

import com.opet.util.Reader;

public class TelaPrincipal {
	public int showMenu() throws Exception {
		int pdt = -1;
		System.out.println("===================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("0 - Sair");
		System.out.println("===================");

		pdt = Reader.readInt();

		return pdt;
	}
}
