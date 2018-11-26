package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ClientService;

public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strId = req.getParameter("id");
		Integer id = Integer.parseInt(strId);
		ClientService.getInstance().updateClient(null);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
		
	}

}
