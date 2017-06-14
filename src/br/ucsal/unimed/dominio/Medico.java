package br.ucsal.unimed.dominio;

import java.util.ArrayList;
import java.util.List;

public class Medico {
	private List<Agenda> agendaMedico = new ArrayList<>();
	private String nome;
	private String crm;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<Agenda> getAgendaMedico() {
		return agendaMedico;
	}

	public void setAgendaMedico(List<Agenda> agendaMedico) {
		this.agendaMedico = agendaMedico;
	}
}
