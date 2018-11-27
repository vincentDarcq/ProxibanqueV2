package persistence;

import metier.Client;

public interface Dao<T> {

	public T read(Integer id);
	
	public T update(T id);
	
	Client Transfer(String compteA, String compteB, Float amount);

	
}
