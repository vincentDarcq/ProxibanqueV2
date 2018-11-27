package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Account;

/**
 * Classe permettant les opérations du CRUD sur les Comptes
 * @author Adminl
 *
 */
public class AccountDao implements Dao<Account>{

	private MySqlConnection mysqlConn;
	
	public AccountDao() {
		this.mysqlConn = MySqlConnection.getInstance();
	}

	/* Méthode permettant de lire un compte client spécifique
	 * @see persistence.Dao#read(java.lang.Integer)
	 */
	@Override
	public Account read(Integer id) {
		Account result = null;
		Statement st;
		try {
			st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQuerries.READ_ACCOUNT, id));
			rs.next();
			String number = rs.getString("compte");
			Float balance = rs.getFloat("balance");
			boolean savings = rs.getString("type").equals("t");
			result = new Account(id, number, balance, savings);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; 
	}
	/**méthode permettant d'afficher la liste des comptes d'un client.
	 * @param id_client
	 * @return
	 */
	public List<Account> readByClient(Integer id_client){
		List<Account> account = new ArrayList<>();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQuerries.READ_ALL_ACCOUNTS, id_client));
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nb = rs.getString("compte");
				Float bl = rs.getFloat("balance");
				Boolean sv = rs.getString("type").equals("t");
				account.add(new Account(id, nb, bl, sv));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	/* méthode permettant de mettre à jour un compte dans la BDD après un virement
	 * @see persistence.Dao#update(java.lang.Object)
	 */
	public Account update(Account account) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String update = String.format(SqlQuerries.UPDATE_ACCOUNT, account.getNumber(), account.getBalance(),account.getId());
			st.execute(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

}
