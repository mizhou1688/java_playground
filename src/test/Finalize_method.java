package test;
/** Finalize method
 * It is a method that the Garbage Collector always calls 
 * just before the deletion/destroying of the object which 
 * is eligible for Garbage Collection, so as to perform 
 * clean-up activity.
 * 
 */
public class Finalize_method {
	public static void main(String[] args) {
		Finalize_method m = new Finalize_method();
 
        // Calling finalize method Explicitly.
        m.finalize();
        m.finalize();
        m = null;
 
        // Requesting JVM to call Garbage Collector method
        System.gc();
        System.out.println("Main Completes");
    }
 
    // Here overriding finalize method
    public void finalize() {
        System.out.println("finalize method overridden");
    }
}
