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

	public Client update(Client entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQuerries.UPDATE_CLIENT);
		} catch (SQLException e) {
			e.printStackTrace();
					}		
		return entity;
	}

	public Client Transfer(Integer id) {
		return null;
		
	}

	public Client update(Integer id) {
		

		return null;
	}

	public List<Client> readAll() {
		List<Client> clients = new ArrayList<>();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQuerries.READ_ALL_CLIENT);
			while(rs.next()) {
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
		// TODO Auto-generated method stub
		return null;
	}

}
