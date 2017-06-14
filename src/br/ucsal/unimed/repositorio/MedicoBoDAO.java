package br.ucsal.unimed.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ucsal.unimed.dominio.Agenda;
import br.ucsal.unimed.dominio.Medico;
import br.ucsal.unimed.dominio.Paciente;
import br.ucsal.unimed.regras.MedicoBO;

public class MedicoBoDAO {


	public Medico pesquisarMedicoNome(String nome) {
		Medico m = new Medico();
		m.setNome("nome");
		m.setCrm("crm");
		List<Agenda> agendaMedico = new ArrayList<>();
		Agenda a = new Agenda();
		a.setData(new Date());
		agendaMedico.add(a);		
		m.setAgendaMedico(agendaMedico);
		return m;
	}

	public Medico pesquisarMedicoBoCrm(String crm) {
		Medico m = new Medico();
		m.setNome("sfdfsdfsdf");
		m.setNome("crm");
		return m;
	}

	public void adicionarMedicoBo(String nome, String crm, List<Agenda> agendaMedico) {
		Medico m = new Medico();
		m.setAgendaMedico(agendaMedico);
		m.setCrm(crm.trim().toUpperCase());
		m.setNome(nome.trim().toUpperCase());
		//medicosbo.add(new MedicoBO(m));
	}

	public void removerMedicoBo(String crm) {
		//medicosbo.remove(pesquisarMedicoBoCrm(crm.trim().toUpperCase()));
	}

}
