package br.com.opet.controller;

import java.util.ArrayList;

import br.com.opet.model.AuxiliarAdministrativo;
import br.com.opet.model.Enfermeiro;
import br.com.opet.model.Medico;
import br.com.opet.model.dao.AuxiliarAdministrativoDAO;
import br.com.opet.model.dao.EnfermeiroDAO;
import br.com.opet.model.dao.MedicoDAO;
import br.com.opet.model.dao.PessoaDAO;
import br.com.opet.model.top.Pessoa;
import br.com.opet.view.TelaPessoa;

public class ControllerPessoa {

	TelaPessoa tp = new TelaPessoa();
	PessoaDAO pDAO = new PessoaDAO();
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
				listAllPessoas();
				break;
			case 3:
				showAtualizar();
			case 4:
				showDeletar();
				break;
			default:
				break;
			}
			opc = tp.showSubMenuPrincipal();
		}
	}

	public void showAtualizar() {
		String cpf = tp.showRecuperarPessoa();
		Pessoa p = pDAO.recuperar(cpf);
		tp.showPessoa(p);
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

	public void showDeletar() {
		String cpf = tp.showRecuperarPessoa();
		Pessoa p = pDAO.recuperar(cpf);
		tp.showPessoa(p);
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

	public void showCadastrar() {
		try {
			Pessoa p = tp.showCadastrar();
			pDAO.salvar(p);

			if (p.getTipo() == 1) {
				MedicoDAO mDAO = new MedicoDAO();
				Medico m = (Medico) p;
				mDAO.salvarMedico(m);
			} else if (p.getTipo() == 2) {
				EnfermeiroDAO eDAO = new EnfermeiroDAO();
				Enfermeiro e = (Enfermeiro) p;
				eDAO.salvarEnfermeiro(e);
			} else if (p.getTipo() == 3) {
				AuxiliarAdministrativoDAO aDAO = new AuxiliarAdministrativoDAO();
				AuxiliarAdministrativo a = (AuxiliarAdministrativo) p;
				aDAO.salvarAuxiliarAdministrativo(a);
			}
		} catch (Exception e) {
			System.out.println("nao foi possivel recuperar dados da TelaPessoa");
		}
	}

	public void listAllPessoas() {
		PessoaDAO pDAO = new PessoaDAO();

		ArrayList<Pessoa> alPessoa = pDAO.listar();

		for (Pessoa pTMP : alPessoa) {
			tp.showPessoa(pTMP);
		}
	}
}
