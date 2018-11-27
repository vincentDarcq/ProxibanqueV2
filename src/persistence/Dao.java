package persistence;


public interface Dao<T> {

	public T read(Integer id);
	
	public T update(T id);
	
	String Transfer(Integer id1, Integer id2, String compteA, String compteB, Float amount);

	
}
