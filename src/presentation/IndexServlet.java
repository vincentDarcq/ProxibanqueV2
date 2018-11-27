package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ClientService;

public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * doGet de IndexServlet récupère tous les clients de la BDD, grâce à la méthode getAll(), de ClientService
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClientService service = ClientService.getInstance();
		req.setAttribute("clients", service.getAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/Index.jsp").forward(req, resp);
	}

}
