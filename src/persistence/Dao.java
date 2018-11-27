package persistence;


public interface Dao<T> {

//	read est la méthode du CRUD pour lire une ligne de la table client
	public T read(Integer id);
	
//	update est la méthode du CRUD pour modifier un attribut dans la table client.
	public T update(T id);
	
//	transfer est la méthode faisant les virements compte à compte d'un client
	public T Transfer(Integer id);

	String Transfer(Integer id1, Integer id2, String compteA, String compteB, Float amount);


	
}
