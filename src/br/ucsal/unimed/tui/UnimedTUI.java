package br.ucsal.unimed.tui;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ucsal.unimed.dominio.Agenda;
import br.ucsal.unimed.dominio.Medico;
import br.ucsal.unimed.repositorio.MedicoBoDAO;
import br.ucsal.unimed.repositorio.PacienteDAO;

public class UnimedTUI {

	public UnimedTUI() {
		util();
	}

	// public Medico cadastrarMedico(String nome, String crm) {
	// Medico medico = new Medico();
	// medico.setNome(nome);
	// medico.setCrm(crm);
	// medico.setAgendaMedico(new ArrayList<>());
	// return medico;
	// }

	public void util() {

		String date_s = " 10-05-2017 00:00:00.0";
		String date_f = " 11-05-2017 00:00:00.0";
		String date_g = " 12-05-2017 00:00:00.0";
		String date_h = " 13-05-2017 00:00:00.0";
		SimpleDateFormat dt = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		Date date1 = null;
		Date date2 = null;
		Date date3 = null;
		Date date4 = null;
		try {
			date1 = (Date) dt.parse(date_s);
			date2 = (Date) dt.parse(date_f);
			date3 = (Date) dt.parse(date_g);
			date4 = (Date) dt.parse(date_h);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		PacienteDAO.adicionarPaciente("Ezequias", "652349023");
		PacienteDAO.adicionarPaciente("Vagner", "68413023");
		Agenda ag1 = new Agenda();
		ag1.setData(date1);
		Agenda ag2 = new Agenda();
		ag1.setData(date2);
		Agenda ag3 = new Agenda();
		ag1.setData(date3);
		Agenda ag4 = new Agenda();
		ag1.setData(date4);
		List<Agenda> agendaMedico = new ArrayList<>();
		agendaMedico.add(ag1);
		agendaMedico.add(ag2);
		agendaMedico.add(ag3);
		agendaMedico.add(ag4);
		MedicoBoDAO.adicionarMedicoBo("Murilo", "7956cas", agendaMedico);
	}

}
