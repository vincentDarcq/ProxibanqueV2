package persistence;

public class SqlQuerries {
	
	public static final String READ_ALL_CLIENT = "SELECT * FROM Client;";
	
	public static final String UPDATE_CLIENT = "UPDATE %s FROM CLIENT WHERE ID=%s;";

}
