package metier;

import java.util.List;

import persistence.ClientDao;

public class ClientService {

	private static final ClientService INSTANCE = new ClientService();

	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}

	private final ClientDao dao;

	public ClientService() {
		this.dao = new ClientDao();
	}

	public List<Client> getAll() {
		return this.dao.readAll();
	}

	public void updateClient(Integer id, String firstname, String lastname, String email, String address) {
		Client client = new Client(id, firstname, lastname, email, address);
		this.dao.update(client);

	}

	public Object getClient(Integer id) {
		return this.dao.read(id);
	}

}
