package br.ucsal.unimed.regras;

import java.util.Date;
import java.util.List;

import br.ucsal.unimed.dominio.Agenda;
import br.ucsal.unimed.dominio.Paciente;

public class Agendamento {

	public Date agendar(MedicoBO medicoBo, Paciente paciente, Date data) {
		List<Agenda> agendaMedico = medicoBo.getAgenda();
		for (Agenda agenda : agendaMedico) {
			if (agenda.getData().equals(data)) {
				agenda.setDisponivel(false);
				agenda.setPaciente(paciente);
				return agenda.getData();
			}
		}
		return null;
	}
}
