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
				Listar();
			case 3:
				System.out.println("A implementar");
			default:
				break;
			}
			opc = tp.showSubMenuPrincipal();
		}
	}

	public void showAtualizar() {
		String cpf = tp.showMenuAtualizar();
		pDAO.recuperar(cpf);
		
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

	public void Listar() {
		PessoaDAO pDAO = new PessoaDAO();

		ArrayList<Pessoa> alPessoa = pDAO.listar();

		for (Pessoa pTMP : alPessoa) {
			tp.showPessoa(pTMP);
		}
	}
}
