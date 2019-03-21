package br.com.opet.main;

import br.com.opet.controller.GerenciarEspecialidades;
import br.com.opet.view.TelaPrincipal;

public class MainMVC {

	public static void main(String[] args) throws Exception {

		int opc = -1;

		TelaPrincipal tPrinc = new TelaPrincipal();
		GerenciarEspecialidades gEspecialidades = new GerenciarEspecialidades();

		while (opc != 0) {
			opc = tPrinc.showMenu();
			switch (opc) {
			case 1:
				gEspecialidades.CadastrarEspecialidade();
				break;
			case 2:
				gEspecialidades.listarEspecialidades();
				break;
			case 0:
				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		}
	}

}
