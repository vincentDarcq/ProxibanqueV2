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
	
	} 
