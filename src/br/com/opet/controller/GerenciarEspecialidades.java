package br.com.opet.controller;

import java.util.HashMap;
import java.util.HashSet;

import br.com.opet.model.Especialidades;
import br.com.opet.view.TelaEspecialidade;

public class GerenciarEspecialidades {

	HashMap<Integer, Especialidades> lEsp = new HashMap<Integer, Especialidades>();
	TelaEspecialidade tEsp = new TelaEspecialidade();

	public void CadastrarEspecialidade() throws Exception {
		Especialidades tmp = tEsp.showCadastrar(lEsp.size());
		lEsp.put(tmp.getId(), tmp);
	}

	public void listarEspecialidades() {
		for (int i = 0; i < lEsp.size(); i++) {
			System.out.println("ID: " + i + " - " + "Especialidade: " + lEsp.get(i).getEspecialidade());
		}
	}
}
