package br.com.opet.controller;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.opet.model.Especialidade;
import br.com.opet.model.EspecialidadeDAO;
import br.com.opet.view.TelaEspecialidade;

public class ControllerEspecialidade {
	TelaEspecialidade te = new TelaEspecialidade();
	HashMap<Integer, Especialidade> listaEspecialidade = new HashMap<Integer, Especialidade>();

	public HashMap<Integer, Especialidade> getListaEspecialidade() {
		return listaEspecialidade;
	}

	public ControllerEspecialidade() {
		listaEspecialidade.put(0, new Especialidade(0, "Angiologia"));
		listaEspecialidade.put(1, new Especialidade(1, "Oncologia"));
		listaEspecialidade.put(2, new Especialidade(2, "Dermatologia"));
		listaEspecialidade.put(3, new Especialidade(3, "Endocrinologia"));
		listaEspecialidade.put(4, new Especialidade(4, "Oftalmologia"));
	}

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

	public void Listar() {
		EspecialidadeDAO eDAO = new EspecialidadeDAO();
		ArrayList<Especialidade> lista = eDAO.listarEspecialidade();
		for (Especialidade esp : lista) {
			te.showEspecialidade(esp);
		}
	}
}
