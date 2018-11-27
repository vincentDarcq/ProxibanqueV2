package persistence;


public interface Dao<T> {

	public T read(Integer id);
	
	public T update(T id);
	
	public T Transfer(String number, String number2);

	
}
