package presentation;


import java.io.IOException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.AccountService;
import metier.ClientService;



public class TransferServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(TransferServlet.class);
 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		ClientService service = ClientService.getInstance();
		req.setAttribute("client", service.getClient(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(req,  resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String compteA = req.getParameter("compte débiteur");	
		String compteB = req.getParameter("compte créditeur");
		float amount = Float.parseFloat(req.getParameter("montant"));
		AccountService service = AccountService.getInstance();
		req.setAttribute("compte débiteur", compteA);
		req.setAttribute("compte créditeur", compteB);
		req.setAttribute("montant", amount);
		String message = "montant supérieur au solde disponible.";
		if(!service.Transfer(compteA, compteB, amount)) {
			TransferServlet.LOGGER.info(message);
			req.setAttribute("message",  message);
			this.doGet(req, resp);
		}
		else {
			this.doGet(req, resp);
		}
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}
}
