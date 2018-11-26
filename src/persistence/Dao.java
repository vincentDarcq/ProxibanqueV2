package persistence;

public interface Dao<T> {

	public T read(Integer id);
	
	public T update(T entity);
	
	public T Transfer(Integer id);
	
}
