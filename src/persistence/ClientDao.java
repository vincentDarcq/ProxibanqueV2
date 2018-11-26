package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import metier.Client;

public class ClientDao implements Dao<Client>{

	private MySqlConnection mysqlConn;
	
	@Override
	public Client read(Integer id) {
//		List<Client> results = new ArrayList<>();
//		try {
//			Statement st = this.mysqlConn.getConn().createStatement();
//			ResultSet rs = st.executeQuery(SqlQuerries.READ_ALL_CLIENT);
//			while(rs.next()) {
//				Integer id = rs.getInt("id");
//				String title = rs.getString("title");
//				String content = rs.getString("content");
//				results.add(new Client(id, title, content));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return results; 
		return null;
	}

	@Override
	public Client update(Client entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client Transfer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
