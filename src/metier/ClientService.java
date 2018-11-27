package metier;

import java.util.List;

import persistence.ClientDao;

/**
 * Classe réalisant des liens ou ponts entre la couche métier et la couche Persistence
 * @author Adminl
 *
 */
public class ClientService {

	private static final ClientService INSTANCE = new ClientService();

	/**méthode qui récupère le singleton.
	 * @return
	 */
	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}

	private final ClientDao dao;

	/**
	 * Constructeur d'initialisation.
	 */
	public ClientService() {
		this.dao = new ClientDao();
	}


	/**
	 * Cette méthode est un pont vers la méthode readAll, on l'utilise en liant
	 * getAll à notre liste de Clients.
	 * 
	 * @return
	 */
	public List<Client> getAll() {
		return this.dao.readAll();
	}


	/**
	 * updateClient est la méthode qui prend en paramètre tous les attributs d'un
	 * client, y compris l'id. Un seul des attributs peut être changé, ou tous.
	 * 
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param address
	 */
	public void updateClient(Integer id, String firstname, String lastname, String email, String address) {
		Client client = new Client(id, firstname, lastname, email, address);
		this.dao.update(client);

	}

	/**
	 * getClient est un pont vers la méthode read qui lit une ligne de la table
	 * client. Elle fait le lien entre la méthode de la dao et la servlet.
	 * 
	 * @param id
	 * @return
	 */

	public Object getClient(Integer id) {
		return this.dao.read(id);
	}
}
