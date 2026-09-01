package test;

/**
 * Transient is a variables modifier used in serialization. At the 
 * time of serialization, if we don’t want to save value of a 
 * particular variable in a file, then we use transient keyword. 
 * When JVM comes across transient keyword, it ignores original value 
 * of the variable and save default value of that variable data type.
 * 
 * Transient and static: 
 * 		Since static fields are not part of state of the object, there is 
 * 		no use/impact of using transient keyword with static variables. 
 * 		However there is no compilation error.
 * 
 * Transient and final: 
 * 		final variables are directly serialized by their values, so there 
 * 		is no use/impact of declaring final variable as transient. There 
 * 		is no compile-time error though.
 */

import java.io.*;

//The class must implement Serializable to be converted into a byte stream
class UserAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username;
	
	// This field will NOT be saved or transmitted
	private transient String password; 
 
	// This field will also NOT be saved
	private transient int loginAttempts;
	
    transient static int transient_static_int = -1; 
    transient final int transient_final_int = 50;

	
	public UserAccount(String username, String password, int loginAttempts, int transient_static_int) {
		this.username = username;
		this.password = password;
		this.loginAttempts = loginAttempts;
		this.transient_static_int = transient_static_int;
	}

	@Override
	public String toString() {
		return "UserAccount{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", loginAttempts=" + loginAttempts + '\'' +
				", transient_static_int=" + transient_static_int + '\'' +
				", transient_final_int=" + transient_final_int +
				'}';
	}
}

public class Transient_and_serialization {
	public static void main(String[] args) {
		UserAccount originalUser = new UserAccount("Alice", "SuperSecret123", 5, 30);
		String filename = "user.ser";

		System.out.println("Before Serialization: " + originalUser);

		// 1. Serialize the object to a file
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(originalUser);
			System.out.println("Object has been serialized successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2. Deserialize the object back from the file
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			UserAccount deserializedUser = (UserAccount) in.readObject();
        
			System.out.println("\nAfter Deserialization:");
			System.out.println("Deserialized: " + deserializedUser);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

/** 
 * Results:
 * Before Serialization: 
 * UserAccount{username='Alice', password='SuperSecret123', loginAttempts=5', transient_static_int=30', transient_final_int=50} 
 * Object has been serialized successfully.
 * After Deserialization:
 * Deserialized: UserAccount{username='Alice', password='null', loginAttempts=0', transient_static_int=30', transient_final_int=50}
 */
 