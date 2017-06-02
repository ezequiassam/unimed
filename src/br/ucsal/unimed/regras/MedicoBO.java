package br.ucsal.unimed.regras;

import java.sql.Date;
import java.util.List;

import br.ucsal.unimed.dominio.Agenda;
import br.ucsal.unimed.dominio.Medico;
import br.ucsal.unimed.excecoes.DataIndisponivel;

public class MedicoBO {

	private static List<Agenda> agendaMedico;
	private static Medico medico;

	public MedicoBO(Medico medico) {
		this.medico = medico;
		agendaMedico = medico.getAgendaMedico();
	}

	public static Medico getMedico() {
		return medico;
	}

	public void adicionarData(Date data) throws DataIndisponivel {
		Agenda a = new Agenda();
		a.setData(data);
		if (!agendaMedico.contains(a)) {
			agendaMedico.add(a);
		} else {
			throw new DataIndisponivel();
		}
	}

	public void removerData(Date data) throws DataIndisponivel {
		for (Agenda agenda2 : agendaMedico) {
			if (agenda2.getData().equals(data) && agenda2.getDisponivel() == false) {
				agendaMedico.remove(agenda2);
			} else {
				throw new DataIndisponivel();
			}
		}
	}

	public void adicionarAgenda(Agenda agenda) {
		if (!agendaMedico.contains(agenda)) {
			agendaMedico.add(agenda);
		}
	}

	public List<Agenda> getAgendaDispinivel() {
		List<Agenda> a = null;
		for (Agenda agenda : agendaMedico) {
			if (agenda.getDisponivel().equals(false)) {
				a.add(agenda);
			}
		}
		return a;
	}

	public List<Agenda> getAgenda() {
		return agendaMedico;
	}

}
