package br.ucsal.unimed.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.unimed.dominio.Agenda;
import br.ucsal.unimed.dominio.Medico;
import br.ucsal.unimed.dominio.Paciente;
import br.ucsal.unimed.regras.MedicoBO;

public class MedicoBoDAO {
	private static List<MedicoBO> medicosbo = new ArrayList<>();

	public static MedicoBO pesquisarMedicoNome(String nome) {
		MedicoBO mbo = null;
		for (MedicoBO medicoBO : medicosbo) {
			if (medicoBO.getMedico().getNome().equalsIgnoreCase(nome.trim().toUpperCase())) {
				mbo = medicoBO;
			}
		}
		return mbo;
	}

	public static MedicoBO pesquisarMedicoBoCrm(String crm) {
		MedicoBO mbo = null;
		for (MedicoBO medicoBO : medicosbo) {
			if (medicoBO.getMedico().getNome().equalsIgnoreCase(crm.trim().toUpperCase())) {
				mbo = medicoBO;
			}
		}
		return mbo;
	}

	public static void adicionarMedicoBo(String nome, String crm, List<Agenda> agendaMedico) {
		Medico m = new Medico();
		m.setAgendaMedico(agendaMedico);
		m.setCrm(crm.trim().toUpperCase());
		m.setNome(nome.trim().toUpperCase());
		medicosbo.add(new MedicoBO(m));
	}

	public static void removerMedicoBo(String crm) {
		medicosbo.remove(pesquisarMedicoBoCrm(crm.trim().toUpperCase()));
	}

}
