package metier;

import persistence.ClientDao;

public class AccountService {
	
	private static final AccountService INSTANCE = new AccountService();
	
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	private ClientDao dao;


	public void Transfer(Integer idCompte1, Integer idCompte2, String compteA, String compteB, float amount) {
		this.dao.Transfer(idCompte1, idCompte2, compteA, compteB, amount);
		
	}
}
