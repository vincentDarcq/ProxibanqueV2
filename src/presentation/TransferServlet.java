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
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(req,  resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Integer id = Integer.parseInt(req.getParameter("id"));
		String number = req.getParameter("compte à débiter");
		String number2 = req.getParameter("compte à créditer");
		AccountService service = AccountService.getInstance();
		service.Transfer(id);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}

}
