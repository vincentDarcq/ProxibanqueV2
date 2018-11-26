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
	
	public void updateClient(Integer id) {
		this.dao.update(id);
	}
	
	public List<Client> getAll() {
		return this.dao.readAll();
		
	}
	
	} 
