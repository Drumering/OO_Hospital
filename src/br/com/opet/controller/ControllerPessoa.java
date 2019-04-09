package br.com.opet.controller;

import java.util.ArrayList;

import br.com.opet.model.dao.PessoaDAO;
import br.com.opet.model.top.Pessoa;
import br.com.opet.view.TelaPessoa;

public class ControllerPessoa {

	TelaPessoa tp = new TelaPessoa();
	ControllerEspecialidade cEspecialidade = null;
	ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();

	public ControllerPessoa(ControllerEspecialidade especialidade) {
		this.cEspecialidade = especialidade;
	}

	public void showSubMenuPessoa() throws Exception {
		int opc = tp.showSubMenuPrincipal();
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
			opc = tp.showSubMenuPrincipal();
		}
	}

	public void showCadastrar() {
		try {
			Pessoa p = tp.showCadastrar();
			PessoaDAO pDAO = new PessoaDAO();
			pDAO.salvar(p);
		} catch (Exception e) {
			System.out.println("nao foi possivel recuperar dados da TelaPessoa");
		}
	}

	public void Listar() {
		PessoaDAO pDAO = new PessoaDAO();

		ArrayList<Pessoa> alPessoa = pDAO.listar();

		for (Pessoa pTMP : alPessoa) {
			tp.showPessoa(pTMP);
		}
	}
}
