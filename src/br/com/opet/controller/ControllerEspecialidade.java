package br.com.opet.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.opet.model.Especialidade;
import br.com.opet.model.dao.EspecialidadeDAO;
import br.com.opet.view.TelaEspecialidade;

@ManagedBean
@RequestScoped
public class ControllerEspecialidade {
	TelaEspecialidade te = new TelaEspecialidade();
	EspecialidadeDAO eDAO = new EspecialidadeDAO();

	public String showCadastrar(Especialidade esp) throws Exception {
		// Especialidade esp = te.showCadastrar();
		eDAO.salvarEspecialidade(esp);
		return "/especialidades/listarEspecialidades.xhtml";
	}

	/*private void showAtualizar() {
		ArrayList<Integer> listaId = Listar();
		int id = -1;
		do {
			id = te.showMenuRecuperar();
		} while (!listaId.contains(id));
		Especialidade descricao;
		try {
			descricao = te.showCadastrar();
			if (eDAO.atualizarEspecialidade(id, descricao.getDescricao())) {
				System.out.println("Descricao atualizada com Sucesso");
			}
		} catch (Exception e) {
			System.err.println("falha ao atualizar!");
		}

	}*/

	public ArrayList<Especialidade> Listar() {
		EspecialidadeDAO eDAO = new EspecialidadeDAO();
		ArrayList<Especialidade> lista = eDAO.listarEspecialidade();
		return lista;
	}
}
