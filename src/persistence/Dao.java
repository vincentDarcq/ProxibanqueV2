package persistence;

public interface Dao<T> {

	public T read(Integer id);
	
	public T update(Integer id);
	
	public T Transfer(Integer id);
	
}
