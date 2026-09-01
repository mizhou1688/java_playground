package test;

import java.util.ArrayList;

//A generic class with type parameter T (Type)
class Box<T> {
	private T content;
	
	public void set(T content) {
		this.content = content;
	}
	
	public T get() {
		return content;
	}
}

//A generic data repository interface
interface Repository<T> {
	void save(T entity);
	T findById(int id);
}


//Option A: Implement with a Concrete Type
//The type parameter is explicitly bound to String
class StringRepository implements Repository<String> {
	private ArrayList <String> resp;
	
	StringRepository() {
		resp = new ArrayList <>();
	}
	
	@Override
	public void save(String entity) {
		resp.add(entity); /* Code */ 
	}
	
	@Override
	public String findById(int id) {
		if (resp.size() <= id)
			return null;
		else
			return resp.get(id); 
	}
}


//Option B: Implement as a Generic Class
//The implementing class passes its own type parameter through
class BaseRepository<T> implements Repository<T> {
	private ArrayList <T> resp;
	
	BaseRepository() {
		resp = new ArrayList <>();
	}
	
	@Override
	public void save(T entity) { 
		resp.add(entity); /* Code */
	}
	
	@Override
	public T findById(int id) {
		if (resp.size() <= id)
			return null;
		else
			return resp.get(id); 
	}
}


public class Generic_Classes_and_Interfaces {
	public static void main(String[] args) {
		
		//A generic class with type parameter T (Type)
		// The compiler infers the type argument as String
		Box<String> stringBox = new Box<>(); 
		stringBox.set("classT Box<T>");
		System.out.println("Generic Class with type parameter: " + stringBox.get());

		//Option A: Implement with a Concrete Type
		StringRepository stringResp = new StringRepository();
		stringResp.save("Implement with a Concrete Type");
		stringResp.save("class StringRepository implements Repository<String>");
		System.out.println("Option A: Implement with a Concrete Type: "+ stringResp.findById(1));
		
		//Option B: Implement as a Generic Class
		BaseRepository<String> baseResp = new BaseRepository<>();
		baseResp.save("Implement as a Generic Class");
		baseResp.save("class BaseRepository<T> implements Repository<T>");
		System.out.println("Option B: Implement as a Generic Class: " + baseResp.findById(1));
	}

}
