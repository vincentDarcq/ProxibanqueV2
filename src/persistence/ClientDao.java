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
<<<<<<< HEAD
	public Client update(Client entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQuerries.UPDATE_CLIENT);
		} catch (SQLException e) {
			e.printStackTrace();
					}		
		return entity;
	}

	@Override
	public Client Transfer(Integer id) {
		// TODO Auto-generated method stub
=======
	public Client update(Integer id) {
		
>>>>>>> 09cd2bdd4c7728cc80237e54b925516fcb39cd4e
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
