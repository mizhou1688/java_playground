package test;

class Dem {
	private void private_method() {
		System.out.println("Hello this is a private method in parent class");
	}
	public static void static_method() {
		System.out.println("Hello this is a static method in parent class");
	}
	public void non_static_method() {
		System.out.println("Hello this is a non-static method in parent class");
	}
	public void non_static_method0() {
		System.out.println("Hello this is a non-static method0 in parent class");
	}
}
class Sub_dem extends Dem {

	public static void static_method() {
		System.out.println("Hello this is a static method in sub class.");
	}
	public void non_static_method() {
		System.out.println("Hello this is a non-static method in sub class.");
	}
	private void private_method() {
		System.out.println("Hello this is a private method in sub class");
	}
}

public class Subclass_upcasting {

	public static void main(String[] args) {
		/**
		 * Subclass method overwrite superclass method 
		 * Subclass static method hides superclass method 
		 */
		Sub_dem sub_tmp = new Sub_dem();
		//sub_tmp.private_method(); // private_method() is not visible
		Sub_dem.static_method(); // Hello this is a static method in sub class
		sub_tmp.non_static_method(); // Hello this is a non-static method in sub class.
		
		/**
		 * Subclass upcasting: 
		 * static method uses parent class 
		 * non-static method uses subclass
		 * private method is not accessible
		 */
		Dem supper_tmp = sub_tmp;
		//supper_tmp.private_method(); // private_method() is not visible
		Dem.static_method(); //  Hello this is a static method in parent class
		supper_tmp.non_static_method(); // Hello this is a non-static method in sub class.
		
		/**
		 *  Superclass downcasting:	
		 *  Cannot do it unless the instance is a subclass instance
		 * 
		 */
		// supper_tmp = new Dem();
		// sub_tmp = (Sub_dem) supper_tmp;
		// sub_tmp.static_method(); 
		// sub_tmp.non_static_method();
	}
}
