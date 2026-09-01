package test;

import java.util.ArrayList;
import java.util.List;

class Geek {
	String name = "";
	public int count = 0;
	
	public void geekName(String geek, List<String> list) {
		// Only one thread is permitted
		// to change geek's name at a time.
		synchronized(this) {
			name = geek;
			count++;  // how many threads change geek's name.
		}
		
		// All threads are permitted to add geek name into list at the same time.
		// since List<String> is not thread-safe, it will cause issues like
		// overwrite each other's data, or corrupt the internal size counter
		list.add(geek);
	} 
}

class Mythread extends Thread {
	String name;
	List<String> namelist;
	Geek obj;
	
	Mythread(String s, List<String> list, Geek gk) {
		name = s + this.getName();
		namelist = list;
		obj = gk;
	}
	
	public void run() {
		obj.geekName(name, namelist);
	}
}

public class Synchronized_thread_safe_unsafe {
	public static void main (String[] args) {
		Geek gk = new Geek();
		List<String> list = new ArrayList<String>();
		Mythread t1 = new Mythread("mohit", list, gk);
		Mythread t2 = new Mythread("mohit", list, gk);
		Mythread t3 = new Mythread("mohit", list, gk);
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		}
		catch (Exception e) {
			System.out.println("Interrupted");
		}
		//gk.geekName("mohit", list);
		System.out.println(gk.name); // output: "mohitThread-1" or "mohitThread-2" or "mohitThread-0"
		System.out.println(gk.count); // output: 3
		System.out.println(list.toString()); // output: can be "[mohitThread-0, mohitThread-2]"
	}
}
