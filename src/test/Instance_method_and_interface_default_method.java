package test;

/**
 * Instance methods are preferred over interface default methods. 
 * 
 */

class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}

interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}

interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}

class Pegasus extends Horse implements Flyer, Mythical {}

/**
 *  Methods that are already overridden by other candidates are ignored. 
 * This circumstance can arise when supertypes share a common ancestor. 
 * 
 */

interface Animal {
    default public String identifyMyself() {
        return "I am an animal.";
    }
}

interface EggLayer extends Animal {
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}

interface FireBreather extends Animal { }

class Dragon implements EggLayer, FireBreather { }

/**
 * If two or more independently defined default methods conflict 
 * or a default method conflicts with an abstract method, then 
 * the Java compiler produces a compiler error. You must 
 * explicitly override the supertype methods. 
 * 
 */

class Pegasus1 implements Flyer, Mythical {
	public String identifyMyself() {
		return Flyer.super.identifyMyself() + Mythical.super.identifyMyself();
	}
}


/**
 * Inherited instance methods from classes can override abstract interface methods
 */
interface Mammal {
    String identifyMyself();
}

class Mustang extends Horse implements Mammal {}

/**
 * Static methods in interfaces are never inherited. But static methods in Class are inherited.
 * 
 */



public class Instance_method_and_interface_default_method {
	public static void main(String[] args) {
		Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself()); // I am a horse
        
        Dragon myApp1 = new Dragon();
        System.out.println(myApp1.identifyMyself()); // I am able to lay eggs.
        
		Pegasus1 myApp3 = new Pegasus1();
        System.out.println(myApp3.identifyMyself()); // I am able to fly.I am a mythical creature.
        
        Mustang myApp4 = new Mustang();
        System.out.println(myApp4.identifyMyself()); // I am a horse

	}
}

