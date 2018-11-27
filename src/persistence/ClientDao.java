package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import metier.Client;

public class ClientDao implements Dao<Client>{

	private MySqlConnection mysqlConn;
	
	public ClientDao() {
		this.mysqlConn = MySqlConnection.getInstance();
	}
	


	@Override
	public Client Transfer(String number, String number2) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQuerries.READ_ALL_CLIENT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Client> readAll() {
		List<Client> clients = new ArrayList<>();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQuerries.READ_ALL_CLIENT);
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String fn = rs.getString("firstname");
				String ln = rs.getString("lastname");
				String email = rs.getString("email");
				String adress = rs.getString("address");
				clients.add(new Client(fn, ln, email, adress));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients; 
	}

	@Override
	public Client read(Integer id) {
		Client client = new Client();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQuerries.READ_ALL_CLIENT);
			while(rs.next()) {
				String fn = rs.getString("firstname");
				String ln = rs.getString("lastname");
				String email = rs.getString("email");
				String adress = rs.getString("address");
				client.setFirstname(fn); client.setLastname(ln); client.setEmail(email); client.setAddress(adress);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}


	@Override
	public Client update(Client entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String queryFirstname = String.format(SqlQuerries.UPDATE_CLIENT, "firstname", entity.getFirstname(), entity.getId());
			String queryLastname = String.format(SqlQuerries.UPDATE_CLIENT, "lastname", entity.getLastname(), entity.getId());
			String queryEmail = String.format(SqlQuerries.UPDATE_CLIENT, "email", entity.getEmail(), entity.getId());
			String queryAddress= String.format(SqlQuerries.UPDATE_CLIENT, "adresse", entity.getAddress(), entity.getId());
			st.execute(queryFirstname);
			st.execute(queryLastname);
			st.execute(queryEmail);
			st.execute(queryAddress);
		} catch (SQLException e) { 
			e.printStackTrace();
					}
		return entity; 
	}
}
