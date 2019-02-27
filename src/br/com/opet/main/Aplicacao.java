package br.com.opet.main;

import java.text.SimpleDateFormat;

import com.opet.util.Reader;

import br.com.opet.modelo.Pessoa;
import br.com.opet.rh.AuxiliarAdministrativo;
import br.com.opet.rh.Enfermeiro;
import br.com.opet.rh.Medico;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		Pessoa lPessoa[] = new Pessoa[10];
		int auxPessoa = 0;

		int opc = -1;
		opc = menuPrincipal();
		while (opc != 0) {
			switch (opc) {
			case 1:
				auxPessoa = cadastrar(lPessoa, auxPessoa);
				break;
			case 2:
				consultar(lPessoa, auxPessoa);
				break;
			default:
				System.out.println("Opcao Invalida");
			}
			opc = menuPrincipal();
		}

	}

	public static int menuCadastrar() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Medico");
		System.out.println("2 - Enfermeiro");
		System.out.println("3 - Auxiliar Administrativo");
		System.out.println("0 - Voltar");

		int opc = Reader.readInt();

		return opc;
	}

	public static void consultar(Pessoa lPessoa[], int auxPessoa) {
		for (int i = 0; i < auxPessoa; i++) {
			System.out.println(lPessoa[i].toString());
		}
	}

	public static int cadastrar(Pessoa lPessoa[], int auxPessoa) throws Exception {
		int opc = menuCadastrar();

		while (opc != 0) {
			switch (opc) {
			case 1:
			case 2:
			case 3:
				auxPessoa = telaCadastro(lPessoa, auxPessoa, opc);
				System.out.println("Cadastro a ser implementado!");
				break;
			default:
				System.out.println("Opcao Invalida");
			}
			opc = menuCadastrar();
		}
		return auxPessoa;
	}

	public static int menuPrincipal() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar");
		System.out.println("0 - Sair");

		int opc = Reader.readInt();

		return opc;
	}

	public static int telaCadastro(Pessoa lPessoa[], int auxPessoa, int tipo) throws Exception {
		int indice = lPessoa.length;

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

		if (tipo == 1) {
			Medico medico = new Medico();
			medico.setNome(nome);
			medico.setDtNascimento(sdf.parse(dtNascimento));
			medico.setCpf(cpf);
			medico.setSexo(sexo);
			medico.setTelefone(telefone);
			System.out.println("Especialidade: ");
			String especialidade = Reader.readString();
			medico.setEspecialidade(especialidade);

			lPessoa[auxPessoa] = medico;

		} else if (tipo == 2) {
			Enfermeiro enfermeiro = new Enfermeiro();
			enfermeiro.setNome(nome);
			enfermeiro.setDtNascimento(sdf.parse(dtNascimento));
			enfermeiro.setCpf(cpf);
			enfermeiro.setSexo(sexo);
			enfermeiro.setTelefone(telefone);
			System.out.println("Carga Horaria: ");
			int cargaHoraria = Reader.readInt();
			enfermeiro.setCargaHoraria(cargaHoraria);

			lPessoa[auxPessoa] = enfermeiro;

		} else {
			AuxiliarAdministrativo aux = new AuxiliarAdministrativo();
			aux.setNome(nome);
			aux.setDtNascimento(sdf.parse(dtNascimento));
			aux.setCpf(cpf);
			aux.setSexo(sexo);
			aux.setTelefone(telefone);
			System.out.println("Salario: ");
			double salario = Reader.readDouble();
			aux.setSalario(salario);

			lPessoa[auxPessoa] = aux;

		}
		auxPessoa++;
		return auxPessoa;
	}

}
