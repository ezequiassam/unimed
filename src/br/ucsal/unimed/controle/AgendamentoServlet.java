package br.ucsal.unimed.controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import br.ucsal.unimed.dominio.Agenda;
import br.ucsal.unimed.dominio.Medico;
import br.ucsal.unimed.dominio.Paciente;

/**
 * Servlet implementation class AgendamentoServlet
 */
@WebServlet("/AgendamentoServlet")
public class AgendamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgendamentoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Medico medico = (Medico) request.getAttribute("medico");
		Paciente paciente = (Paciente) request.getAttribute("paciente");
		String data = request.getParameter("data");
		Date dataFormatada = null;
		try {
			dataFormatada = new SimpleDateFormat().parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Agenda agd : medico.getAgendaMedico()) {
			if (agd.getData().equals(dataFormatada)) {
				Agenda a = new Agenda();
				a.setData(dataFormatada);
				a.setDisponivel(false);
				a.setPaciente(paciente);
				break;
			}
		}
	}

}
