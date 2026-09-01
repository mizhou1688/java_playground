package test;

//how to access grandparent's method
class Grandparent {
    public void Print1() {
        System.out.println("Grandparent: Print1()");
    }
    
    public void Print() {
        System.out.println("Grandparent: Print()");
    }
}
 
class Parent extends Grandparent {
    public void Print() {
        System.out.println("Parent: Print()");
    }
}
 
class Child extends Parent {
    public void Print()
    {
        // Trying to (can't) access Grandparent's Print()
    	// because it is overridden by class Parent
    	/**
    		super.super.Print();
    	 */
    	
    	// Can access Grandparent's Print1(), it is not overridden
        super.Print1();
        System.out.println("Child: Print()");
    }
}


// Nested interface
class Test {
	// if use private, it cannot access from outside of the class
	protected interface Yes {
        void show();
    }
}
 
class Testing implements Test.Yes {
    public void show() {
        System.out.println("Testing: show()");
    }
}


// abstract class
abstract class Subject {
	Subject() { 
		System.out.println("Subject: Subject()-> Learning Subject"); 
    }
   
    abstract void syllabus();
   
    // cannot overridden
    final void Learn() {
    	System.out.println("Subject: Learn()-> Preparing Right Now!");
    }
}
 
class IT_Subject extends Subject {
	void syllabus() {
	  System.out.println("IT_Subject: syllabus()-> C , Java , C++");
	}
}


// interface with private, static and default method
interface Interface_with_static_default_method {
    final int a = 10;
    // default method
    default void default_method() {
        System.out.println("Interface_with_static_default_method: default_method()");
    }
    // private method
    // static method
    static void static_method() {
        System.out.println("Interface_with_static_default_method: static_method()");
    }
}


public class InterfaceMethods_and_InstanceMethods implements Interface_with_static_default_method {
	// @Override
	public void default_method() {
		// instance method override interface default method
		System.out.println("instance method override interface default method");
	}
	//public void static_method() {
	//	System.out.println("hello3");
	//}
	
	public static void main(String[] args) {
		// Nested interface: means nest interfaces inside a class
        Test.Yes obj;
        Testing testing_tmp = new Testing();
        obj = testing_tmp;
        obj.show(); //output: "Testing: show()"
        // testing_tmp.show();
		
		// access grandparent's method Print1()
		Child child_tmp = new Child();
		child_tmp.Print(); // output: Grandparent: Print1(), Child: Print()
	        
		// reference to the abstract class
	    // Upcasting to an abstract class
		Subject subject_x = new IT_Subject(); // output: Subject: Subject()-> Learning Subject
		//IT_Subject x = new IT_Subject();   
		subject_x.syllabus(); // output: IT_Subject: syllabus()-> C , Java , C++
		subject_x.Learn(); // output: Subject: Learn()-> Preparing Right Now!
		
		try {
			InterfaceMethods_and_InstanceMethods t = new InterfaceMethods_and_InstanceMethods();
			t.default_method(); // output: instance method override interface default method

			// t.static_method(); // Static methods in interfaces are never inherited
			Interface_with_static_default_method.static_method();
		}
		//catch (Exception ex) {}	
		finally {}
	}

}
