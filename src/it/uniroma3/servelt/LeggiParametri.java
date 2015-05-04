package it.uniroma3.servelt;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;

@WebServlet("/processaDati")
public class LeggiParametri extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo i parametri
		String nome = request.getParameter("nome").toUpperCase();
		String cognome = request.getParameter("cognome").toUpperCase();


		// Metto i valori nella sessione
		HttpSession session = request.getSession();
		session.setAttribute("NOME", nome);
		session.setAttribute("COGNOME", cognome);

		//inoltro
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/confermaDati");
		rd.forward(request,response);
		return;
	}
}	 
