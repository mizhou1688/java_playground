package test;

/**
 * Marker interface in Java 
 * It is an empty interface (no field or methods). Examples of marker 
 * interface are Serializable, Cloneable and Remote interface. All 
 * these interfaces are empty interfaces. 
 */

//Java program to illustrate Cloneable interface 
import java.lang.Cloneable; 
import java.io.*; 

/**
 * By implementing Cloneable interface 
 * we make sure that instances of class A_clone can be cloned.
 */
class A_clone implements Cloneable { 
	int i; 
	String s; 

	// A class constructor 
	public A_clone(int i,String s) { 
    	this.i = i; 
    	this.s = s; 
	}

	// Overriding clone() method 
	// by simply calling Object class's clone() method. 
	@Override
	protected Object clone() throws CloneNotSupportedException { 
		return super.clone(); 
	}
} 

/**
 * Java program to illustrate Serializable interface
 * By implementing Serializable interface
 * we make sure that state of instances of class A_serializable
 * can be saved in a file. 
 */
class A_serializable implements Serializable {
	/**
	 * Java needs a serialVersionUID (SUID) to verify that 
	 * a serialized object and the Java class loading it are 
	 * structurally compatible. It acts as a version control 
	 * mechanism during object deserialization.
	 */
	private static final long serialVersionUID = 1L;
	int i; 
	String s;
	
    // Making password transient for security 
    private transient String password; 

	// A class constructor
	public A_serializable(int i, String s, String p) {
		this.i = i;
		this.s = s;
		this.password = p;
	}
	
	public void print() {
		System.out.println(this.i+" "+this.s+" "+this.password); 
	}
}


public class Marker_interface_clone_serializable_transient_remote {
	public static void main(String[] args) throws CloneNotSupportedException,
		IOException, ClassNotFoundException  { 
		
		A_clone a = new A_clone(20, "Clone GeeksForGeeks");
		// cloning 'a' and holding
		// new cloned object reference in b
		// down-casting as clone() return type is Object
		A_clone b = (A_clone)a.clone();

		if ((a.i == b.i) && (a.s.compareTo(b.s) == 0))
			System.out.println("a and b have identical data");
		else
			System.out.println("a and b have different data");
		System.out.println(b.i + " " + b.s);
		
		A_serializable as = new A_serializable(20,"Serialize GeeksForGeeks", "password"); 
		
		System.out.print("Before Serialize: ");
		as.print();
        
		// Serializing 'as' 
        FileOutputStream fos = new FileOutputStream("xyz.txt"); 
        ObjectOutputStream oos = new ObjectOutputStream(fos); 
        oos.writeObject(as); 
  
        // De-serializing 'as' 
        FileInputStream fis = new FileInputStream("xyz.txt"); 
        ObjectInputStream ois = new ObjectInputStream(fis); 
        A_serializable bs = (A_serializable)ois.readObject();//down-casting object 
  
        System.out.print("After De-serialize: ");
        bs.print();
  
        // closing streams 
        oos.close(); 
        ois.close(); 

	}
}
