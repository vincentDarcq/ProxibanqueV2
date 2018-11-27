package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import metier.Client;

public class ClientDao implements Dao<Client> {

	private MySqlConnection mysqlConn;

	public ClientDao() {
		this.mysqlConn = MySqlConnection.getInstance();
	}

/**
 * Cette méthode lit tous les clients dans la BDD.
 */
	public List<Client> readAll() {
		List<Client> clients = new ArrayList<>();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQuerries.READ_ALL_CLIENT);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String fn = rs.getString("firstname");
				String lt = rs.getString("lastname");
				String email = rs.getString("email");
				String adress = rs.getString("address");
				clients.add(new Client(id, fn, lt, email, adress));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}
	
	/**
	 * Cette méthode lit un client spécifique dans la Bdd.
	 */

	@Override
	public Client read(Integer id) {
		Client client = new Client();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQuerries.READ_CLIENT, id));

			while(rs.next()) {

				String fn = rs.getString("firstname");
				String ln = rs.getString("lastname");
				String email = rs.getString("email");
				String adress = rs.getString("address");

				client = new Client(fn, ln, email, adress);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	/**
	 * Update sert à modifier un attribut spécifique d'un client présent dans la BDD.
	 */
	public Client update(Client entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String queryFirstname = String.format(SqlQuerries.UPDATE_CLIENT, "firstname", entity.getFirstname(),
					entity.getId());
			String queryLastname = String.format(SqlQuerries.UPDATE_CLIENT, "lastname", entity.getLastname(),
					entity.getId());
			String queryEmail = String.format(SqlQuerries.UPDATE_CLIENT, "email", entity.getEmail(),
					entity.getId());
			String queryAddress = String.format(SqlQuerries.UPDATE_CLIENT, "address", entity.getAddress(),
					entity.getId());
			st.execute(queryFirstname);
			st.execute(queryLastname);
			st.execute(queryEmail); 
			st.execute(queryAddress);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public String Transfer(Integer id1, Integer id2,String compteA, String compteB, Float amount) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String queryCompteA = String.format(SqlQuerries.BALANCE, id1);
			st.execute(queryCompteA);
			String queryCompteB = String.format(SqlQuerries.BALANCE, id2);
			st.execute(queryCompteB);
			Float newCompteA =  Float.parseFloat(queryCompteA) - amount;
			Float newCompteB =  Float.parseFloat(queryCompteB) + amount;
			String updateBalanceA = String.format(SqlQuerries.UPDATE_BALANCE, newCompteA, id1);
			st.execute(updateBalanceA);
			String updateBalanceB = String.format(SqlQuerries.UPDATE_BALANCE, newCompteB, id2);
			st.execute(updateBalanceB);
		} catch (SQLException e) {
			e.printStackTrace();
		}		return compteB;
	}

	@Override
	public Client Transfer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	} 

