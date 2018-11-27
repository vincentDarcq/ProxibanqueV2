package persistence;

import metier.Client;

/**
 * Interface de déploiement 
 * @author Adminl
 *
 * @param <T>
 */
public interface Dao<T> {

//	read est la méthode du CRUD pour lire une ligne de la table client
	public T read(Integer id);
	
//	update est la méthode du CRUD pour modifier un attribut dans la table client.
	public T update(T id);
	
	
}
