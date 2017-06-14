package br.ucsal.unimed.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.unimed.dominio.Agenda;
import br.ucsal.unimed.dominio.Medico;
import br.ucsal.unimed.regras.MedicoBO;
import br.ucsal.unimed.repositorio.MedicoBoDAO;
import br.ucsal.unimed.tui.UnimedTUI;

/**
 * Servlet implementation class AgendamentoServlet
 */
@WebServlet("/consulta")
public class ConsultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UnimedTUI unTui = new UnimedTUI();
		// unTui.util();
		// System.out.println(MedicoBoDAO.pesquisarMedicoNome("murilo").getMedico().getNome());

		String nome = null;
		// System.out.println("atributo nome =
		// "+request.getParameter("nomeMedico"));
		if (request.getParameter("nomeMedico") != null) {
			nome = (String) request.getParameter("nomeMedico");
			Medico medico = new MedicoBO().buscarMedico(nome);
			// System.out.println(mbo.getMedico().getCrm());
			if (medico != null) {
				request.setAttribute("medico", medico);
				RequestDispatcher d = request.getRequestDispatcher("agendamento.jsp");
				d.forward(request, response);
			} else {
				request.setAttribute("erro", "Medico não Localizado");
				RequestDispatcher d = request.getRequestDispatcher("agendamento.jsp");
				d.forward(request, response);
			}
		} else {
			request.setAttribute("erro", "Medico não Localizado");
			RequestDispatcher d = request.getRequestDispatcher("agendamento.jsp");
			d.forward(request, response);
		}
	}

}
