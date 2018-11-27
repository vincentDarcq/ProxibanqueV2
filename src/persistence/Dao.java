package persistence;

import metier.Client;

public interface Dao<T> {

//	read est la méthode du CRUD pour lire une ligne de la table client
	public T read(Integer id);
	
//	update est la méthode du CRUD pour modifier un attribut dans la table client.
	public T update(T id);
	
	
}
