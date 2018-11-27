package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metier.Account;
import metier.Client;

public class AccountDao implements Dao<Account> {

	private MySqlConnection mysqlConn;
	@Override
	public Account read(Integer id) {
		Account result = null;
		Statement st;
		try {
			st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQuerries.READ_ACCOUNT, id));
			rs.next();
			
			Float balance = rs.getFloat("balance");
			boolean savings = rs.getBoolean("savings");
			result = new Account(id, balance, savings);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
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


	@Override
	public Client Transfer(String compteA, String compteB, Float amount) {
		return null;
	}
}
