package br.com.opet.main;

import br.com.opet.controller.ControllerEspecialidade;
import br.com.opet.controller.ControllerPessoa;
import br.com.opet.view.TelaMenu;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		ControllerEspecialidade cEspecialidade = new ControllerEspecialidade();
		ControllerPessoa cPessoa = new ControllerPessoa(cEspecialidade);
		TelaMenu tm = new TelaMenu();

		int opc = -1;
		opc = tm.showMenuPrincipal();
		while (opc != 0) {
			switch (opc) {
			case 1:
				cPessoa.showSubMenuPessoa();
				break;
			case 2:
				//cEspecialidade.showSubMenuEspecialidade();
				break;
			default:
				System.out.println("Opcao Invalida");
			}
			opc = tm.showMenuPrincipal();
		}
	}

	/*
	 * public static Pessoa ShowCadastrar() { SimpleDateFormat sdf = new
	 * SimpleDateFormat(); Pessoa pTMP = new Pessoa(); System.out.println("nome: ");
	 * pTMP.setNome(Reader.readString()); System.out.println("Dt Nascimento");
	 * String dateNascimento = Reader.readString(); Date dtNascimento = null; try {
	 * dtNascimento = sdf.parse(dateNascimento); } catch (ParseException e) {
	 * System.out.println("Erro ao informar a date de nascimento: "); }
	 * pTMP.setDtNascimento(dtNascimento);
	 * 
	 * return pTMP; }
	 */
}
