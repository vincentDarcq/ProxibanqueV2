package persistence;

public interface Dao<T> {

	public T read(Integer id);
	
<<<<<<< HEAD
	public T update(T id);
=======
	public T update(Integer id);
>>>>>>> 09cd2bdd4c7728cc80237e54b925516fcb39cd4e
	
	public T Transfer(Integer id);
	
}
