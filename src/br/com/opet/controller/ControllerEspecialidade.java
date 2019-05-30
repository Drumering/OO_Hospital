package br.com.opet.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import br.com.opet.model.Especialidade;
import br.com.opet.model.dao.EspecialidadeDAO;
import br.com.opet.view.TelaEspecialidade;

@ManagedBean
public class ControllerEspecialidade {
	TelaEspecialidade te = new TelaEspecialidade();
	EspecialidadeDAO eDAO = new EspecialidadeDAO();
	Especialidade e = new Especialidade();

	public String cadastrar(Especialidade esp) throws Exception {
		e.salvar(esp);
		return "/especialidades/listarEspecialidades.xhtml";
	}

	/*
	 * private void showAtualizar() { ArrayList<Integer> listaId = new
	 * ArrayList<Integer>(); for (Especialidade esp : Listar()) {
	 * listaId.add(esp.getId()); } int id = -1; do { id = te.showMenuRecuperar(); }
	 * while (!listaId.contains(id)); Especialidade descricao; try { descricao =
	 * te.showCadastrar(); if (eDAO.atualizarEspecialidade(id,
	 * descricao.getDescricao())) {
	 * System.out.println("Descricao atualizada com Sucesso"); } } catch (Exception
	 * e) { System.err.println("falha ao atualizar!"); }
	 * 
	 * }
	 */

	public ArrayList<Especialidade> Listar() {
		return e.listar();
	}
}
