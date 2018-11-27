package metier;

import persistence.ClientDao;

public class AccountService {
	
	private static final AccountService INSTANCE = new AccountService();
	
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	private ClientDao dao;
	
	public void Transfer(Integer id) {
		this.dao.Transfer(id);
	}
}
