package br.ucsal.unimed.dominio;

import java.util.Date;

public class Agenda {
	private Date data;
	private Boolean disponivel;
	private Paciente paciente;

	public Agenda() {
		disponivel = true;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
