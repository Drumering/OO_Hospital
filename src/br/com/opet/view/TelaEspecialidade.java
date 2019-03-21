package br.com.opet.view;

import com.opet.util.Reader;

import br.com.opet.model.Especialidades;

public class TelaEspecialidade {
	public Especialidades showCadastrar(int id) throws Exception {
		System.out.println("===================");
		System.out.println("Informe o nome da nova especialidade: ");
		System.out.println("===================");
		String nomeEspecialidade = Reader.readString();

		Especialidades e = new Especialidades(id, nomeEspecialidade);

		return e;
	}

	public void showEspecialidades(Especialidades e) {
		System.out.println(e.getId() + " - " + e.getEspecialidade());
	}
}
