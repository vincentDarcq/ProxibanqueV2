package metier;

import persistence.AccountDao;

public class AccountService{
	
	private static final AccountService INSTANCE = new AccountService();
	
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	private final AccountDao dao;
	
	public AccountService() {
		this.dao = new AccountDao();
	}


	public boolean Transfer(String debit, String credit, Float amount) {
		Account d = this.dao.read(debit);
		Account c = this.dao.read(credit);
		Float soldeD = d.getBalance();
		Float soldeC = c.getBalance();
		if(soldeD-amount<0)return false;
		else {
			d.setBalance(soldeD-amount);
			c.setBalance(soldeC+amount);
			this.updateAccount(d);
			this.updateAccount(c);
			return true;
		}
	}


public void updateAccount (Account account) {
	this.dao.update(account);
}


public Object getAccount(Integer id) {
	return this.dao.read(id);
}
 
}
