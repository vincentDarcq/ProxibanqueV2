package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ClientService;

public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Récupération du singleton d'ArticleService
		ClientService service = ClientService.getInstance();
		//Ajout d'un attribut de requête comportant la liste des clients.
		//La clé "clients" utilisée permettra l'utilisation de l'expression
		//$(clients) dans la index.jsp
		req.setAttribute("clients", service.getAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/Index.jsp").forward(req, resp);
	}

}
