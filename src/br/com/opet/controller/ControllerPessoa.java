package br.com.opet.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import br.com.opet.model.dao.PessoaDAO;
import br.com.opet.model.top.Pessoa;
import br.com.opet.view.TelaPessoa;

@ManagedBean
public class ControllerPessoa {

	TelaPessoa tp = new TelaPessoa();
	PessoaDAO pDAO = new PessoaDAO();
	Pessoa P = new Pessoa();

	public ControllerPessoa() {

	}

	public void atualizar() {
		String cpf = tp.showRecuperarPessoa();
		Pessoa p = pDAO.recuperar(cpf);
		// tp.showPessoa(p);
		int opc = tp.showMenuAlterar();
		while (opc != 0) {
			switch (opc) {
			case 1:
			case 2:
			case 3:
			case 4:
				Pessoa pAlterada = tp.showAlterar(p, opc);
				pDAO.atualizarPessoa(pAlterada, cpf);
				break;
			default:
				break;
			}
			opc = tp.showMenuAlterar();
		}
	}

	public void deletar() {
		String cpf = tp.showRecuperarPessoa();
		Pessoa p = pDAO.recuperar(cpf);
		// tp.showPessoa(p);
		int opc = tp.showMenuDeletar();
		while (opc != 0) {
			switch (opc) {
			case 1:
				pDAO.deletarPessoa(p);
				break;
			default:
				break;
			}
			if (opc == 2 || opc == 1) {
				break;
			}
			opc = tp.showMenuDeletar();
		}
	}

	public String cadastrar(Pessoa p) {
		P.salvar();
		return "/profissionais/listarProfissionais.xhtml";
	}

	public ArrayList<Pessoa> listar() {
		return P.listar();
	}
}
