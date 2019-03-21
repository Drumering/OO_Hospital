package br.com.opet.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.opet.util.Reader;

import br.com.opet.controller.GerenciarEspecialidades;
import br.com.opet.model.Especialidades;
import br.com.opet.model.Medico;

public class TelaCadastroMedico {

	GerenciarEspecialidades gEspecialidades = new GerenciarEspecialidades();

	public Medico showCadastrar() throws Exception {

		System.out.println("===================");
		System.out.println("Informe o NOME do(a) medico(a) a ser cadastrado(a): ");
		String nome = Reader.readString();
		System.out.println("Informe a DATA DE NASCIMENTO (DD/MM/YYYY): ");
		String dtNascimento = Reader.readString();
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date tmp = sdf.parse(dtNascimento);
		System.out.println("Informe o CPF: ");
		String cpf = Reader.readString();
		System.out.println("Informe o SEXO");
		String sexo = Reader.readString();
		System.out.println("Informe o TELEFONE: ");
		String telefone = Reader.readString();
		System.out.println("Informe o ID da especialidade a associar este MEDICO(A)");
		gEspecialidades.listarEspecialidades();
		int especialidade = Reader.readInt();

		Medico m = new Medico(nome, tmp, cpf, sexo, telefone, especialidade);

		return m;
	}

	public void showMedico(Medico m, HashMap<Integer, Especialidades> e) {
		System.out.println(m.getNome() + " - " + m.getDtNascimento() + " - " + m.getCpf() + " - " + m.getSexo() + " - "
				+ m.getTelefone() + " - " + e.get(m.getEspecialidade()));
	}
}
