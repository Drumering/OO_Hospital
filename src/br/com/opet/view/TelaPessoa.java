package br.com.opet.view;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.opet.util.Reader;

import br.com.opet.controller.ControllerEspecialidade;
import br.com.opet.model.AuxiliarAdministrativo;
import br.com.opet.model.Enfermeiro;
import br.com.opet.model.Especialidade;
import br.com.opet.model.Medico;
import br.com.opet.model.top.Pessoa;

public class TelaPessoa {

	ControllerEspecialidade cEspecialidade = new ControllerEspecialidade();

	public int showSubMenuPrincipal() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar");
		System.out.println("0 - Sair");

		int opc = Reader.readInt();

		return opc;
	}

	public int showSubMenuCadastrar() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Medico");
		System.out.println("2 - Enfermeiro");
		System.out.println("3 - Auxiliar Administrativo");
		System.out.println("0 - Voltar");

		int opc = Reader.readInt();

		return opc;
	}

	public Pessoa showCadastrar(HashMap<Integer, Especialidade> especialidades) throws Exception {

		int opc = showSubMenuCadastrar();

		System.out.print("Nome: ");
		String nome = Reader.readString();

		System.out.print("Data de Nascimento (DD/MM/YYYY): ");
		String dtNascimento = Reader.readString();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("CPF: ");
		String cpf = Reader.readString();

		System.out.print("Sexo: ");
		String sexo = Reader.readString();

		System.out.print("Telefone: ");
		String telefone = Reader.readString();

		Pessoa p = null;

		if (opc == 1) {
			int esp = -1;
			System.out.println("Especialidade: ");
			do {
				System.out.println("informe uma opcao:");
				cEspecialidade.Listar(especialidades);
				esp = Reader.readInt();
			} while (!especialidades.containsKey(esp));

			p = new Medico(nome, sdf.parse(dtNascimento), cpf, sexo, telefone, esp);

		} else if (opc == 2) {
			System.out.println("Carga Horaria: ");
			int cargaHoraria = Reader.readInt();
			p = new Enfermeiro(nome, sdf.parse(dtNascimento), cpf, sexo, telefone, cargaHoraria);

		} else {
			System.out.println("Salario: ");
			double salario = Reader.readDouble();
			p = new AuxiliarAdministrativo(nome, sdf.parse(dtNascimento), cpf, sexo, telefone, salario);
		}
		return p;
	}

	public void showPessoa(Pessoa p) {
		System.out.println(p);
	}
}
