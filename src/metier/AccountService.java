package metier;

import persistence.AccountDao;

public class AccountService{
	
	private static final AccountService INSTANCE = new AccountService();
	
	/**méthode qui récupère le singleton.
	 * @return
	 */
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	private final AccountDao dao;
	
	/**
	 * Constructeur d'initialisation
	 */
	public AccountService() {
		this.dao = new AccountDao();
	}


	/**méthode permettant d'effectuer le transfert de compte à compte.
	 * @param debit
	 * @param credit
	 * @param amount
	 * @return
	 */
	public boolean Transfer(String debit, String credit, Float amount) {
		Account d = this.dao.read(Integer.parseInt(debit));
		Account c = this.dao.read(Integer.parseInt(credit));
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


	/**méthode qui redirige vers la méthode de mise à jour d'un compte.
	 * @param account
	 */
	public void updateAccount (Account account) {
	
		this.dao.update(account);
		}
	
	public Object getAccount(Integer id) {
		return this.dao.read(id);
	} 
 
}
