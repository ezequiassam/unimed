package br.ucsal.unimed.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.unimed.dominio.Paciente;

public class PacienteDAO {
	private static List<Paciente> pacientes = new ArrayList<>();

	public static Paciente pesquisarPacienteNome(String nome) {
		Paciente p = null;
		for (Paciente paciente : pacientes) {
			if (paciente.getNome().equalsIgnoreCase(nome.trim().toUpperCase())) {
				p = paciente;
			}
		}
		return p;
	}

	public static Paciente pesquisarPacienteCpf(String cpf) {
		Paciente p = null;
		for (Paciente paciente : pacientes) {
			if (paciente.getCpf().equalsIgnoreCase(cpf.trim().toUpperCase())) {
				p = paciente;
			}
		}
		return p;
	}

	public static void adicionarPaciente(String nome, String cpf) {
		Paciente p = new Paciente();
		p.setNome(nome.trim().toUpperCase());
		p.setCpf(cpf.trim().toUpperCase());
		pacientes.add(p);
	}

	public static void removerPaciente(String cpf) {
		pacientes.remove(pesquisarPacienteCpf(cpf.trim().toUpperCase()));
	}
}
