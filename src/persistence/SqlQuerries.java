package persistence;

public class SqlQuerries {
	
	public static final String READ_ALL_CLIENT = "SELECT * FROM clients;";
	
	public static final String UPDATE_CLIENT = "UPDATE clients set %s='%s' where id=%s;";

}
