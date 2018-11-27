package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ClientService;

public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * doGet de UpdateServlet récupère un Client en fonction de sa PK id.
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		ClientService service = ClientService.getInstance();
		req.setAttribute("client", service.getClient(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
	}
	
	/**
	 * doPost de UpdateServlet envoie les nouvelles variables à injecter dans la base de données.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		ClientService service = ClientService.getInstance();
		service.updateClient(id, firstname, lastname, email, address);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
		
	}

}
