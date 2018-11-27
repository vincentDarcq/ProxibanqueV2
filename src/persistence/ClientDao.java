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

	public Client Transfer(Integer id) {
		return null;

	}

	public Client update(Client entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String queryFirstname = String.format(SqlQuerries.UPDATE_CLIENT, "firstname", entity.getFirstname(),
					entity.getId());
			String queryLastname = String.format(SqlQuerries.UPDATE_CLIENT, "lastname", entity.getLastname(),
					entity.getId());
			String queryEmail = String.format(SqlQuerries.UPDATE_CLIENT, "firstname", entity.getEmail(),
					entity.getId());
			String queryAddress = String.format(SqlQuerries.UPDATE_CLIENT, "firstname", entity.getAddress(),
					entity.getId());
			st.executeQuery(queryFirstname);
			st.executeQuery(queryLastname);
			st.executeQuery(queryEmail);
			st.executeQuery(queryAddress);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

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
				clients.add(new Client(fn, lt, email, adress));
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
			while (rs.next()) {
				String fn = rs.getString("firstname");
				String lt = rs.getString("lastname");
				String email = rs.getString("email");
				String adress = rs.getString("address");
				client.setFirstname(fn);
				client.setLastname(lt);
				client.setEmail(email);
				client.setAddress(adress);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

}
