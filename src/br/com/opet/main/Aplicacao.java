package br.com.opet.main;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;

import com.opet.util.Reader;

import br.com.opet.modelo.Pessoa;
import br.com.opet.rh.AuxiliarAdministrativo;
import br.com.opet.rh.Enfermeiro;
import br.com.opet.rh.Especialidades;
import br.com.opet.rh.Medico;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		HashSet<Pessoa> lPessoa = new HashSet<Pessoa>();
		HashMap<Integer, String> lEsp = new HashMap<Integer, String>();
		
		Especialidades esp = new Especialidades();
		esp.setNomeEspecialidades("Cardiologia");
		lEsp.put(0, esp.getNomeEspecialidades());
		esp.setNomeEspecialidades("Nutrologia");
		lEsp.put(1, esp.getNomeEspecialidades());
		esp.setNomeEspecialidades("Oftalmologia");
		lEsp.put(2, esp.getNomeEspecialidades());
		esp.setNomeEspecialidades("Oncologia");
		lEsp.put(3, esp.getNomeEspecialidades());
		esp.setNomeEspecialidades("Pediatria");
		lEsp.put(4, esp.getNomeEspecialidades());

		int opc = -1;
		opc = menuPrincipal();
		while (opc != 0) {
			switch (opc) {
			case 1:
				cadastrar(lPessoa, lEsp);
				break;
			case 2:
				consultar(lPessoa);
				break;
			default:
				System.out.println("Opcao Invalida");
			}
			opc = menuPrincipal();
		}

	}

	public static void cadastrarEspecialidade(HashMap<Integer, String> lEsp, Especialidades esp) throws Exception {
		System.out.println("Informe o nome da nova ESPECIALIDADE: ");
		String nomeEspecialidade = Reader.readString();
		esp.setNomeEspecialidades(nomeEspecialidade);

		int idEspecialidade = 0;

		for (int i = 0; i <= lEsp.size(); i++) {
			if (!lEsp.containsKey(idEspecialidade)) {
				lEsp.put(idEspecialidade, esp.getNomeEspecialidades());
				break;
			}
			idEspecialidade++;
		}
	}

	public static void consultarEspecialidade(HashMap<Integer, String> lEsp) {
		System.out.println("Selecione a especialidade");
		for (int i = 0; i < lEsp.size(); i++) {
			System.out.println("|ID: " + i + "|" + "Nome da Especialidade: " + lEsp.get(i) + " |");
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

	public static void consultar(HashSet<Pessoa> lPessoa) {
		for (Pessoa p : lPessoa) {
			System.out.println(p.toString());
		}
	}

	public static void cadastrar(HashSet<Pessoa> lPessoa, HashMap<Integer, String> lEsp) throws Exception {
		int opc = menuCadastrar();

		while (opc != 0) {
			switch (opc) {
			case 1:
			case 2:
			case 3:
				telaCadastro(lPessoa, opc, lEsp);
				System.out.println("Cadastro a ser implementado!");
				break;
			default:
				System.out.println("Opcao Invalida");
			}
			opc = menuCadastrar();
		}
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

	public static void telaCadastro(HashSet<Pessoa> lPessoa, int opc, HashMap<Integer, String> lEsp) throws Exception {

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

		if (opc == 1) {
			Medico medico = new Medico();
			medico.setNome(nome);
			medico.setDtNascimento(sdf.parse(dtNascimento));
			medico.setCpf(cpf);
			medico.setSexo(sexo);
			medico.setTelefone(telefone);
			System.out.println("Especialidade: ");
			int idEsp = 0;
			do {
				consultarEspecialidade(lEsp);
				System.out.println("Informe uma opcao: ");
				idEsp = Reader.readInt();
			} while (!lEsp.containsKey(idEsp));
			
			medico.setEspecialidade(lEsp.get(idEsp));

			lPessoa.add(medico);

		} else if (opc == 2) {
			Enfermeiro enfermeiro = new Enfermeiro();
			enfermeiro.setNome(nome);
			enfermeiro.setDtNascimento(sdf.parse(dtNascimento));
			enfermeiro.setCpf(cpf);
			enfermeiro.setSexo(sexo);
			enfermeiro.setTelefone(telefone);
			System.out.println("Carga Horaria: ");
			int cargaHoraria = Reader.readInt();
			enfermeiro.setCargaHoraria(cargaHoraria);

			lPessoa.add(enfermeiro);

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

			lPessoa.add(aux);

		}
	}

}
