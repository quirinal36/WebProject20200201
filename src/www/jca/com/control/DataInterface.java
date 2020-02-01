package www.jca.com.control;

import java.util.List;

public interface DataInterface <T>{
	public T selectOne(T param);
	public int insert(T param);
	public int update(T param);
	public int delete(T param);
	public List<T> selectList(T param);
}
