package metier;

import persistence.ClientDao;

public class AccountService {

	private static final AccountService INSTANCE = new AccountService();
	
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	private ClientDao dao;
	
	public void Transfer(String number, String number2) {
		this.dao.Transfer(number, number2);
	}
}
