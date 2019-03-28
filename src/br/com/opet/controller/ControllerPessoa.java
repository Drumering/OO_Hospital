package br.com.opet.controller;
import java.util.ArrayList;
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
				listaPessoa.add(tp.showCadastrar(cEspecialidade.getListaEspecialidade()));
				break;
			case 2:
				tp.Listar(listaPessoa);
			default:
				break;
			}
			opc = tp.showSubMenuPrincipal();
		}
	}
}
