package presentation;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.AccountService;



public class TransferServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet de TransferServlet récupère un Client en fonction de sa PK id.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		AccountService service = AccountService.getInstance();
		req.setAttribute("accounts", service.getAccount(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/Transfer.jsp").forward(req, resp);
	}
	
	/**
	 * doPost envoies les informations données par l'utilisateur dans la table correspondante de la BDD.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String compteA = req.getParameter("compteA");	
		String compteB = req.getParameter("compteB");
		float amount = Float.parseFloat(req.getParameter("montant"));
		AccountService service = AccountService.getInstance();
		service.Transfer(compteA, compteB, amount);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}
}
