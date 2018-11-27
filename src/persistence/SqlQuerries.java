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
	
	/**
	 * Requête de sélection d'un compte spécifique d'un client
	 */
	
	public static final String READ_ALL_ACCOUNTS = "SELECT * FROM COMPTES_CLIENT WHERE id_client=%s;";
	
	/**
	 * Requête de sélection d'un compte spécifique d'un client 
	 */
	
	public static final String READ_ACCOUNT = "SELECT * FROM COMPTES_CLIENT WHERE id=%s;";
	
	/**
	 * Requête permettant la sélection du solde d'un compte spécifique d'un client.
	 */
	
	public static final String BALANCE = "SELECT BALANCE FROM COMPTES_CLIENT WHERE id=%s;";
	
	/**
	 * Requête permettant la mise à jour d'un compte client après virement.
	 */

	public static final String UPDATE_ACCOUNT = "UPDATE COMPTES_CLIENT SET compte='%s', balance='%s' WHERE id=%s;";
}
