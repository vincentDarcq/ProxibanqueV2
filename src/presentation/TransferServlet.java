package presentation;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.AccountService;
import metier.ClientService;


public class TransferServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		ClientService service = ClientService.getInstance();
		req.setAttribute("client", service.getClient(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/Transfer.jsp").forward(req,  resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Integer id1 = Integer.parseInt(req.getParameter("id1"));
		String compteA = req.getParameter("compte débiteur");	
		Integer id2 = Integer.parseInt(req.getParameter("id2"));
		String compteB = req.getParameter("compte créditeur");
		float amount = Float.parseFloat(req.getParameter("montant"));
		AccountService service = AccountService.getInstance();
		service.Transfer(id1, id2, compteA, compteB, amount);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}
}
