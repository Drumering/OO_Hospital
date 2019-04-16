package br.com.opet.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.opet.util.Reader;

import br.com.opet.controller.ControllerEspecialidade;
import br.com.opet.model.AuxiliarAdministrativo;
import br.com.opet.model.Enfermeiro;
import br.com.opet.model.Medico;
import br.com.opet.model.top.Pessoa;

public class TelaPessoa {

	ControllerEspecialidade cEspecialidade = new ControllerEspecialidade();

	public int showSubMenuPrincipal() {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("0 - Sair");

		int opc = -1;
		try {
			opc = Reader.readInt();
			return opc;
		} catch (Exception e) {
			System.out.println("Opcao Invalida, informe o numero correspondente a opcao");
			return opc;
		}
	}

	public int showSubMenuCadastrar() {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Medico");
		System.out.println("2 - Enfermeiro");
		System.out.println("3 - Auxiliar Administrativo");
		System.out.println("0 - Voltar");

		int opc = -1;
		try {
			opc = Reader.readInt();
		} catch (Exception e) {
			System.out.println("O valor informado deve ser um numero inteiro");
		}

		return opc;
	}

	public String showRecuperarPessoa() {
		System.out.println("Informe o CPF da Pessoa (999.999.999-99)");
		System.out.println("=================");
		String cpf = Reader.readString();

		while (cpf.split(".").length != 3 && cpf.split("-").length != 2) {
			System.out.println("Informe o CPF no padrao (999.999.999-99)");
			cpf = Reader.readString();
		}
		return cpf;
	}

	public int showMenuAlterar() {
		int opc = -1;
		System.out.println("=============");
		System.out.println("Quais dados deseja alterar?");
		System.out.println("1 - Nome");
		System.out.println("2 - Sexo");
		System.out.println("3 - Data de Nascimento");
		System.out.println("4 - Telefone:");
		System.out.println("0 - Voltar");
		System.out.println("=============");

		try {
			opc = Reader.readInt();
		} catch (Exception e) {
			System.out.println("A opcao informada precisa ser um numero");
		}

		return opc;
	}

	public int showMenuDeletar() {
		int opc = -1;
		System.out.println("=============");
		System.out.println("Informe a confirmacao de DELETE");
		System.out.println("Confirma DELETE da pessoa?");
		System.out.println("=============");

		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		System.out.println("0 - Voltar");

		try {
			opc = Reader.readInt();
		} catch (Exception e) {
			System.out.println("A opcao deve ser informado no padrao numerico!");
		}
		
		if(opc == 2) {
			System.out.println("Cancelando operacao");
		}

		return opc;
	}

	public Pessoa showAlterar(Pessoa p, int opc) {

		switch (opc) {
		case 1:
			System.out.println("Informe o NOME: ");
			String newNome = Reader.readString();
			p.setNome(newNome);
			break;
		case 2:
			System.out.println("Informe o Sexo: ");
			String newSexo = Reader.readString();
			p.setSexo(newSexo);
			break;
		case 3:
			System.out.print("Data de Nascimento (DD/MM/YYYY): ");
			String dtNascimento = Reader.readString();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				p.setDtNascimento(sdf.parse(dtNascimento));
			} catch (ParseException e) {
				System.out.println("Data de nascimento deve ser no formato (DD/MM/YYYY)");
			}
			break;
		case 4:
			System.out.println("Informe o Telefone: ");
			String newTelefone = Reader.readString();
			p.setSexo(newTelefone);
			break;
		default:
			break;
		}
		return p;
	}

	public Pessoa showCadastrar() {

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
			ArrayList<Integer> idEspecialidade = cEspecialidade.Listar();
			System.out.println("Especialidade: ");
			do {
				System.out.println("informe uma opcao:");
				cEspecialidade.Listar();
				try {
					esp = Reader.readInt();
				} catch (Exception e) {
					System.out.println("O valor informado deve ser um numero inteiro");
				}
			} while (!idEspecialidade.contains(esp));

			try {
				p = new Medico(opc, nome, sdf.parse(dtNascimento), cpf, sexo, telefone, esp);
			} catch (ParseException e) {
				System.out.println("O formato da data de nascimento deve ser dd/MM/yyyy");
			}

		} else if (opc == 2) {
			System.out.println("Carga Horaria: ");
			int cargaHoraria = -1;
			try {
				cargaHoraria = Reader.readInt();
			} catch (Exception e) {
				System.out.println("O valor informado deve ser um numero inteiro");
			}
			try {
				p = new Enfermeiro(opc, nome, sdf.parse(dtNascimento), cpf, sexo, telefone, cargaHoraria);
			} catch (ParseException e) {
				System.out.println("O formato da data de nascimento deve ser dd/MM/yyyy");
			}

		} else {
			System.out.println("Salario: ");
			double salario = -1;
			try {
				salario = Reader.readDouble();
			} catch (Exception e) {
				System.out.println("O valor informado deve ser no formato 9.99");
			}
			try {
				p = new AuxiliarAdministrativo(opc, nome, sdf.parse(dtNascimento), cpf, sexo, telefone, salario);
			} catch (ParseException e) {
				System.out.println("O formato da data de nascimento deve ser dd/MM/yyyy");
			}
		}
		return p;
	}

	public void showPessoa(Pessoa p) {
		System.out.println(p);
	}
}
