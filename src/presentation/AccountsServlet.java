package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.AccountService;


/**Classe permettant l'interaction avec la page web affichant les comptes client.
 * @author Adminl
 *
 */
public class AccountsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * doGet de AccountsServlet récupère un Client en fonction de sa PK id.
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		AccountService service = AccountService.getInstance();
		req.setAttribute("accounts", service.getAccount(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/accounts.jsp").forward(req, resp);
	}

}

