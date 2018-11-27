package persistence;

public class SqlQuerries {

/**
 * Requête de lecture de la table client
 */
	public static final String READ_ALL_CLIENT = "SELECT * FROM clients;";

/**
 * Resuête de lecture d'une ligne de la table client
 */
	public static final String READ_CLIENT = "SELECT * FROM clients WHERE id=%s;";

/**
 * Requête de Mise à jour d'un ou plusieurs attributs d'un Client
 */
	public static final String UPDATE_CLIENT = "UPDATE clients set %s='%s' WHERE id=%s;";
	
	public static final String READ_ACCOUNT = "SELECT * FROM ACCOUNT WHERE id_client=%s;";
	
	public static final String BALANCE = "SELECT BALANCE FROM ACCOUNT WHERE id=%s;";

	public static final String UPDATE_ACCOUNT = "UPDATE ACCOUNT SET compte='%s', balance='%s',  WHERE id=%s;";
}
