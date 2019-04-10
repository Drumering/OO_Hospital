package br.com.opet.controller;

import java.util.ArrayList;

import br.com.opet.model.Especialidade;
import br.com.opet.model.dao.EspecialidadeDAO;
import br.com.opet.view.TelaEspecialidade;

public class ControllerEspecialidade {
	TelaEspecialidade te = new TelaEspecialidade();

	public void showSubMenuEspecialidade() throws Exception {
		int opc = te.showSubMenuPrincipal();
		while (opc != 0) {
			switch (opc) {
			case 1:
				showCadastrar();
				break;
			case 2:
				Listar();
			default:
				break;
			}
			opc = te.showSubMenuPrincipal();
		}
	}

	private void showCadastrar() throws Exception {
		Especialidade esp = te.showCadastrar();
		EspecialidadeDAO eDAO = new EspecialidadeDAO();
		eDAO.salvarEspecialidade(esp);
	}

	public ArrayList<Integer> Listar() {
		EspecialidadeDAO eDAO = new EspecialidadeDAO();
		ArrayList<Especialidade> lista = eDAO.listarEspecialidade();
		ArrayList<Integer> y = new ArrayList<Integer>();
		for (Especialidade esp : lista) {
			te.showEspecialidade(esp);
			y.add(esp.getId());
		}
		return y;
	}
}
